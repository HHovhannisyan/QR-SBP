package ru.mertech.sbpskb.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 ,2\u00020\u0001:\u0001,J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH\'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\'J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\'J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\'J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\'J\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010!\u001a\u00020\"H\'J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010!\u001a\u00020\"H\'J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\b\b\u0001\u0010\'\u001a\u00020(H\'J\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010*\u001a\u00020+H\'R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006-"}, d2 = {"Lru/mertech/sbpskb/api/SbpApi;", "", "data", "Lio/reactivex/Single;", "Lru/mertech/sbpskb/pojo/sbp/GetDataResp;", "getData", "()Lio/reactivex/Single;", "approveRefundTransfer", "Lru/mertech/sbpskb/pojo/sbp/ApproveRefundTransferResp;", "paramApproveRefundTransferReq", "Lru/mertech/sbpskb/pojo/sbp/ApproveRefundTransferReq;", "changeUserPassword", "Lru/mertech/sbpskb/pojo/sbp/ChangeUserPasswordResp;", "paramChangeUserPasswordReq", "Lru/mertech/sbpskb/pojo/sbp/ChangeUserPasswordReq;", "checkCredentials", "Lru/mertech/sbpskb/pojo/sbp/CheckCredentialsResp;", "paramCheckCredentialsReq", "Lru/mertech/sbpskb/pojo/sbp/CheckCredentialsReq;", "checkRefundTransfer", "Lru/mertech/sbpskb/pojo/sbp/CheckRefundTransferResp;", "paramCheckRefundTransferReq", "Lru/mertech/sbpskb/pojo/sbp/CheckRefundTransferReq;", "getOperations", "Lru/mertech/sbpskb/pojo/sbp/GetOperationsResp;", "paramGetOperationsReq", "Lru/mertech/sbpskb/pojo/sbp/GetOperationsReq;", "getRaiffPaymentInfo", "Lru/mertech/sbpskb/pojo/sbp/GetRaiffPaymentsStatusResp;", "qrId", "", "getTinkoffPaymentInfo", "Lru/mertech/sbpskb/pojo/sbp/GetTinkoffPaymentsStatusResp;", "getQRTinkoffReq", "Lru/mertech/sbpskb/pojo/sbp/GetQRTinkoffReq;", "getTinkoffQr", "Lru/mertech/sbpskb/pojo/sbp/AgentTinkoffRegisterQrResp;", "registerRaiffQr", "Lru/mertech/sbpskb/pojo/sbp/AgentRaiffRegisterQrResp;", "paramAgentRaiffRegisterQrReq", "Lru/mertech/sbpskb/pojo/sbp/AgentRaiffRegisterQrReq;", "registerTinkoffQr", "agentTinkoffRegisterQrReq", "Lru/mertech/sbpskb/pojo/sbp/AgentTinkoffRegisterQrReq;", "Companion", "app_debug"})
public abstract interface SbpApi {
    @org.jetbrains.annotations.NotNull()
    public static final ru.mertech.sbpskb.api.SbpApi.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://sbp.api.skbbank.ru/";
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "refund/ApproveRefundTransfer")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.ApproveRefundTransferResp> approveRefundTransfer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.ApproveRefundTransferReq paramApproveRefundTransferReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "user/changeUserPassword")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.ChangeUserPasswordResp> changeUserPassword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.ChangeUserPasswordReq paramChangeUserPasswordReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "Auth/checkcredentials")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.CheckCredentialsResp> checkCredentials(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.CheckCredentialsReq paramCheckCredentialsReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "refund/CheckRefundTransfer")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.CheckRefundTransferResp> checkRefundTransfer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.CheckRefundTransferReq paramCheckRefundTransferReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "organization/getdata")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.GetDataResp> getData();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "qr/getoperations")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.GetOperationsResp> getOperations(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.GetOperationsReq paramGetOperationsReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "api/sbp/v1/qr/{qrId}/payment-info")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.GetRaiffPaymentsStatusResp> getRaiffPaymentInfo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "qrId")
    java.lang.String qrId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "GetState")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.GetTinkoffPaymentsStatusResp> getTinkoffPaymentInfo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.GetQRTinkoffReq getQRTinkoffReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "api/sbp/v1/qr/register")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.AgentRaiffRegisterQrResp> registerRaiffQr(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.AgentRaiffRegisterQrReq paramAgentRaiffRegisterQrReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "v2/Init/")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.AgentTinkoffRegisterQrResp> registerTinkoffQr(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.AgentTinkoffRegisterQrReq agentTinkoffRegisterQrReq);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "v2/GetQr")
    public abstract io.reactivex.Single<ru.mertech.sbpskb.pojo.sbp.AgentTinkoffRegisterQrResp> getTinkoffQr(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.mertech.sbpskb.pojo.sbp.GetQRTinkoffReq getQRTinkoffReq);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/mertech/sbpskb/api/SbpApi$Companion;", "", "()V", "BASE_URL", "", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://sbp.api.skbbank.ru/";
        
        private Companion() {
            super();
        }
    }
}