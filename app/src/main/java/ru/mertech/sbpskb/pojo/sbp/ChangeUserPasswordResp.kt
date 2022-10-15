package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class ChangeUserPasswordResp(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("errorId")
    val errorId: String,
    @SerializedName("errCode")
    val errCode: String
)