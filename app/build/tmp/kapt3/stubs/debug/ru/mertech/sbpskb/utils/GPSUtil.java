package ru.mertech.sbpskb.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lru/mertech/sbpskb/utils/GPSUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "locationManager", "Landroid/location/LocationManager;", "mLocationSettingsRequest", "Lcom/google/android/gms/location/LocationSettingsRequest;", "mSettingsClient", "Lcom/google/android/gms/location/SettingsClient;", "turnGPSOn", "", "onGpsListener", "Lru/mertech/sbpskb/utils/GPSUtil$onGPSListener;", "onGPSListener", "app_debug"})
public final class GPSUtil {
    private final android.content.Context context = null;
    private final com.google.android.gms.location.SettingsClient mSettingsClient = null;
    private final com.google.android.gms.location.LocationSettingsRequest mLocationSettingsRequest = null;
    private final android.location.LocationManager locationManager = null;
    
    public GPSUtil(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void turnGPSOn(@org.jetbrains.annotations.Nullable()
    ru.mertech.sbpskb.utils.GPSUtil.onGPSListener onGpsListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lru/mertech/sbpskb/utils/GPSUtil$onGPSListener;", "", "gpsStatus", "", "isGPSEnable", "", "app_debug"})
    public static abstract interface onGPSListener {
        
        public abstract void gpsStatus(boolean isGPSEnable);
    }
}