package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class CheckCredentialsReq(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("password")
    val password: String
)