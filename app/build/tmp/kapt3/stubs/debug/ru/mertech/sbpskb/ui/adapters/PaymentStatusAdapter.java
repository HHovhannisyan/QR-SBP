package ru.mertech.sbpskb.ui.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lru/mertech/sbpskb/ui/adapters/PaymentStatusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mertech/sbpskb/ui/adapters/PaymentStatusAdapter$MyViewHolder;", "shareViewModel", "Lru/mertech/sbpskb/ui/viewModels/ShareViewModel;", "context", "Landroid/content/Context;", "(Lru/mertech/sbpskb/ui/viewModels/ShareViewModel;Landroid/content/Context;)V", "dataList", "", "Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "paymentData", "MyViewHolder", "app_debug"})
public final class PaymentStatusAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<ru.mertech.sbpskb.ui.adapters.PaymentStatusAdapter.MyViewHolder> {
    private final ru.mertech.sbpskb.ui.viewModels.ShareViewModel shareViewModel = null;
    private final android.content.Context context = null;
    private java.util.List<ru.mertech.sbpskb.db.entity.PaymentStatusEntity> dataList;
    
    public PaymentStatusAdapter(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.ui.viewModels.ShareViewModel shareViewModel, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ru.mertech.sbpskb.ui.adapters.PaymentStatusAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.ui.adapters.PaymentStatusAdapter.MyViewHolder holder, int position) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<ru.mertech.sbpskb.db.entity.PaymentStatusEntity> paymentData) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lru/mertech/sbpskb/ui/adapters/PaymentStatusAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mertech/sbpskb/databinding/ItemPaymentStatusBinding;", "(Lru/mertech/sbpskb/databinding/ItemPaymentStatusBinding;)V", "bind", "", "paymentStatusEntity", "Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;", "shareViewModel", "Lru/mertech/sbpskb/ui/viewModels/ShareViewModel;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final ru.mertech.sbpskb.databinding.ItemPaymentStatusBinding binding = null;
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        ru.mertech.sbpskb.databinding.ItemPaymentStatusBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity, @org.jetbrains.annotations.NotNull()
        ru.mertech.sbpskb.ui.viewModels.ShareViewModel shareViewModel, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
}