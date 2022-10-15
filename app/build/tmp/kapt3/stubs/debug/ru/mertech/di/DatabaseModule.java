package ru.mertech.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2 = {"Lru/mertech/di/DatabaseModule;", "", "()V", "provideArticleDao", "Lru/mertech/sbpskb/db/room/PaymentDAO;", "db", "Lru/mertech/sbpskb/db/room/PaymentDB;", "provideDatabase", "application", "Landroid/app/Application;", "callback", "Lru/mertech/sbpskb/db/room/PaymentDB$Callback;", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final ru.mertech.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final ru.mertech.sbpskb.db.room.PaymentDB provideDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.room.PaymentDB.Callback callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final ru.mertech.sbpskb.db.room.PaymentDAO provideArticleDao(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.room.PaymentDB db) {
        return null;
    }
}