package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


class Payment(
    @SerializedName("qrcId")
    val qrcId: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("trxId")
    val trxId: String
)