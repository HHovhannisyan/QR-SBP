package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

/**
 * Abstract sealed class representing a type of BLE operation
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2 = {"Lru/mertech/sbpskb/bluetooth/BleOperationType;", "", "()V", "device", "Landroid/bluetooth/BluetoothDevice;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "Lru/mertech/sbpskb/bluetooth/Connect;", "Lru/mertech/sbpskb/bluetooth/Disconnect;", "app_debug"})
public abstract class BleOperationType {
    
    private BleOperationType() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.bluetooth.BluetoothDevice getDevice();
}