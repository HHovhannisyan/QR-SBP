package ru.mertech.sbpskb.db.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class PaymentStatusEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "sid")
    var id: Int,
    var amount: String,
    var qrId: String,
    var paymentID: String,
    var encoded: String,
    val image:Int,
    @ColumnInfo(name ="date")
    val date:String,
    val bankName:String
): Parcelable
