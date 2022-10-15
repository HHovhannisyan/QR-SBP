package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class AgentRaiffRegisterQrResp(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("errorId")
    val errorId: String,
    @SerializedName("errCode")
    val errCode: String,
    @SerializedName("errMess")
    val errMess: String,
    @SerializedName("qrcId")
    val qrcId: String,
    @SerializedName("payload")
    val payload: String,
    @SerializedName("status")
    val status: String,

    @SerializedName("qrId")
    val qrId: String,

    @SerializedName("message")
    val message: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("qrUrl")
    val qrUrl: String
)