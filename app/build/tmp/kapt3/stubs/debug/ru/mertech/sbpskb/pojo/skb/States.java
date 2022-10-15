package ru.mertech.sbpskb.pojo.skb;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c2\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\nH\u00c6\u0003JQ\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\nH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0010\u0010\b\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lru/mertech/sbpskb/pojo/skb/States;", "", "duplicateType", "", "hasCall", "hasOrganizationTaxpayerNumber", "isCompleted", "isVerified", "stateCode", "stateMessage", "", "(IIIIIILjava/lang/String;)V", "getDuplicateType", "()I", "getStateMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class States {
    @com.google.gson.annotations.SerializedName(value = "duplicate_type")
    private final int duplicateType = 0;
    @com.google.gson.annotations.SerializedName(value = "has_call")
    private final int hasCall = 0;
    @com.google.gson.annotations.SerializedName(value = "has_organization_taxpayer_number")
    private final int hasOrganizationTaxpayerNumber = 0;
    @com.google.gson.annotations.SerializedName(value = "is_completed")
    private final int isCompleted = 0;
    @com.google.gson.annotations.SerializedName(value = "is_verified")
    private final int isVerified = 0;
    @com.google.gson.annotations.SerializedName(value = "state_code")
    private final int stateCode = 0;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "state_message")
    private final java.lang.String stateMessage = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.pojo.skb.States copy(int duplicateType, int hasCall, int hasOrganizationTaxpayerNumber, int isCompleted, int isVerified, int stateCode, @org.jetbrains.annotations.Nullable()
    java.lang.String stateMessage) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public States() {
        super();
    }
    
    public States(int duplicateType, int hasCall, int hasOrganizationTaxpayerNumber, int isCompleted, int isVerified, int stateCode, @org.jetbrains.annotations.Nullable()
    java.lang.String stateMessage) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getDuplicateType() {
        return 0;
    }
    
    private final int component2() {
        return 0;
    }
    
    private final int component3() {
        return 0;
    }
    
    private final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int isVerified() {
        return 0;
    }
    
    private final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStateMessage() {
        return null;
    }
}