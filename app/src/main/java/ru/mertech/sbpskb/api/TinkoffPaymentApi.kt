package ru.mertech.sbpskb.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.mertech.sbpskb.pojo.sbp.GetQRTinkoffReq
import ru.mertech.sbpskb.pojo.sbp.GetTinkoffPaymentsStatusResp

interface TinkoffPaymentApi {
    @POST("GetState")
    suspend fun getTinkoffPaymentInfo(@Body getQRTinkoffReq: GetQRTinkoffReq): Response<GetTinkoffPaymentsStatusResp>
}