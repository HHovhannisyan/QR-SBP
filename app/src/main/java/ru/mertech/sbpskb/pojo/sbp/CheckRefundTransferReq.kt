package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


class CheckRefundTransferReq(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("trxId")
    val trxId: String,
    @SerializedName("amount")
    val amount: String
)