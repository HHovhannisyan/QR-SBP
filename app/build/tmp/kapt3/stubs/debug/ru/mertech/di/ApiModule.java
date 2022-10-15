package ru.mertech.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u001c\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\rH\u0007J\u001c\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\rH\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0014\u001a\u00020\rH\u0007J\b\u0010\u0015\u001a\u00020\u0006H\u0007\u00a8\u0006\u0019"}, d2 = {"Lru/mertech/di/ApiModule;", "", "()V", "provideOkHttpClientRaiff", "Lokhttp3/OkHttpClient;", "apiKeyInterceptor", "Lokhttp3/Interceptor;", "provideOkHttpClientTinkoff", "provideRaiffPaymentInfoApiService", "Lru/mertech/sbpskb/api/RaiffPaymentApi;", "retrofit", "Lretrofit2/Retrofit;", "provideRaiffPaymentInfoUrl", "", "provideRetrofitRaiff", "okHttpClient", "url", "provideRetrofitTinkoff", "provideTinkoffPaymentInfoApiService", "Lru/mertech/sbpskb/api/TinkoffPaymentApi;", "provideTinkoffPaymentInfoUrl", "providesApiKeyInterceptor", "ApiKeyInterceptorOkHttpClient", "AuthInterceptorOkHttpClient", "OtherInterceptorOkHttpClient", "app_debug"})
@dagger.Module()
public final class ApiModule {
    @org.jetbrains.annotations.NotNull()
    public static final ru.mertech.di.ApiModule INSTANCE = null;
    
    private ApiModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @ru.mertech.di.ApiModule.AuthInterceptorOkHttpClient()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideOkHttpClientRaiff(@org.jetbrains.annotations.NotNull()
    @ru.mertech.di.ApiModule.ApiKeyInterceptorOkHttpClient()
    okhttp3.Interceptor apiKeyInterceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @ru.mertech.di.ApiModule.OtherInterceptorOkHttpClient()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideOkHttpClientTinkoff() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "RaiffPaymentInfoUrl")
    @javax.inject.Singleton()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofitRaiff(@org.jetbrains.annotations.NotNull()
    @ru.mertech.di.ApiModule.AuthInterceptorOkHttpClient()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "RaiffPaymentInfoUrl")
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "TinkoffPaymentInfoUrl")
    @javax.inject.Singleton()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofitTinkoff(@org.jetbrains.annotations.NotNull()
    @ru.mertech.di.ApiModule.OtherInterceptorOkHttpClient()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "TinkoffPaymentInfoUrl")
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final ru.mertech.sbpskb.api.RaiffPaymentApi provideRaiffPaymentInfoApiService(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "RaiffPaymentInfoUrl")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final ru.mertech.sbpskb.api.TinkoffPaymentApi provideTinkoffPaymentInfoApiService(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "TinkoffPaymentInfoUrl")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "RaiffPaymentInfoUrl")
    @dagger.Provides()
    public final java.lang.String provideRaiffPaymentInfoUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "TinkoffPaymentInfoUrl")
    @dagger.Provides()
    public final java.lang.String provideTinkoffPaymentInfoUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @ru.mertech.di.ApiModule.ApiKeyInterceptorOkHttpClient()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final okhttp3.Interceptor providesApiKeyInterceptor() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lru/mertech/di/ApiModule$ApiKeyInterceptorOkHttpClient;", "", "app_debug"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @javax.inject.Qualifier()
    public static abstract @interface ApiKeyInterceptorOkHttpClient {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lru/mertech/di/ApiModule$AuthInterceptorOkHttpClient;", "", "app_debug"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @javax.inject.Qualifier()
    public static abstract @interface AuthInterceptorOkHttpClient {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lru/mertech/di/ApiModule$OtherInterceptorOkHttpClient;", "", "app_debug"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @javax.inject.Qualifier()
    public static abstract @interface OtherInterceptorOkHttpClient {
    }
}