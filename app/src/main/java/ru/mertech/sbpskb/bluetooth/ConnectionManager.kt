package ru.mertech.sbpskb.bluetooth

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothProfile
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import java.lang.ref.WeakReference
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue


object ConnectionManager {

    private var listeners: MutableSet<WeakReference<BTConnectionEventListener>> = mutableSetOf()

    private val deviceGattMap = ConcurrentHashMap<BluetoothDevice, BluetoothGatt>()
    private val operationQueue = ConcurrentLinkedQueue<BleOperationType>()
    private var pendingOperation: BleOperationType? = null


    fun registerListener(listener: BTConnectionEventListener) {
        if (listeners.map { it.get() }.contains(listener)) {
            return
        }
        listeners.add(WeakReference(listener))
        listeners = listeners.filter { it.get() != null }.toMutableSet()
        Log.d("TAG", "Added listener $listener, ${listeners.size} listeners total")
    }

    fun unregisterListener(listener: BTConnectionEventListener) {
        // Removing elements while in a loop results in a java.util.ConcurrentModificationException
        var toRemove: WeakReference<BTConnectionEventListener>? = null
        listeners.forEach {
            if (it.get() == listener) {
                toRemove = it
            }
        }
        toRemove?.let {
            listeners.remove(it)
            Log.d("TAG", "Removed listener ${it.get()}, ${listeners.size} listeners total")
        }
    }


    fun connect(device: BluetoothDevice, context: Context) {
        if (device.isConnected()) {
            Log.d("TAG", "Already connected to ${device.address}!")
            Toast.makeText(context, "Already connected to ${device.name}!", Toast.LENGTH_SHORT)
                .show()
        } else {
            enqueueOperation(Connect(device, context.applicationContext))
        }
    }

    fun teardownConnection(device: BluetoothDevice) {
        if (device.isConnected() || !device.isConnected()) {
            enqueueOperation(Disconnect(device))
        } else {
            Log.d("TAG", "Not connected to ${device.address}, cannot teardown connection!")
        }
    }


    // - Beginning of PRIVATE functions

    @Synchronized
    private fun enqueueOperation(operation: BleOperationType) {
        operationQueue.add(operation)
        if (pendingOperation == null) {
            doNextOperation()
        }
    }

    @Synchronized
    private fun signalEndOfOperation() {
        Log.d("TAG", "End of $pendingOperation")
        pendingOperation = null
        if (operationQueue.isNotEmpty()) {
            doNextOperation()
        }
    }

    /**
     * Perform a given [BleOperationType]. All permission checks are performed before an operation
     * can be enqueued by [enqueueOperation].
     */
    @Synchronized
    private fun doNextOperation() {
        if (pendingOperation != null) {
            Log.d("TAG", "doNextOperation() called when an operation is pending! Aborting.")
            return
        }

        val operation = operationQueue.poll() ?: run {
            Log.d("TAG", "Operation queue empty, returning")
            return
        }

        pendingOperation = operation

        val callback = object : BluetoothGattCallback() {
            override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
                val deviceAddress = gatt.device.address

                if (status == BluetoothGatt.GATT_SUCCESS) {
                    if (newState == BluetoothProfile.STATE_CONNECTED) {
                        Log.d("TAG", "onConnectionStateChange: connected to $deviceAddress")
                       deviceGattMap[gatt.device] = gatt
                        Handler(Looper.getMainLooper()).post {
                            gatt.discoverServices()
                        }

                    } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                        Log.d("TAG", "onConnectionStateChange: disconnected from $deviceAddress")
                        teardownConnection(gatt.device)
                        gatt.close()
                    }
                } else {
                    Log.d(
                        "TAG",
                        "onConnectionStateChange: status $status encountered for $deviceAddress!"
                    )
                    if (pendingOperation is Connect) {
                        signalEndOfOperation()
                    }
                    teardownConnection(gatt.device)
                }
            }

            override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {

                with(gatt) {
                    if (status == BluetoothGatt.GATT_SUCCESS) {
                        Log.d("TAG", "Discovered ${services.size} services for ${device.address}.")
                        //  requestMtu(device, GATT_MAX_MTU_SIZE)
                        listeners.forEach { it.get()?.onConnectionSetupComplete?.invoke(this) }
                    } else {
                        Log.d("TAG", "Service discovery failed due to status $status")
                        teardownConnection(gatt.device)
                    }
                }

                if (pendingOperation is Connect) {
                    signalEndOfOperation()
                }
            }

        }

        // Handle Connect separately from other operations that require device to be connected
        if (operation is Connect) {
            with(operation) {
                Log.d("TAG", "Connecting to ${device.address}")
                device.connectGatt(context, true, callback, BluetoothDevice.TRANSPORT_AUTO)
            }
            return
        }

        // Check BluetoothGatt availability for other operations
        val gatt = deviceGattMap[operation.device]
            ?: this@ConnectionManager.run {
                Log.d(
                    "TAG",
                    "Not connected to ${operation.device.address}! Aborting $operation operation."
                )
                signalEndOfOperation()
                return
            }

        when (operation) {
            is Disconnect -> with(operation) {
                Log.d("Log", "Disconnecting from ${device.address}")
                gatt.close()
                deviceGattMap.remove(device)
                listeners.forEach { it.get()?.onDisconnect?.invoke(device) }
                signalEndOfOperation()
            }
        }
    }

    private fun BluetoothDevice.isConnected() = deviceGattMap.containsKey(this)

}
