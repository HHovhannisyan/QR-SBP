package ru.mertech.sbpskb.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lru/mertech/sbpskb/ui/activities/GenerateQRActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lru/mertech/sbpskb/InternetConnectionReceiver$ReceiverListener;", "()V", "activityGenerateQrBinding", "Lru/mertech/sbpskb/databinding/ActivityGenerateQrBinding;", "isGPS", "", "checkConnection", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNetworkChange", "isConnected", "onPause", "onResume", "onSupportNavigateUp", "showToast", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class GenerateQRActivity extends androidx.appcompat.app.AppCompatActivity implements ru.mertech.sbpskb.InternetConnectionReceiver.ReceiverListener {
    private ru.mertech.sbpskb.databinding.ActivityGenerateQrBinding activityGenerateQrBinding;
    private boolean isGPS = false;
    private java.util.HashMap _$_findViewCache;
    
    public GenerateQRActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final void checkConnection() {
    }
    
    private final void showToast(boolean isConnected) {
    }
    
    @java.lang.Override()
    public void onNetworkChange(boolean isConnected) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
}