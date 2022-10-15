package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000f\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lru/mertech/sbpskb/bluetooth/ConnectionObserverAdapter;", "T", "Lno/nordicsemi/android/ble/observer/ConnectionObserver;", "()V", "TAG", "", "_status", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mertech/sbpskb/bluetooth/BleManagerResult;", "lastValue", "Ljava/lang/Object;", "status", "Lkotlinx/coroutines/flow/StateFlow;", "getStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "getData", "()Ljava/lang/Object;", "onDeviceConnected", "", "device", "Landroid/bluetooth/BluetoothDevice;", "onDeviceConnecting", "onDeviceDisconnected", "reason", "", "onDeviceDisconnecting", "onDeviceFailedToConnect", "onDeviceReady", "setValue", "value", "(Ljava/lang/Object;)V", "app_debug"})
public final class ConnectionObserverAdapter<T extends java.lang.Object> implements no.nordicsemi.android.ble.observer.ConnectionObserver {
    private final java.lang.String TAG = "ru.mertech.qrpay";
    private final kotlinx.coroutines.flow.MutableStateFlow<ru.mertech.sbpskb.bluetooth.BleManagerResult<T>> _status = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ru.mertech.sbpskb.bluetooth.BleManagerResult<T>> status = null;
    private T lastValue;
    
    public ConnectionObserverAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<ru.mertech.sbpskb.bluetooth.BleManagerResult<T>> getStatus() {
        return null;
    }
    
    private final T getData() {
        return null;
    }
    
    @java.lang.Override()
    public void onDeviceConnecting(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    @java.lang.Override()
    public void onDeviceConnected(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    @java.lang.Override()
    public void onDeviceFailedToConnect(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device, int reason) {
    }
    
    @java.lang.Override()
    public void onDeviceReady(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    @java.lang.Override()
    public void onDeviceDisconnecting(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    @java.lang.Override()
    public void onDeviceDisconnected(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device, int reason) {
    }
    
    public final void setValue(T value) {
    }
}