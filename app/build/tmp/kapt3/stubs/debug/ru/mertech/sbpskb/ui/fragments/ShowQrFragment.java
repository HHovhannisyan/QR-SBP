package ru.mertech.sbpskb.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0018H\u0002J\u0006\u0010-\u001a\u00020\u0016J\b\u0010.\u001a\u00020\u0016H\u0002J\f\u0010/\u001a\u000200*\u00020\u001cH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u00061"}, d2 = {"Lru/mertech/sbpskb/ui/fragments/ShowQrFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/mertech/sbpskb/databinding/ShowQrFragmentBinding;", "getBinding", "()Lru/mertech/sbpskb/databinding/ShowQrFragmentBinding;", "setBinding", "(Lru/mertech/sbpskb/databinding/ShowQrFragmentBinding;)V", "countDownTimer", "Landroid/os/CountDownTimer;", "mCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mViewModel", "Lru/mertech/sbpskb/ui/viewModels/ShowQrViewModel;", "result", "Lcom/google/zxing/common/BitMatrix;", "getResult", "()Lcom/google/zxing/common/BitMatrix;", "setResult", "(Lcom/google/zxing/common/BitMatrix;)V", "downloadImage", "", "mWebPath", "", "generateQRcode", "qrUrl", "mLoad", "Landroid/graphics/Bitmap;", "string", "mStringToURL", "Ljava/net/URL;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "sendQrCodeImg", "bitmap", "sendString", "str", "showQrCode", "switchToWait", "toByteArray", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ShowQrFragment extends androidx.fragment.app.Fragment {
    private final ru.mertech.sbpskb.ui.viewModels.ShowQrViewModel mViewModel = null;
    public ru.mertech.sbpskb.databinding.ShowQrFragmentBinding binding;
    public com.google.zxing.common.BitMatrix result;
    private android.os.CountDownTimer countDownTimer;
    private kotlinx.coroutines.CoroutineScope mCoroutineScope;
    private java.util.HashMap _$_findViewCache;
    
    public ShowQrFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.databinding.ShowQrFragmentBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.databinding.ShowQrFragmentBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.zxing.common.BitMatrix getResult() {
        return null;
    }
    
    public final void setResult(@org.jetbrains.annotations.NotNull()
    com.google.zxing.common.BitMatrix p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void switchToWait() {
    }
    
    private final void generateQRcode(java.lang.String qrUrl) {
    }
    
    public final void showQrCode() {
    }
    
    public final void downloadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String mWebPath) {
    }
    
    private final android.graphics.Bitmap mLoad(java.lang.String string) {
        return null;
    }
    
    private final java.net.URL mStringToURL(java.lang.String string) {
        return null;
    }
    
    private final void sendQrCodeImg(android.graphics.Bitmap bitmap) {
    }
    
    private final void sendString(java.lang.String str) {
    }
    
    private final byte[] toByteArray(android.graphics.Bitmap $this$toByteArray) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}