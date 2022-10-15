package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

/**
 * Disconnect from [device] and release all connection resources
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lru/mertech/sbpskb/bluetooth/Disconnect;", "Lru/mertech/sbpskb/bluetooth/BleOperationType;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Landroid/bluetooth/BluetoothDevice;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
public final class Disconnect extends ru.mertech.sbpskb.bluetooth.BleOperationType {
    @org.jetbrains.annotations.NotNull()
    private final android.bluetooth.BluetoothDevice device = null;
    
    /**
     * Disconnect from [device] and release all connection resources
     */
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.bluetooth.Disconnect copy(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
        return null;
    }
    
    /**
     * Disconnect from [device] and release all connection resources
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Disconnect from [device] and release all connection resources
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Disconnect from [device] and release all connection resources
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Disconnect(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothDevice component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.bluetooth.BluetoothDevice getDevice() {
        return null;
    }
}