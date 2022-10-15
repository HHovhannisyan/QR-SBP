package ru.mertech.sbpskb.api;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface SkbApi {
  String BASE_URL = "https://landings.skbbank.ru/api2/";
  

  String SKB_TOKEN = "Bearer e8cc203046c2422eca3ccfb55987993c";

    @GET("get-list")
    Single<String> getListCities(@Header("Authorization") String paramString1, @Query("product") String paramString2, @Query("form") String paramString3, @Query("list") String paramString4);

    @Multipart
    @POST("post-claim")
     Single<String> postClaim(@Header("Authorization") String paramString1, @Query("product") String paramString2, @Query("form") String paramString3, @Query("scenario") String paramString4, @Part("first_name") RequestBody paramRequestBody1, @Part("last_name") RequestBody paramRequestBody2, @Part("email") RequestBody paramRequestBody3, @Part("phone") RequestBody paramRequestBody4, @Part("organization_name") RequestBody paramRequestBody5, @Part("organization_taxpayer_number") RequestBody paramRequestBody6, @Part("organization_registration_number") RequestBody paramRequestBody7, @Part("city_code") RequestBody paramRequestBody8, @Part("ldg") RequestBody paramRequestBody9, @Part("tariff") RequestBody paramRequestBody10);

}
