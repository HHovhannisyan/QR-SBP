package ru.mertech.sbpskb.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\n"}, d2 = {"Lru/mertech/sbpskb/api/DaDataApi;", "", "getOrgList", "Lio/reactivex/Single;", "Lru/mertech/sbpskb/pojo/dadata/GetOrgListResp;", "paramString", "", "paramGetOrgListReq", "Lru/mertech/sbpskb/pojo/dadata/GetOrgListReq;", "Companion", "app_debug"})
public abstract interface DaDataApi {
    @org.jetbrains.annotations.NotNull()
    public static final ru.mertech.sbpskb.api.DaDataApi.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/";
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "rs/suggest/party")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.dadata.GetOrgListResp> getOrgList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String paramString, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.dadata.GetOrgListReq paramGetOrgListReq);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/mertech/sbpskb/api/DaDataApi$Companion;", "", "()V", "BASE_URL", "", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/";
        
        private Companion() {
            super();
        }
    }
}