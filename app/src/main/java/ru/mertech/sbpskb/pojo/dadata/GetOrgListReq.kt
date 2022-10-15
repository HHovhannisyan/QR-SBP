package ru.mertech.sbpskb.pojo.dadata
import com.google.gson.annotations.SerializedName


data class GetOrgListReq(
    @SerializedName("query")
    val orgName: String,
    @SerializedName("count")
    val count: Int
)