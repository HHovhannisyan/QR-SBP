package ru.mertech.sbpskb.db.room;

import java.lang.System;

@androidx.room.Database(version = 1, entities = {ru.mertech.sbpskb.db.entity.PaymentStatusEntity.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lru/mertech/sbpskb/db/room/PaymentDB;", "Landroidx/room/RoomDatabase;", "()V", "paymentDAO", "Lru/mertech/sbpskb/db/room/PaymentDAO;", "Callback", "app_debug"})
public abstract class PaymentDB extends androidx.room.RoomDatabase {
    
    public PaymentDB() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.mertech.sbpskb.db.room.PaymentDAO paymentDAO();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/mertech/sbpskb/db/room/PaymentDB$Callback;", "Landroidx/room/RoomDatabase$Callback;", "()V", "app_debug"})
    public static final class Callback extends androidx.room.RoomDatabase.Callback {
        
        @javax.inject.Inject()
        public Callback() {
            super();
        }
    }
}