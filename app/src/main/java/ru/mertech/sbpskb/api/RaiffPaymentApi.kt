package ru.mertech.sbpskb.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.mertech.sbpskb.pojo.sbp.GetRaiffPaymentsStatusResp

interface RaiffPaymentApi {
    @GET("api/sbp/v1/qr/{qrId}/payment-info")
    suspend fun getRaiffPaymentInfo(@Path("qrId") qrId: String): Response<GetRaiffPaymentsStatusResp>
}