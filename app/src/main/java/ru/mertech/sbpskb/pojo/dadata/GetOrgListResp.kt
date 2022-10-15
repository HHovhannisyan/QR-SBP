package ru.mertech.sbpskb.pojo.dadata
import com.google.gson.annotations.SerializedName


data class GetOrgListResp(
    @SerializedName("suggestions")
    val organizations: List<Organization>
)