package ru.mertech.sbpskb.db.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity

@Dao
interface PaymentDAO {
    @Query("SELECT * FROM paymentstatusentity")
    fun loadPayments(): LiveData<List<PaymentStatusEntity>>

    @Query("SELECT sid FROM paymentstatusentity WHERE date = :date")
    fun returnSid(date: String):Int

    @Insert
    suspend fun insertPayment(paymentStatusEntity: PaymentStatusEntity)

    @Update
    suspend fun updateRaiffPayment(paymentStatusEntity: PaymentStatusEntity)

    @Update
    suspend fun updateTinkoffPayment(paymentStatusEntity: PaymentStatusEntity)
}