package ru.mertech.sbpskb.bluetooth

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattService
import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import no.nordicsemi.android.ble.BleManager
import no.nordicsemi.android.ble.WriteRequest
import no.nordicsemi.android.ble.ktx.suspend
import ru.mertech.sbpskb.Constants.BATTERY_LEVEL_CHARACTERISTIC_UUID
import ru.mertech.sbpskb.Constants.BATTERY_SERVICE_UUID
import ru.mertech.sbpskb.Constants.UART_RX_CHARACTERISTIC_UUID
import ru.mertech.sbpskb.Constants.UART_SERVICE_UUID
import ru.mertech.sbpskb.Constants.UART_TX_CHARACTERISTIC_UUID


const val TAG = "ru.mertech.qrpay"

class QrDisplayManager(
    context: Context,
    private val scope: CoroutineScope
) : BleManager(context) {

    private var batteryLevelCharacteristic: BluetoothGattCharacteristic? = null

    private var rxCharacteristic: BluetoothGattCharacteristic? = null
    private var txCharacteristic: BluetoothGattCharacteristic? = null

    private var useLongWrite = true

    private val data = MutableStateFlow(BTData())
    private val dataHolder = ConnectionObserverAdapter<BTData>()

    init {
        connectionObserver = dataHolder

        data.onEach {
            dataHolder.setValue(it)
        }.launchIn(scope)
    }

    private inner class UARTManagerGattCallback : BleManagerGattCallback() {


        override fun isRequiredServiceSupported(gatt: BluetoothGatt): Boolean {
            val service: BluetoothGattService? = gatt.getService(UART_SERVICE_UUID)
            Log.i(TAG, "isRequiredServiceSupported service = ${service != null}")
            if (service != null) {
                rxCharacteristic = service.getCharacteristic(UART_RX_CHARACTERISTIC_UUID)
                txCharacteristic = service.getCharacteristic(UART_TX_CHARACTERISTIC_UUID)
            }
            var writeRequest = false
            var writeCommand = false

            rxCharacteristic?.let {
                val rxProperties: Int = it.properties
                writeRequest = rxProperties and BluetoothGattCharacteristic.PROPERTY_WRITE > 0
                writeCommand =
                    rxProperties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE > 0

                // Set the WRITE REQUEST type when the characteristic supports it.
                // This will allow to send long write (also if the characteristic support it).
                // In case there is no WRITE REQUEST property, this manager will divide texts
                // longer then MTU-3 bytes into up to MTU-3 bytes chunks.
                if (!writeRequest) {
                    useLongWrite = false
                }
            }
            gatt.getService(BATTERY_SERVICE_UUID)?.run {
                batteryLevelCharacteristic = getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC_UUID)
            }
            return rxCharacteristic != null && txCharacteristic != null && (writeRequest || writeCommand)
        }

        override fun onServicesInvalidated() {
            batteryLevelCharacteristic = null
            rxCharacteristic = null
            txCharacteristic = null
            useLongWrite = true
        }
    }

    fun send(byteArray: ByteArray) {
        if (rxCharacteristic == null) return
        scope.launchWithCatch {
            val writeType = if (useLongWrite) {
                BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
            } else {
                BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
            }
            val request: WriteRequest =
                writeCharacteristic(rxCharacteristic, byteArray, writeType)
            if (!useLongWrite) {
                request.split()
            }
            request.suspend()
        }
    }

    fun clearItems() {
        data.value = data.value.copy(messages = emptyList())
    }

    override fun getGattCallback(): BleManagerGattCallback {
        Log.i(TAG, "getGattCallback")
        return UARTManagerGattCallback()
    }
}
