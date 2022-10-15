package ru.mertech.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mertech.sbpskb.db.room.PaymentDAO
import ru.mertech.sbpskb.db.room.PaymentDB
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: PaymentDB.Callback): PaymentDB {
        return Room.databaseBuilder(application, PaymentDB::class.java, "payment_db")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideArticleDao(db: PaymentDB): PaymentDAO {
        return db.paymentDAO()
    }

}