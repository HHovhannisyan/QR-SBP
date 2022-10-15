package ru.mertech.sbpskb.db.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lru/mertech/sbpskb/db/room/PaymentDAO;", "", "insertPayment", "", "paymentStatusEntity", "Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;", "(Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPayments", "Landroidx/lifecycle/LiveData;", "", "returnSid", "", "date", "", "updateRaiffPayment", "updateTinkoffPayment", "app_debug"})
public abstract interface PaymentDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM paymentstatusentity")
    public abstract androidx.lifecycle.LiveData<java.util.List<ru.mertech.sbpskb.db.entity.PaymentStatusEntity>> loadPayments();
    
    @androidx.room.Query(value = "SELECT sid FROM paymentstatusentity WHERE date = :date")
    public abstract int returnSid(@org.jetbrains.annotations.NotNull()
    java.lang.String date);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertPayment(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateRaiffPayment(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateTinkoffPayment(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}