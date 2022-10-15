package ru.mertech.sbpskb.ui.viewModels

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.mertech.repository.Repository
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity
import ru.mertech.sbpskb.pojo.sbp.GetRaiffPaymentsStatusResp
import ru.mertech.sbpskb.pojo.sbp.GetTinkoffPaymentsStatusResp
import ru.mertech.sbpskb.utils.NetworkHelper
import ru.mertech.sbpskb.utils.Resource
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor(
    private val repository: Repository, application: Application,
    private val networkHelper: NetworkHelper
) : AndroidViewModel(application) {
    private val _RaiffbankInfo = MutableLiveData<Resource<GetRaiffPaymentsStatusResp>>()
    val RaiffbankInfo: LiveData<Resource<GetRaiffPaymentsStatusResp>>
        get() = _RaiffbankInfo

    private val _TinkoffbankInfo = MutableLiveData<Resource<GetTinkoffPaymentsStatusResp>>()
    val TinkoffbankInfo: LiveData<Resource<GetTinkoffPaymentsStatusResp>>
        get() = _TinkoffbankInfo

    private val sharedQrId: SharedPreferences =
        application.getSharedPreferences("QrIdSharedPref", Context.MODE_PRIVATE)
    private val sharedpaymentID =
        application.getSharedPreferences("paymentIDSharedPref", MODE_PRIVATE)
    private val sharedEncoded =
        application.getSharedPreferences("encodedSharedPref", MODE_PRIVATE)

    /* fun fetchRaiffPaymentInfo() {
         val qrId = sharedQrId.getString("qrId", null)
         viewModelScope.launch {
             if (qrId != null) {
                 repository.getRaiffBankInfo(qrId)
             }
         }
     }*/

    fun fetchRaiffPaymentInfo() {
        viewModelScope.launch {
            _RaiffbankInfo.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                val qrId = sharedQrId.getString("qrId", null)

                repository.getRaiffBankInfo(qrId!!).let {
                    if (it.isSuccessful) {
                        _RaiffbankInfo.postValue(Resource.success(it.body()))
                    } else _RaiffbankInfo.postValue(Resource.error(it.errorBody().toString(), null))
                }

            } else _RaiffbankInfo.postValue(Resource.error("No internet connection", null))
        }
    }


    fun fetchTinkoffPaymentInfo() {
        viewModelScope.launch {
            _TinkoffbankInfo.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                val encoded = sharedEncoded.getString("encoded", null)
                val paymentID = sharedpaymentID.getString("paymentID", null)

                repository.getTinkoffBankInfo("1605280872049", paymentID!!, encoded!!).let {
                    if (it.isSuccessful) {
                        _TinkoffbankInfo.postValue(Resource.success(it.body()))
                    } else _TinkoffbankInfo.postValue(
                        Resource.error(
                            it.errorBody().toString(),
                            null
                        )
                    )
                }

            } else _TinkoffbankInfo.postValue(Resource.error("No internet connection", null))
        }
    }


    fun getAllPayments(): LiveData<List<PaymentStatusEntity>> = repository.getAllPayments()


    fun addTinkoffPayment(
        amount: String,
        paymentID: String,
        encoded: String,
        img: Int,
        date: String,
        bankName: String
    ) {
        viewModelScope.launch {
            repository.insert(
                PaymentStatusEntity(
                    0,
                    amount,
                    "",
                    paymentID,
                    encoded,
                    img,
                    date,
                    bankName
                )
            )
        }
    }


    fun addRaiffPayment(amount: String, qrId: String, img: Int, date: String, bankName: String) {
        viewModelScope.launch {
            repository.insert(PaymentStatusEntity(0, amount, qrId, "", "", img, date, bankName))
        }
    }


    fun updatePaymentRaiffDB(
        qrId: String,
        context: Context,
        position: Int
    ) {
        repository.updateRaiffPaymentDB(qrId, context, position)
    }

    fun updatePaymentTinkoffDB(
        paymentId: String, encoded: String,
        context: Context,
        position: Int
    ) {
        repository.updateTinkoffPaymentDB(paymentId, encoded, context, position)
    }
}
