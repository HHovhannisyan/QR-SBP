package ru.mertech.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mertech.sbpskb.ApiKeyInterceptor
import ru.mertech.sbpskb.BuildConfig
import ru.mertech.sbpskb.api.RaiffPaymentApi
import ru.mertech.sbpskb.api.TinkoffPaymentApi
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ApiKeyInterceptorOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthInterceptorOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class OtherInterceptorOkHttpClient

    @Provides
    @Singleton
    @AuthInterceptorOkHttpClient
    fun provideOkHttpClientRaiff(
        @ApiKeyInterceptorOkHttpClient apiKeyInterceptor: Interceptor
    ) = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    @OtherInterceptorOkHttpClient
    fun provideOkHttpClientTinkoff() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    @Named("RaiffPaymentInfoUrl")
    fun provideRetrofitRaiff(
        @AuthInterceptorOkHttpClient
        okHttpClient: OkHttpClient,
        @Named("RaiffPaymentInfoUrl")
        url: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    @Named("TinkoffPaymentInfoUrl")
    fun provideRetrofitTinkoff(
        @OtherInterceptorOkHttpClient okHttpClient: OkHttpClient,
        @Named("TinkoffPaymentInfoUrl")
        url: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideRaiffPaymentInfoApiService(@Named("RaiffPaymentInfoUrl") retrofit: Retrofit): RaiffPaymentApi =
        retrofit.create(
            RaiffPaymentApi::class.java
        )

    @Provides
    @Singleton
    fun provideTinkoffPaymentInfoApiService(
        @Named("TinkoffPaymentInfoUrl")
        retrofit: Retrofit
    ): TinkoffPaymentApi =
        retrofit.create(
            TinkoffPaymentApi::class.java
        )

    @Provides
    @Named("RaiffPaymentInfoUrl")
    fun provideRaiffPaymentInfoUrl() = "https://test.ecom.raiffeisen.ru/"

    @Provides
    @Named("TinkoffPaymentInfoUrl")
    fun provideTinkoffPaymentInfoUrl() = "https://securepay.tinkoff.ru/v2/"

    @ApiKeyInterceptorOkHttpClient
    @Singleton
    @Provides
    fun providesApiKeyInterceptor(): Interceptor = ApiKeyInterceptor()
}