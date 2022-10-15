package ru.mertech.sbpskb.pojo.dadata

import com.google.gson.annotations.SerializedName


data class Organization(
    @SerializedName("value")
    val name: String,
    @SerializedName("data")
    val data: Data
)