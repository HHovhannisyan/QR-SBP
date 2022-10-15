package ru.mertech.sbpskb.pojo.dadata;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lru/mertech/sbpskb/pojo/dadata/Data;", "", "inn", "", "ogrn", "address", "Lru/mertech/sbpskb/pojo/dadata/Address;", "(JJLru/mertech/sbpskb/pojo/dadata/Address;)V", "getAddress", "()Lru/mertech/sbpskb/pojo/dadata/Address;", "getInn", "()J", "getOgrn", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class Data {
    @com.google.gson.annotations.SerializedName(value = "inn")
    private final long inn = 0L;
    @com.google.gson.annotations.SerializedName(value = "ogrn")
    private final long ogrn = 0L;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "address")
    private final ru.mertech.sbpskb.pojo.dadata.Address address = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.pojo.dadata.Data copy(long inn, long ogrn, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.pojo.dadata.Address address) {
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
    
    public Data(long inn, long ogrn, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.pojo.dadata.Address address) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getInn() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getOgrn() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.pojo.dadata.Address component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.pojo.dadata.Address getAddress() {
        return null;
    }
}