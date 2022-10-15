package ru.mertech.sbpskb.pojo.sbp

import com.google.gson.annotations.SerializedName


data class Operation(
    @SerializedName("pam")
    val pam: String,
    @SerializedName("datePayed")
     var datePayed: String,
    @SerializedName("amount")
     var amount: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("transactionNumber")
    val transactionNumber: String,
    @SerializedName("qrcId")
    val qrcId: String,
    @SerializedName("payerBankId")
    val payerBankId: String,
    @SerializedName("payerBankName")
    val payerBankName: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("tspcommission")
     var tspCommission: String,
    @SerializedName("operationType")
    val operationType: String,
    @SerializedName("merchantId")
    val merchantId: String
)