package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName

data class GetTinkoffPaymentsStatusResp(
    @SerializedName("TerminalKey")
    val terminalKey: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Amount")
    val amount: Double,
    @SerializedName("Currency")
    val currency: String,
    @SerializedName("OrderId")
    val orderId: String,
    @SerializedName("ErrorCode")
    val errorCode: String,
    @SerializedName("Success")
    val isSucceed: Boolean

)
