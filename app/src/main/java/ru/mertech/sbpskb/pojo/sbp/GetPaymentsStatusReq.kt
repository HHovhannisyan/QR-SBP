package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class GetPaymentsStatusReq(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("qrcIds")
    val qrcIds: List<String>
)

