package ru.mertech.sbpskb.api

import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import ru.mertech.sbpskb.pojo.telegram.SendMessageResp

interface TelegramAPI {
    @POST("/bot{token}/sendMessage")
    fun sendMessage(
        @Path("token") paramString1: String,
        @Query("chat_id") paramString2: String,
        @Query("text") paramString3: String
    ): Single<SendMessageResp>

    companion object {
        const val BASE_URL = "https://api.telegram.org"
    }
}