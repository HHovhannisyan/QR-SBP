package ru.mertech.sbpskb.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity


@BindingAdapter("android:imgSrc")
fun getImg(imageView: ImageView, paymentStatusEntity: PaymentStatusEntity) {
    imageView.setImageResource(paymentStatusEntity.image)
}

@BindingAdapter("android:date")
fun getDate(textView: TextView, paymentStatusEntity: PaymentStatusEntity) {
    textView.text = paymentStatusEntity.date
}