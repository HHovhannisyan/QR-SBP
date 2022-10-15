package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class GetOperationsReq(
    @SerializedName("merchantId")
    val merchantId: String,
    @SerializedName("dateStart")
    val dateStart: String,
    @SerializedName("dateEnd")
    val dateEnd: String
)