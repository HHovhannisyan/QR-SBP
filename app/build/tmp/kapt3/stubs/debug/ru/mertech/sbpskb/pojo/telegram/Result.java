package ru.mertech.sbpskb.pojo.telegram;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c2\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c2\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u00c2\u0003JA\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\nH\u00d6\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\b\u001a\u00020\u00058\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lru/mertech/sbpskb/pojo/telegram/Result;", "", "chat", "Lru/mertech/sbpskb/pojo/telegram/Chat;", "date", "", "from", "Lru/mertech/sbpskb/pojo/telegram/From;", "message_id", "text", "", "(Lru/mertech/sbpskb/pojo/telegram/Chat;ILru/mertech/sbpskb/pojo/telegram/From;ILjava/lang/String;)V", "getFrom", "()Lru/mertech/sbpskb/pojo/telegram/From;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Result {
    @com.google.gson.annotations.SerializedName(value = "chat")
    private final ru.mertech.sbpskb.pojo.telegram.Chat chat = null;
    @com.google.gson.annotations.SerializedName(value = "date")
    private final int date = 0;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "from")
    private final ru.mertech.sbpskb.pojo.telegram.From from = null;
    @com.google.gson.annotations.SerializedName(value = "message_id")
    private final int message_id = 0;
    @com.google.gson.annotations.SerializedName(value = "text")
    private final java.lang.String text = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ru.mertech.sbpskb.pojo.telegram.Result copy(@org.jetbrains.annotations.Nullable()
    ru.mertech.sbpskb.pojo.telegram.Chat chat, int date, @org.jetbrains.annotations.Nullable()
    ru.mertech.sbpskb.pojo.telegram.From from, int message_id, @org.jetbrains.annotations.Nullable()
    java.lang.String text) {
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
    
    public Result() {
        super();
    }
    
    public Result(@org.jetbrains.annotations.Nullable()
    ru.mertech.sbpskb.pojo.telegram.Chat chat, int date, @org.jetbrains.annotations.Nullable()
    ru.mertech.sbpskb.pojo.telegram.From from, int message_id, @org.jetbrains.annotations.Nullable()
    java.lang.String text) {
        super();
    }
    
    private final ru.mertech.sbpskb.pojo.telegram.Chat component1() {
        return null;
    }
    
    private final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.mertech.sbpskb.pojo.telegram.From component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.mertech.sbpskb.pojo.telegram.From getFrom() {
        return null;
    }
    
    private final int component4() {
        return 0;
    }
    
    private final java.lang.String component5() {
        return null;
    }
}