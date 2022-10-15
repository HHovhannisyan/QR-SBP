package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName

data class AgentTinkoffRegisterQrReq(
    @SerializedName("TerminalKey")
    val terminalKey: String,
    @SerializedName("Amount")
    val amount: Int,
    @SerializedName("Currency")
    val currency: Int,
    @SerializedName("OrderId")
    val orderId: String,
)
