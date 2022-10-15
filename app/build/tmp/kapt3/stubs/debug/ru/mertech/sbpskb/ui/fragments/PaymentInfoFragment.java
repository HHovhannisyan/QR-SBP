package ru.mertech.sbpskb.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006%"}, d2 = {"Lru/mertech/sbpskb/ui/fragments/PaymentInfoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/mertech/sbpskb/databinding/PaymentInfoFragmentBinding;", "mCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "sharedEncoded", "Landroid/content/SharedPreferences;", "sharedQrId", "sharedpaymentID", "viewModel", "Lru/mertech/sbpskb/ui/viewModels/ShareViewModel;", "getViewModel", "()Lru/mertech/sbpskb/ui/viewModels/ShareViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCurrentDate", "", "getPaymentStatusRaiff", "", "qrId", "getPaymentStatusTinkoff", "paymentId", "encoded", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showPaymentInfo", "status", "statusBool", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PaymentInfoFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private android.content.SharedPreferences sharedQrId;
    private android.content.SharedPreferences sharedEncoded;
    private android.content.SharedPreferences sharedpaymentID;
    private ru.mertech.sbpskb.databinding.PaymentInfoFragmentBinding binding;
    private kotlinx.coroutines.CoroutineScope mCoroutineScope;
    private java.util.HashMap _$_findViewCache;
    
    public PaymentInfoFragment() {
        super();
    }
    
    private final ru.mertech.sbpskb.ui.viewModels.ShareViewModel getViewModel() {
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
    
    private final void getPaymentStatusRaiff(java.lang.String qrId) {
    }
    
    private final void getPaymentStatusTinkoff(java.lang.String paymentId, java.lang.String encoded) {
    }
    
    private final void showPaymentInfo(java.lang.String status, boolean statusBool) {
    }
    
    private final java.lang.String getCurrentDate() {
        return null;
    }
}