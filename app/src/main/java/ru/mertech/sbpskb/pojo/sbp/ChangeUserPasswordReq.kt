package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class ChangeUserPasswordReq(
    @SerializedName("login")
    val login: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("newPassword")
    val newPassword: String
)