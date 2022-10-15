package ru.mertech.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.mertech.sbpskb.ApiKeyInterceptor
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.api.RaiffPaymentApi
import ru.mertech.sbpskb.api.SbpApi
import ru.mertech.sbpskb.api.TinkoffPaymentApi
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity
import ru.mertech.sbpskb.db.room.PaymentDAO
import ru.mertech.sbpskb.pojo.sbp.GetQRTinkoffReq
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class Repository @Inject constructor(
    private val paymentDAO: PaymentDAO,
    private val tinkoffPaymentApi: TinkoffPaymentApi, private val raiffPaymentApi: RaiffPaymentApi
) {

    fun getAllPayments(): LiveData<List<PaymentStatusEntity>> {
        return paymentDAO.loadPayments()
    }


    suspend fun insert(paymentStatusEntity: PaymentStatusEntity) {
        paymentDAO.insertPayment(paymentStatusEntity)
    }

    suspend fun updateTinkoffPayment(
        paymentStatusEntity: PaymentStatusEntity
    ) {
        paymentDAO.updateTinkoffPayment(
            paymentStatusEntity

        )
    }

    private suspend fun updateRaiffPayment(
        paymentStatusEntity: PaymentStatusEntity
    ) {
        paymentDAO.updateRaiffPayment(
            paymentStatusEntity
        )
    }


    fun updateRaiffPaymentDB(
        qrId: String,
        context: Context,
        position: Int
    ) {
        val mDate = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault())
        val currentDate = formatter.format(mDate)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(ApiKeyInterceptor())
            .readTimeout(60L, TimeUnit.SECONDS)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build()
        val retrofitClient = Retrofit.Builder()
            .baseUrl("https://test.ecom.raiffeisen.ru/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val compositeDisposable = CompositeDisposable()
        val disposable = retrofitClient.create(SbpApi::class.java)
            .getRaiffPaymentInfo(qrId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ (_, _, amount, _, _, code, _, paymentStatus, _) ->
                if (code == "SUCCESS" && paymentStatus == "SUCCESS") {
                    if (amount.toString().endsWith(".0")) {
                        CoroutineScope(Dispatchers.IO).launch {
                            updateRaiffPayment(
                                PaymentStatusEntity(
                                    (position + 1),
                                    "+${amount.toInt()} P",
                                    qrId, "", "",
                                    R.drawable.ic_success_db, currentDate,
                                    "Raiff"
                                )
                            )
                        }
                    } else {
                        CoroutineScope(Dispatchers.IO).launch {
                            updateRaiffPayment(
                                PaymentStatusEntity(
                                    (position + 1),
                                    "+${amount} P",
                                    qrId, "", ",",
                                    R.drawable.ic_success_db, currentDate,
                                    "Raiff"
                                )
                            )
                        }
                    }
                } else if (code == "SUCCESS" && paymentStatus == "NO_INFO") {

                    if (amount.toString().endsWith(".0")) {
                        CoroutineScope(Dispatchers.IO).launch {
                            updateRaiffPayment(
                                PaymentStatusEntity(
                                    (position + 1),
                                    "+${amount.toInt()} P",
                                    qrId, "", "",
                                    R.drawable.ic_failed_db, currentDate,
                                    "Raiff"
                                )
                            )
                        }
                    } else {
                        CoroutineScope(Dispatchers.IO).launch {
                            updateRaiffPayment(
                                PaymentStatusEntity(
                                    (position + 1),
                                    "+${amount} P",
                                    qrId, "", "",
                                    R.drawable.ic_failed_db, currentDate,
                                    "Raiff"
                                )
                            )
                        }
                    }
                } else {
                    Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }) {
                val str = context.getString(R.string.timeout_error)
                Toast.makeText(context, "ERROR \n" + str, Toast.LENGTH_SHORT).show()
            }
        compositeDisposable.add(disposable)
    }

    fun updateTinkoffPaymentDB(
        paymentId: String, encoded: String,
        context: Context,
        position: Int
    ) {
        val mDate = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault())
        val currentDate = formatter.format(mDate)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(60L, TimeUnit.SECONDS)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build()
        val retrofitClient = Retrofit.Builder()
            .baseUrl("https://securepay.tinkoff.ru/v2/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val getQRTinkoffReq = GetQRTinkoffReq(
            "1605280872049", paymentId,
            encoded
        )

        val compositeDisposable = CompositeDisposable()
        val disposable = retrofitClient.create(SbpApi::class.java)
            .getTinkoffPaymentInfo(getQRTinkoffReq)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ (_, status, amount, _, _, errorCode, isSucceed) ->

                if (errorCode == "0" && isSucceed && status == "FORM_SHOWED") {
                    CoroutineScope(Dispatchers.IO).launch {
                        updateTinkoffPayment(
                            PaymentStatusEntity(
                                (position + 1),
                                "+ ${amount / 100} P", "", paymentId, encoded,
                                R.drawable.ic_failed_db, currentDate, "Tinkoff"
                            )
                        )
                    }
                } else {
                    Toast.makeText(
                        context,
                        "ERROR \n",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if (errorCode == "0" && isSucceed && status == "CONFIRMED") {
                    CoroutineScope(Dispatchers.IO).launch {
                        updateTinkoffPayment(
                            PaymentStatusEntity(
                                (position + 1),
                                "+${amount / 100} P", "", paymentId, encoded,
                                R.drawable.ic_success_db, currentDate, "Tinkoff"
                            )
                        )
                    }
                }
            }) { throwable ->
                if (throwable is HttpException && throwable.code() == 405) {
                    val str = context.getString(R.string.timeout_error)
                    Toast.makeText(
                        context,
                        "ERROR \n" + str,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val str = context.getString(R.string.timeout_error)
                    Toast.makeText(context, "ERROR \n" + str, Toast.LENGTH_SHORT).show()
                }
            }
        compositeDisposable.add(disposable)
    }

    suspend fun getRaiffBankInfo(qrId: String) = raiffPaymentApi.getRaiffPaymentInfo(qrId)
    suspend fun getTinkoffBankInfo(terminalKey: String, paymentId: String, encoded: String) =
        tinkoffPaymentApi.getTinkoffPaymentInfo(GetQRTinkoffReq(terminalKey, paymentId, encoded))

}