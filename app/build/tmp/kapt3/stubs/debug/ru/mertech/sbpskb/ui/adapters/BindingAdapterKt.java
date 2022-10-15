package ru.mertech.sbpskb.ui.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\t"}, d2 = {"getDate", "", "textView", "Landroid/widget/TextView;", "paymentStatusEntity", "Lru/mertech/sbpskb/db/entity/PaymentStatusEntity;", "getImg", "imageView", "Landroid/widget/ImageView;", "app_debug"})
public final class BindingAdapterKt {
    
    @androidx.databinding.BindingAdapter(value = {"android:imgSrc"})
    public static final void getImg(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"android:date"})
    public static final void getDate(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.NotNull()
    ru.mertech.sbpskb.db.entity.PaymentStatusEntity paymentStatusEntity) {
    }
}