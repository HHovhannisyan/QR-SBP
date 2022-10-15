package ru.mertech.sbpskb.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.mertech.sbpskb.pojo.sbp.*

interface SbpApi {
    @POST("refund/ApproveRefundTransfer")
    fun approveRefundTransfer(@Body paramApproveRefundTransferReq: ApproveRefundTransferReq): Single<ApproveRefundTransferResp>

    @POST("user/changeUserPassword")
    fun changeUserPassword(@Body paramChangeUserPasswordReq: ChangeUserPasswordReq): Single<ChangeUserPasswordResp>

    @POST("Auth/checkcredentials")
    fun checkCredentials(@Body paramCheckCredentialsReq: CheckCredentialsReq): Single<CheckCredentialsResp>

    @POST("refund/CheckRefundTransfer")
    fun checkRefundTransfer(@Body paramCheckRefundTransferReq: CheckRefundTransferReq): Single<CheckRefundTransferResp>

    @get:GET("organization/getdata")
    val data: Single<GetDataResp>

    @POST("qr/getoperations")
    fun getOperations(@Body paramGetOperationsReq: GetOperationsReq): Single<GetOperationsResp>

    /*    @POST("qr/getpaymentsstatus")
        fun getPaymentsStatus(@Body paramGetPaymentsStatusReq: GetPaymentsStatusReq): Single<GetPaymentsStatusResp>*/

    @GET("api/sbp/v1/qr/{qrId}/payment-info")
    fun getRaiffPaymentInfo(@Path("qrId") qrId: String): Single<GetRaiffPaymentsStatusResp>

    /*  @GET("api/sbp/v1/qr/{qrId}/payment-info")
     suspend fun getRaiffPaymentInfo1(@Path("qrId") qrId: String): Response<GetRaiffPaymentsStatusResp>*/

    /*  @POST("GetState")
      fun getTinkoffPaymentInfo1(@Body getQRTinkoffReq: GetQRTinkoffReq): Response<GetTinkoffPaymentsStatusResp>
  */
    @POST("GetState")
    fun getTinkoffPaymentInfo(@Body getQRTinkoffReq: GetQRTinkoffReq): Single<GetTinkoffPaymentsStatusResp>

    // @POST("qr/register")
    @POST("api/sbp/v1/qr/register")
    fun registerRaiffQr(@Body paramAgentRaiffRegisterQrReq: AgentRaiffRegisterQrReq): Single<AgentRaiffRegisterQrResp>

    @POST("v2/Init/")
    fun registerTinkoffQr(@Body agentTinkoffRegisterQrReq: AgentTinkoffRegisterQrReq): Single<AgentTinkoffRegisterQrResp>

    @POST("v2/GetQr")
    fun getTinkoffQr(@Body getQRTinkoffReq: GetQRTinkoffReq): Single<AgentTinkoffRegisterQrResp>

    companion object {
        const val BASE_URL = "https://sbp.api.skbbank.ru/"
    }
}