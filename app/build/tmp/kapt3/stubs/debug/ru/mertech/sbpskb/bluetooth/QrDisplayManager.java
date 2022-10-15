package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lru/mertech/sbpskb/bluetooth/QrDisplayManager;", "Lno/nordicsemi/android/ble/BleManager;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "batteryLevelCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "data", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mertech/sbpskb/bluetooth/BTData;", "dataHolder", "Lru/mertech/sbpskb/bluetooth/ConnectionObserverAdapter;", "rxCharacteristic", "txCharacteristic", "useLongWrite", "", "clearItems", "", "getGattCallback", "Lno/nordicsemi/android/ble/BleManager$BleManagerGattCallback;", "send", "byteArray", "", "UARTManagerGattCallback", "app_debug"})
public final class QrDisplayManager extends no.nordicsemi.android.ble.BleManager {
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private android.bluetooth.BluetoothGattCharacteristic batteryLevelCharacteristic;
    private android.bluetooth.BluetoothGattCharacteristic rxCharacteristic;
    private android.bluetooth.BluetoothGattCharacteristic txCharacteristic;
    private boolean useLongWrite = true;
    private final kotlinx.coroutines.flow.MutableStateFlow<ru.mertech.sbpskb.bluetooth.BTData> data = null;
    private final ru.mertech.sbpskb.bluetooth.ConnectionObserverAdapter<ru.mertech.sbpskb.bluetooth.BTData> dataHolder = null;
    
    public QrDisplayManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        super(null);
    }
    
    public final void send(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
    }
    
    public final void clearItems() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected no.nordicsemi.android.ble.BleManager.BleManagerGattCallback getGattCallback() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014\u00a8\u0006\t"}, d2 = {"Lru/mertech/sbpskb/bluetooth/QrDisplayManager$UARTManagerGattCallback;", "Lno/nordicsemi/android/ble/BleManager$BleManagerGattCallback;", "(Lru/mertech/sbpskb/bluetooth/QrDisplayManager;)V", "isRequiredServiceSupported", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "onServicesInvalidated", "", "app_debug"})
    final class UARTManagerGattCallback extends no.nordicsemi.android.ble.BleManager.BleManagerGattCallback {
        
        public UARTManagerGattCallback() {
            super();
        }
        
        @java.lang.Override()
        protected boolean isRequiredServiceSupported(@org.jetbrains.annotations.NotNull()
        android.bluetooth.BluetoothGatt gatt) {
            return false;
        }
        
        @java.lang.Override()
        protected void onServicesInvalidated() {
        }
    }
}