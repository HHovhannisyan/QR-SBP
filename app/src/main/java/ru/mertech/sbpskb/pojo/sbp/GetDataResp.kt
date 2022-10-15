package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class GetDataResp(
    @SerializedName("messageId")
    val messageId: String,
    @SerializedName("errorId")
    val errorId: String,
    @SerializedName("errCode")
    val errCode: String,
    @SerializedName("errMess")
    val errMess: String,
    @SerializedName("merchants")
    val merchants: List<Merchant>
)