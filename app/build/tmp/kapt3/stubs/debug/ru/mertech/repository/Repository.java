package ru.mertech.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J/\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u001e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0019\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ&\u0010$\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lru/mertech/repository/Repository;", "", "paymentDAO", "Lru/mertech/sbpskb/db/room/PaymentDAO;", "tinkoffPaymentApi", "Lru/mertech/sbpskb/api/TinkoffPaymentApi;", "raiffPaymentApi", "Lru/mertech/sbpskb/api/RaiffPaymentApi;", "(Lru/mertech/sbpskb/db/room/PaymentDAO;Lru/mertech/sbpskb/api/TinkoffPaymentApi;Lru/mertech/sbpskb/api/RaiffPaymentApi;)V", "getAllPayments", "Landroidx/lifecycle/LiveData;", "", "Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;", "getRaiffBankInfo", "Lretrofit2/Response;", "Lru/mertech/sbpskb/pojo/sbp/GetRaiffPaymentsStatusResp;", "qrId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTinkoffBankInfo", "Lru/mertech/sbpskb/pojo/sbp/GetTinkoffPaymentsStatusResp;", "terminalKey", "paymentId", "encoded", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "paymentStatusEntity", "(Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRaiffPayment", "updateRaiffPaymentDB", "context", "Landroid/content/Context;", "position", "", "updateTinkoffPayment", "updateTinkoffPaymentDB", "app_debug"})
public final class Repository {
    private final ru.mertech.sbpskb.db.room.PaymentDAO paymentDAO = null;
    private final ru.mertech.sbpskb.api.TinkoffPaymentApi tinkoffPaymentApi = null;
    private final ru.mertech.sbpskb.api.RaiffPaymentApi raiffPaymentApi = null;
    
    @javax.inject.Inject()
    public Repository(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.room.PaymentDAO paymentDAO, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.api.TinkoffPaymentApi tinkoffPaymentApi, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.api.RaiffPaymentApi raiffPaymentApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<ru.mertech.sbpskb.db.entity.PaymentStatusEntity>> getAllPayments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateTinkoffPayment(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object updateRaiffPayment(ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void updateRaiffPaymentDB(@org.jetbrains.annotations.NotNull()
    java.lang.String qrId, @org.jetbrains.annotations.NotNull()
    android.content.Context context, int position) {
    }
    
    public final void updateTinkoffPaymentDB(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentId, @org.jetbrains.annotations.NotNull()
    java.lang.String encoded, @org.jetbrains.annotations.NotNull()
    android.content.Context context, int position) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRaiffBankInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String qrId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.mertech.sbpskb.pojo.sbp.GetRaiffPaymentsStatusResp>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTinkoffBankInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String terminalKey, @org.jetbrains.annotations.NotNull()
    java.lang.String paymentId, @org.jetbrains.annotations.NotNull()
    java.lang.String encoded, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.mertech.sbpskb.pojo.sbp.GetTinkoffPaymentsStatusResp>> continuation) {
        return null;
    }
}