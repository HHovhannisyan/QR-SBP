package ru.mertech.sbpskb.ui.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB>\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter$ViewHolder;", "context", "Landroid/content/Context;", "items", "", "Landroid/bluetooth/le/ScanResult;", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "device", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter$OnItemClickListener;", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "OnItemClickListener", "ViewHolder", "app_debug"})
public final class ScanResultAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<ru.mertech.sbpskb.ui.adapters.ScanResultAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<android.bluetooth.le.ScanResult> items = null;
    private final kotlin.jvm.functions.Function1<android.bluetooth.le.ScanResult, kotlin.Unit> onClickListener = null;
    private ru.mertech.sbpskb.ui.adapters.ScanResultAdapter.OnItemClickListener onItemClickListener;
    
    public ScanResultAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<android.bluetooth.le.ScanResult> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.bluetooth.le.ScanResult, kotlin.Unit> onClickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ru.mertech.sbpskb.ui.adapters.ScanResultAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.ui.adapters.ScanResultAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.ui.adapters.ScanResultAdapter.OnItemClickListener onItemClickListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "onClickListener", "Lkotlin/Function1;", "Landroid/bluetooth/le/ScanResult;", "Lkotlin/ParameterName;", "name", "device", "", "onItemClickListener", "Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter$OnItemClickListener;", "(Landroid/content/Context;Landroid/view/View;Lkotlin/jvm/functions/Function1;Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter$OnItemClickListener;)V", "bind", "result", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.content.Context context = null;
        private final android.view.View view = null;
        private final kotlin.jvm.functions.Function1<android.bluetooth.le.ScanResult, kotlin.Unit> onClickListener = null;
        private final ru.mertech.sbpskb.ui.adapters.ScanResultAdapter.OnItemClickListener onItemClickListener = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super android.bluetooth.le.ScanResult, kotlin.Unit> onClickListener, @org.jetbrains.annotations.NotNull()
        ru.mertech.sbpskb.ui.adapters.ScanResultAdapter.OnItemClickListener onItemClickListener) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        android.bluetooth.le.ScanResult result) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lru/mertech/sbpskb/ui/adapters/ScanResultAdapter$OnItemClickListener;", "", "onItemClicked", "", "position", "", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClicked(int position);
    }
}