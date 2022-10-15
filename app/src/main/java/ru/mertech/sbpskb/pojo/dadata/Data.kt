package ru.mertech.sbpskb.pojo.dadata

import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("inn") val inn: Long,
    @SerializedName("ogrn")
    val ogrn: Long,
    @SerializedName("address")
    val address: Address
)