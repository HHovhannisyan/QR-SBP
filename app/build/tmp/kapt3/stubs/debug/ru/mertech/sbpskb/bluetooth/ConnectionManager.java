package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nJ\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nJ\f\u0010\u001c\u001a\u00020\u001d*\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lru/mertech/sbpskb/bluetooth/ConnectionManager;", "", "()V", "deviceGattMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/bluetooth/BluetoothDevice;", "Landroid/bluetooth/BluetoothGatt;", "listeners", "", "Ljava/lang/ref/WeakReference;", "Lru/mertech/sbpskb/bluetooth/BTConnectionEventListener;", "operationQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lru/mertech/sbpskb/bluetooth/BleOperationType;", "pendingOperation", "connect", "", "device", "context", "Landroid/content/Context;", "doNextOperation", "enqueueOperation", "operation", "registerListener", "listener", "signalEndOfOperation", "teardownConnection", "unregisterListener", "isConnected", "", "app_debug"})
public final class ConnectionManager {
    @org.jetbrains.annotations.NotNull()
    public static final ru.mertech.sbpskb.bluetooth.ConnectionManager INSTANCE = null;
    private static java.util.Set<java.lang.ref.WeakReference<ru.mertech.sbpskb.bluetooth.BTConnectionEventListener>> listeners;
    private static final java.util.concurrent.ConcurrentHashMap<android.bluetooth.BluetoothDevice, android.bluetooth.BluetoothGatt> deviceGattMap = null;
    private static final java.util.concurrent.ConcurrentLinkedQueue<ru.mertech.sbpskb.bluetooth.BleOperationType> operationQueue = null;
    private static ru.mertech.sbpskb.bluetooth.BleOperationType pendingOperation;
    
    private ConnectionManager() {
        super();
    }
    
    public final void registerListener(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.bluetooth.BTConnectionEventListener listener) {
    }
    
    public final void unregisterListener(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.bluetooth.BTConnectionEventListener listener) {
    }
    
    public final void connect(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void teardownConnection(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized void enqueueOperation(ru.mertech.sbpskb.bluetooth.BleOperationType operation) {
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized void signalEndOfOperation() {
    }
    
    /**
     * Perform a given [BleOperationType]. All permission checks are performed before an operation
     * can be enqueued by [enqueueOperation].
     */
    @kotlin.jvm.Synchronized()
    private final synchronized void doNextOperation() {
    }
    
    private final boolean isConnected(android.bluetooth.BluetoothDevice $this$isConnected) {
        return false;
    }
}