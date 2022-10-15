package ru.mertech.sbpskb.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity

class PaymentDiffUtil (
    private val oldList: List<PaymentStatusEntity>,
    private val newList: List<PaymentStatusEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].amount == newList[newItemPosition].amount
                && oldList[oldItemPosition].paymentID == newList[newItemPosition].paymentID
                && oldList[oldItemPosition].image == newList[newItemPosition].image
    }
}