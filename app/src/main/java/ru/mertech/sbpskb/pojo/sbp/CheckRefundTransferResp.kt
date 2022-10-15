package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


class CheckRefundTransferResp(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("corelationId")
    val corelationId: String,
    @SerializedName("errorId")
    val errorId: String,
    @SerializedName("errCode")
    val errCode: String,
    @SerializedName("errMess")
    val errMess: String
)