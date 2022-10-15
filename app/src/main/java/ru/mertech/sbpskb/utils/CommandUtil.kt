package ru.mertech.sbpskb.utils

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import ru.mertech.sbpskb.bluetooth.QrDisplayManager

class CommandUtil(private val context: Context, private val mCoroutineScope: CoroutineScope) {
    fun sendCommand(address: String, byteArray: ByteArray) {
        val bluetoothManager =
            context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val device: BluetoothDevice = bluetoothManager.adapter.getRemoteDevice(address)

        val qrDisplayManager = QrDisplayManager(context, mCoroutineScope)
        val connectionRequest =
            qrDisplayManager.connect(device).useAutoConnect(false).retry(3, 100)

        connectionRequest.done { selectedDevice ->
            Log.d("TAG", "connectionRequest.done: $selectedDevice")
            qrDisplayManager.send(byteArray)
            qrDisplayManager.disconnect()
        }
        connectionRequest.fail { _, status ->
            Log.d("TAG", "connectionReq.fail status: $status")
            qrDisplayManager.disconnect()
        }
        connectionRequest.enqueue()
    }
}