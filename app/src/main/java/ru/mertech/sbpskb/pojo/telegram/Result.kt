package ru.mertech.sbpskb.pojo.telegram

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("chat")
    private val chat: Chat? = null,

    @SerializedName("date")
    private val date: Int = 0,

    @SerializedName("from")
     val from: From? = null,

    @SerializedName("message_id")
    private val message_id: Int = 0,

    @SerializedName("text")
    private val text: String? = null
)