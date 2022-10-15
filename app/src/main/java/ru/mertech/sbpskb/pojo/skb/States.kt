package ru.mertech.sbpskb.pojo.skb

import com.google.gson.annotations.SerializedName


data class States (
    @SerializedName("duplicate_type")
     val duplicateType: Int = 0,

    @SerializedName("has_call")
    private val hasCall: Int = 0,

    @SerializedName("has_organization_taxpayer_number")
    private val hasOrganizationTaxpayerNumber: Int = 0,

    @SerializedName("is_completed")
    private val isCompleted: Int = 0,

    @SerializedName("is_verified")
     val isVerified: Int = 0,

    @SerializedName("state_code")
    private val stateCode: Int = 0,

    @SerializedName("state_message")
     val stateMessage: String? = null
)