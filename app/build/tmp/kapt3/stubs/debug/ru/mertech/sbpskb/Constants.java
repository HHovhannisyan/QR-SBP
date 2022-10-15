package ru.mertech.sbpskb;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lru/mertech/sbpskb/Constants;", "", "()V", "BATTERY_LEVEL_CHARACTERISTIC_UUID", "Ljava/util/UUID;", "getBATTERY_LEVEL_CHARACTERISTIC_UUID", "()Ljava/util/UUID;", "BATTERY_SERVICE_UUID", "getBATTERY_SERVICE_UUID", "BLUETOOTH_REQ_CODE", "", "GPS_REQUEST", "LOCATION_PERMISSION_REQUEST_CODE", "UART_RX_CHARACTERISTIC_UUID", "getUART_RX_CHARACTERISTIC_UUID", "UART_SERVICE_UUID", "getUART_SERVICE_UUID", "UART_TX_CHARACTERISTIC_UUID", "getUART_TX_CHARACTERISTIC_UUID", "btClean", "", "getBtClean", "()[B", "btFail", "getBtFail", "btSuccess", "getBtSuccess", "isGPS", "", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final ru.mertech.sbpskb.Constants INSTANCE = null;
    public static final int GPS_REQUEST = 1001;
    public static final int BLUETOOTH_REQ_CODE = 1;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 2;
    @kotlin.jvm.JvmField()
    public static boolean isGPS = false;
    @org.jetbrains.annotations.NotNull()
    private static final byte[] btSuccess = {(byte)2, (byte)-16, (byte)3, (byte)99, (byte)111, (byte)114, (byte)114, (byte)101, (byte)99, (byte)116, (byte)3};
    @org.jetbrains.annotations.NotNull()
    private static final byte[] btFail = {(byte)2, (byte)-16, (byte)3, (byte)109, (byte)105, (byte)115, (byte)116, (byte)97, (byte)107, (byte)101, (byte)3};
    @org.jetbrains.annotations.NotNull()
    private static final byte[] btClean = {(byte)2, (byte)-16, (byte)3, (byte)67, (byte)76, (byte)83, (byte)3};
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID UART_SERVICE_UUID = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID UART_RX_CHARACTERISTIC_UUID = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID UART_TX_CHARACTERISTIC_UUID = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID BATTERY_SERVICE_UUID = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID BATTERY_LEVEL_CHARACTERISTIC_UUID = null;
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getBtSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getBtFail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getBtClean() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getUART_SERVICE_UUID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getUART_RX_CHARACTERISTIC_UUID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getUART_TX_CHARACTERISTIC_UUID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getBATTERY_SERVICE_UUID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getBATTERY_LEVEL_CHARACTERISTIC_UUID() {
        return null;
    }
}