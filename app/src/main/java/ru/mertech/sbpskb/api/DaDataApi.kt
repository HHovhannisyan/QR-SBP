package ru.mertech.sbpskb.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import ru.mertech.sbpskb.pojo.dadata.GetOrgListReq
import ru.mertech.sbpskb.pojo.dadata.GetOrgListResp

interface DaDataApi {
    @POST("rs/suggest/party")
    fun getOrgList(
        @Header("Authorization") paramString: String,
        @Body paramGetOrgListReq: GetOrgListReq
    ): Single<GetOrgListResp>

    companion object {
        const val BASE_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/"
    }
}