package ru.mertech.sbpskb.pojo.skb

import com.google.gson.annotations.SerializedName


data class PostClaimResponse(
    @SerializedName("hash")
    private val hash: String? = null,

    @SerializedName("id")
    private val id: Int = 0,

    @SerializedName("states")
     val states: States? = null
)