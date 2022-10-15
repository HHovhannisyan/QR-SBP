package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName

data class GetQRTinkoffReq(
    @SerializedName("TerminalKey")
    val terminalKey: String,
    @SerializedName("PaymentId")
    val paymentId: String,
    @SerializedName("Token")
    val token: String
)
