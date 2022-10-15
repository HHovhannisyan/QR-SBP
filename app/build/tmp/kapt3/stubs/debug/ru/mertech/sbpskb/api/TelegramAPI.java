package ru.mertech.sbpskb.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\'\u00a8\u0006\n"}, d2 = {"Lru/mertech/sbpskb/api/TelegramAPI;", "", "sendMessage", "Lio/reactivex/Single;", "Lru/mertech/sbpskb/pojo/telegram/SendMessageResp;", "paramString1", "", "paramString2", "paramString3", "Companion", "app_debug"})
public abstract interface TelegramAPI {
    @org.jetbrains.annotations.NotNull()
    public static final ru.mertech.sbpskb.api.TelegramAPI.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://api.telegram.org";
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/bot{token}/sendMessage")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.telegram.SendMessageResp> sendMessage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "token")
    java.lang.String paramString1, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "chat_id")
    java.lang.String paramString2, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "text")
    java.lang.String paramString3);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/mertech/sbpskb/api/TelegramAPI$Companion;", "", "()V", "BASE_URL", "", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://api.telegram.org";
        
        private Companion() {
            super();
        }
    }
}