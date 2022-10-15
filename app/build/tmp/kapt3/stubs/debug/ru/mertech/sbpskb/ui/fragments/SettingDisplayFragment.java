package ru.mertech.sbpskb.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0004H\u0002J\"\u00105\u001a\u00020/2\u0006\u00106\u001a\u0002032\u0006\u00107\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J$\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020/H\u0016J\b\u0010C\u001a\u00020/H\u0002J\b\u0010D\u001a\u00020/H\u0002J\b\u0010E\u001a\u00020/H\u0002J\b\u0010F\u001a\u00020/H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n \t*\u0004\u0018\u00010+0+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lru/mertech/sbpskb/ui/fragments/SettingDisplayFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "binding", "Lru/mertech/sbpskb/databinding/SettingDisplayFragmentBinding;", "bleScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "kotlin.jvm.PlatformType", "getBleScanner", "()Landroid/bluetooth/le/BluetoothLeScanner;", "bleScanner$delegate", "Lkotlin/Lazy;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter$delegate", "connectionEventListener", "Lru/mertech/sbpskb/bluetooth/BTConnectionEventListener;", "getConnectionEventListener", "()Lru/mertech/sbpskb/bluetooth/BTConnectionEventListener;", "connectionEventListener$delegate", "isScanning", "", "mCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mViewModel", "Lru/mertech/sbpskb/ui/viewModels/SettingDisplayViewModel;", "qrDisplayManager", "Lru/mertech/sbpskb/bluetooth/QrDisplayManager;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "scanResultAdapter", "Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter;", "getScanResultAdapter", "()Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter;", "scanResultAdapter$delegate", "scanResults", "", "Landroid/bluetooth/le/ScanResult;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "sh", "Landroid/content/SharedPreferences;", "disconnect", "", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getState", "", "deviceAddress", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "promptEnableBluetooth", "setupRecyclerView", "startBleScan", "stopBleScan", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SettingDisplayFragment extends androidx.fragment.app.Fragment {
    private final ru.mertech.sbpskb.ui.viewModels.SettingDisplayViewModel mViewModel = null;
    private final java.lang.String TAG = "SettingDisplayFragment";
    private ru.mertech.sbpskb.databinding.SettingDisplayFragmentBinding binding;
    private kotlinx.coroutines.CoroutineScope mCoroutineScope;
    private ru.mertech.sbpskb.bluetooth.QrDisplayManager qrDisplayManager;
    private final kotlin.Lazy bluetoothAdapter$delegate = null;
    private final kotlin.Lazy bleScanner$delegate = null;
    private final android.bluetooth.le.ScanSettings scanSettings = null;
    private boolean isScanning = false;
    private final java.util.List<android.bluetooth.le.ScanResult> scanResults = null;
    private final kotlin.Lazy scanResultAdapter$delegate = null;
    private android.content.SharedPreferences sh;
    private final android.bluetooth.le.ScanCallback scanCallback = null;
    private final kotlin.Lazy connectionEventListener$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public SettingDisplayFragment() {
        super();
    }
    
    private final android.bluetooth.BluetoothAdapter getBluetoothAdapter() {
        return null;
    }
    
    private final android.bluetooth.le.BluetoothLeScanner getBleScanner() {
        return null;
    }
    
    private final ru.mertech.sbpskb.ui.adapters.ScanResultAdapter getScanResultAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void promptEnableBluetooth() {
    }
    
    private final void startBleScan() {
    }
    
    private final void stopBleScan() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final ru.mertech.sbpskb.bluetooth.BTConnectionEventListener getConnectionEventListener() {
        return null;
    }
    
    private final void disconnect(android.bluetooth.BluetoothDevice bluetoothDevice) {
    }
    
    private final int getState(java.lang.String deviceAddress) {
        return 0;
    }
}