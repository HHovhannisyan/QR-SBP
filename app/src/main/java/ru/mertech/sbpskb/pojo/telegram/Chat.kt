package ru.mertech.sbpskb.pojo.telegram

import com.google.gson.annotations.SerializedName


data class Chat(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("type")
    val type: String
)