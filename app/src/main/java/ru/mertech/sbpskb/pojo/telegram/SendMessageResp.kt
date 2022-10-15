package ru.mertech.sbpskb.pojo.telegram

import com.google.gson.annotations.SerializedName

data class SendMessageResp(
    @SerializedName("ok")
     val ok: Boolean = false,

    @SerializedName("result")
    private val result: Result? = null
)