package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

/**
 * Connect to [device] and perform service discovery
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lru/mertech/sbpskb/bluetooth/Connect;", "Lru/mertech/sbpskb/bluetooth/BleOperationType;", "device", "Landroid/bluetooth/BluetoothDevice;", "context", "Landroid/content/Context;", "(Landroid/bluetooth/BluetoothDevice;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
public final class Connect extends ru.mertech.sbpskb.bluetooth.BleOperationType {
    @org.jetbrains.annotations.NotNull()
    private final android.bluetooth.BluetoothDevice device = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    /**
     * Connect to [device] and perform service discovery
     */
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.bluetooth.Connect copy(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Connect to [device] and perform service discovery
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Connect to [device] and perform service discovery
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Connect to [device] and perform service discovery
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Connect(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
}