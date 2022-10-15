package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName

data class  AgentRaiffRegisterQrReq(
 /*  @SerializedName("messageId")
    val messageId: String,*/
  /*  @SerializedName("account")
    val account:Long,*/
    @SerializedName("sbpMerchantId")
    val sbpMerchantId: String,
    @SerializedName("qrcType")
    val qrcType: String,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("order")
    val order:String
)




/*data class  AgentRegisterQrReq(

    @SerializedName("TerminalKey")
    val terminalKey: String,

    @SerializedName("Amount")
    val amount: String,

    @SerializedName("OrderId")
    val orderId:String
)*/


