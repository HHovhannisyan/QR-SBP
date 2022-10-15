package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class GetRaiffPaymentsStatusResp(
/*    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("errorId")
    val errorId: String,
    @SerializedName("errCode")
    val errCode: String,
    @SerializedName("errMess")
    val errMess: String,
    @SerializedName("payments")
    val payments: ArrayList<Payment>*/

    @SerializedName("sbpMerchantId")
    val sbpMerchantId: String,
    @SerializedName("qrId")
    val qrId: String,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("order")
    val order: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("transactionId")
    val transactionId: Int,
    @SerializedName("paymentStatus")
    val paymentStatus: String,
    @SerializedName("createDate")
    val createDate: String,
    @SerializedName("merchantId")
    val merchantId: Long,
)