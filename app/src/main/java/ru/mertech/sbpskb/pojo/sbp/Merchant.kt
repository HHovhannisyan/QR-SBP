package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class Merchant(
    @SerializedName("brandName")
    val brandName: String,
    @SerializedName("mcc")
    val mcc: String,
    @SerializedName("zip")
    val zip: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("contactPhoneNumber")
    val contactPhoneNumber: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)