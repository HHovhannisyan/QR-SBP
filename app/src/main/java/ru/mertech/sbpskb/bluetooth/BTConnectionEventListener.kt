
package ru.mertech.sbpskb.bluetooth

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt

/** A listener containing callback methods to be registered with [ConnectionManager].*/
class BTConnectionEventListener {
    var onConnectionSetupComplete: ((BluetoothGatt) -> Unit)? = null
    var onDisconnect: ((BluetoothDevice) -> Unit)? = null
}
