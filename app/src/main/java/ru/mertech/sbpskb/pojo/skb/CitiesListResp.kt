package ru.mertech.sbpskb.pojo.skb

import com.google.gson.annotations.SerializedName

data class CitiesListResp(@SerializedName("list") val cites: HashMap<String, String>)
