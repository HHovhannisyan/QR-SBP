package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class ApproveRefundTransferReq(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("corelationId")
    val corelationId: String
)