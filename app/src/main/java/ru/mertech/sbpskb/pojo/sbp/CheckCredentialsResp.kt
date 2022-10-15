package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class CheckCredentialsResp(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("merchantId")
    val merchantId: String,
    @SerializedName("errorId")
    val errorId: String,
    @SerializedName("errCode")
    val errCode: String,
    @SerializedName("errMess")
    val errMess: String
)