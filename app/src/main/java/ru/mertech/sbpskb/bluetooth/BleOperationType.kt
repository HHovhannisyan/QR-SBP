
package ru.mertech.sbpskb.bluetooth

import android.bluetooth.BluetoothDevice
import android.content.Context

/** Abstract sealed class representing a type of BLE operation */
sealed class BleOperationType {
    abstract val device: BluetoothDevice
}

/** Connect to [device] and perform service discovery */
data class Connect(override val device: BluetoothDevice, val context: Context) : BleOperationType()

/** Disconnect from [device] and release all connection resources */
data class Disconnect(override val device: BluetoothDevice) : BleOperationType()
