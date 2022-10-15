package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName

data class AgentTinkoffRegisterQrResp(
    @SerializedName("TerminalKey")
    val terminalKey: String,
    @SerializedName("Amount")
    val amount: Int,
    @SerializedName("Currency")
    val currency: String,
    @SerializedName("Message")
    val message: String,
    @SerializedName("OrderId")
    val orderId: String,
    @SerializedName("Success")
    val isSucceed: Boolean,
    @SerializedName("ErrorCode")
    val errorCode: String,
    @SerializedName("PaymentId")
    val paymentId: String,
    @SerializedName("Data")
    val dataQr: String
)
