package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName

data class ApproveRefundTransferResp(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("errMess")
    val errMess: String,
    @SerializedName("errorId")
    val errorId: String,
    @SerializedName("errCode")
    val errCode: String,
    @SerializedName("status")
    val status: String
)