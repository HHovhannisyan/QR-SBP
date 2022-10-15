package ru.mertech.sbpskb.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity
import javax.inject.Inject

@Database(version = 1, entities = [PaymentStatusEntity::class])

abstract class PaymentDB : RoomDatabase() {
    abstract fun paymentDAO(): PaymentDAO

    class Callback @Inject constructor() : RoomDatabase.Callback()
}