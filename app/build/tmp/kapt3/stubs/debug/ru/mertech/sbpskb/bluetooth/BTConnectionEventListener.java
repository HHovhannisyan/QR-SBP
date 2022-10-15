package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

/**
 * A listener containing callback methods to be registered with [ConnectionManager].
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lru/mertech/sbpskb/bluetooth/BTConnectionEventListener;", "", "()V", "onConnectionSetupComplete", "Lkotlin/Function1;", "Landroid/bluetooth/BluetoothGatt;", "", "getOnConnectionSetupComplete", "()Lkotlin/jvm/functions/Function1;", "setOnConnectionSetupComplete", "(Lkotlin/jvm/functions/Function1;)V", "onDisconnect", "Landroid/bluetooth/BluetoothDevice;", "getOnDisconnect", "setOnDisconnect", "app_debug"})
public final class BTConnectionEventListener {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super android.bluetooth.BluetoothGatt, kotlin.Unit> onConnectionSetupComplete;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super android.bluetooth.BluetoothDevice, kotlin.Unit> onDisconnect;
    
    public BTConnectionEventListener() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<android.bluetooth.BluetoothGatt, kotlin.Unit> getOnConnectionSetupComplete() {
        return null;
    }
    
    public final void setOnConnectionSetupComplete(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.bluetooth.BluetoothGatt, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<android.bluetooth.BluetoothDevice, kotlin.Unit> getOnDisconnect() {
        return null;
    }
    
    public final void setOnDisconnect(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.bluetooth.BluetoothDevice, kotlin.Unit> p0) {
    }
}