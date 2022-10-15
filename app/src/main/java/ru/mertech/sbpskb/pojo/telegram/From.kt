package ru.mertech.sbpskb.pojo.telegram

import com.google.gson.annotations.SerializedName

data class From(
    @SerializedName("first_name")
    private val first_name: String? = null,

    @SerializedName("id")
    private val id: Int = 0,

    @SerializedName("is_bot")
    private val is_bot: Boolean = false,

    @SerializedName("username")
    private val username: String? = null
)

