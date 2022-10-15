package ru.mertech.sbpskb.ui.viewModels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ.\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dJ6\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001bJ\u0006\u0010\'\u001a\u00020\u001bJ\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\nJ\u001e\u0010+\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020 J&\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020 R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lru/mertech/sbpskb/ui/viewModels/ShareViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "repository", "Lru/mertech/repository/Repository;", "application", "Landroid/app/Application;", "networkHelper", "Lru/mertech/sbpskb/utils/NetworkHelper;", "(Lru/mertech/repository/Repository;Landroid/app/Application;Lru/mertech/sbpskb/utils/NetworkHelper;)V", "RaiffbankInfo", "Landroidx/lifecycle/LiveData;", "Lru/mertech/sbpskb/utils/Resource;", "Lru/mertech/sbpskb/pojo/sbp/GetRaiffPaymentsStatusResp;", "getRaiffbankInfo", "()Landroidx/lifecycle/LiveData;", "TinkoffbankInfo", "Lru/mertech/sbpskb/pojo/sbp/GetTinkoffPaymentsStatusResp;", "getTinkoffbankInfo", "_RaiffbankInfo", "Landroidx/lifecycle/MutableLiveData;", "_TinkoffbankInfo", "sharedEncoded", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "sharedQrId", "sharedpaymentID", "addRaiffPayment", "", "amount", "", "qrId", "img", "", "date", "bankName", "addTinkoffPayment", "paymentID", "encoded", "fetchRaiffPaymentInfo", "fetchTinkoffPaymentInfo", "getAllPayments", "", "Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;", "updatePaymentRaiffDB", "context", "Landroid/content/Context;", "position", "updatePaymentTinkoffDB", "paymentId", "app_debug"})
public final class ShareViewModel extends androidx.lifecycle.AndroidViewModel {
    private final ru.mertech.repository.Repository repository = null;
    private final ru.mertech.sbpskb.utils.NetworkHelper networkHelper = null;
    private final androidx.lifecycle.MutableLiveData<ru.mertech.sbpskb.utils.Resource<ru.mertech.sbpskb.pojo.sbp.GetRaiffPaymentsStatusResp>> _RaiffbankInfo = null;
    private final androidx.lifecycle.MutableLiveData<ru.mertech.sbpskb.utils.Resource<ru.mertech.sbpskb.pojo.sbp.GetTinkoffPaymentsStatusResp>> _TinkoffbankInfo = null;
    private final android.content.SharedPreferences sharedQrId = null;
    private final android.content.SharedPreferences sharedpaymentID = null;
    private final android.content.SharedPreferences sharedEncoded = null;
    
    @javax.inject.Inject()
    public ShareViewModel(@org.jetbrains.annotations.NotNull()
    ru.mertech.repository.Repository repository, @org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.utils.NetworkHelper networkHelper) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.mertech.sbpskb.utils.Resource<ru.mertech.sbpskb.pojo.sbp.GetRaiffPaymentsStatusResp>> getRaiffbankInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.mertech.sbpskb.utils.Resource<ru.mertech.sbpskb.pojo.sbp.GetTinkoffPaymentsStatusResp>> getTinkoffbankInfo() {
        return null;
    }
    
    public final void fetchRaiffPaymentInfo() {
    }
    
    public final void fetchTinkoffPaymentInfo() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<ru.mertech.sbpskb.db.entity.PaymentStatusEntity>> getAllPayments() {
        return null;
    }
    
    public final void addTinkoffPayment(@org.jetbrains.annotations.NotNull()
    java.lang.String amount, @org.jetbrains.annotations.NotNull()
    java.lang.String paymentID, @org.jetbrains.annotations.NotNull()
    java.lang.String encoded, int img, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String bankName) {
    }
    
    public final void addRaiffPayment(@org.jetbrains.annotations.NotNull()
    java.lang.String amount, @org.jetbrains.annotations.NotNull()
    java.lang.String qrId, int img, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String bankName) {
    }
    
    public final void updatePaymentRaiffDB(@org.jetbrains.annotations.NotNull()
    java.lang.String qrId, @org.jetbrains.annotations.NotNull()
    android.content.Context context, int position) {
    }
    
    public final void updatePaymentTinkoffDB(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentId, @org.jetbrains.annotations.NotNull()
    java.lang.String encoded, @org.jetbrains.annotations.NotNull()
    android.content.Context context, int position) {
    }
}