package ru.mertech.sbpskb.bluetooth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005\u0082\u0001\u0006\b\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lru/mertech/sbpskb/bluetooth/BleManagerResult;", "T", "", "()V", "hasBeenDisconnected", "", "hasBeenDisconnectedWithoutLinkLoss", "isRunning", "Lru/mertech/sbpskb/bluetooth/ConnectingResult;", "Lru/mertech/sbpskb/bluetooth/SuccessResult;", "Lru/mertech/sbpskb/bluetooth/LinkLossResult;", "Lru/mertech/sbpskb/bluetooth/DisconnectedResult;", "Lru/mertech/sbpskb/bluetooth/UnknownErrorResult;", "Lru/mertech/sbpskb/bluetooth/MissingServiceResult;", "app_debug"})
public abstract class BleManagerResult<T extends java.lang.Object> {
    
    private BleManagerResult() {
        super();
    }
    
    public final boolean isRunning() {
        return false;
    }
    
    public final boolean hasBeenDisconnected() {
        return false;
    }
    
    public final boolean hasBeenDisconnectedWithoutLinkLoss() {
        return false;
    }
}