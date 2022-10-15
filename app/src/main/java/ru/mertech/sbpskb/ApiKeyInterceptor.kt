package ru.mertech.sbpskb

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor  : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .header(
                "Authorization",
                "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNQTQ2NzY5OSIsImp0aSI6IjIxZDU0NDMwLWM1ODctNGU0MC1iNDQxLTI5ZWU2Y2QyNjMwNSJ9.-bD4cSz56DgUgM9aXp9mXAt67yfjslCVrI3KJNfhQ5U"
            )
            .build()
       return chain.proceed(newRequest)
    }
}