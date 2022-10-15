package ru.mertech.sbpskb.ui.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.mertech.sbpskb.Constants
import ru.mertech.sbpskb.Constants.btFail
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.databinding.PaymentInfoFragmentBinding
import ru.mertech.sbpskb.ui.viewModels.ShareViewModel
import ru.mertech.sbpskb.utils.CommandUtil
import ru.mertech.sbpskb.utils.Status
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class PaymentInfoFragment : Fragment() {
    private val viewModel: ShareViewModel by viewModels()
    private lateinit var sharedQrId: SharedPreferences
    private lateinit var sharedEncoded: SharedPreferences
    private lateinit var sharedpaymentID: SharedPreferences
    private lateinit var binding: PaymentInfoFragmentBinding
    private lateinit var mCoroutineScope: CoroutineScope

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PaymentInfoFragmentBinding.inflate(inflater, container, false)

        mCoroutineScope = CoroutineScope(Dispatchers.Main)

        val sh = requireActivity().getSharedPreferences("SpinnerSharedPref", MODE_PRIVATE)
        val spinnerPosition = sh.getInt("last_val", 0)

        sharedQrId =
            requireActivity().getSharedPreferences("QrIdSharedPref", MODE_PRIVATE)
        sharedpaymentID =
            requireActivity().getSharedPreferences("paymentIDSharedPref", MODE_PRIVATE)
        sharedEncoded =
            requireActivity().getSharedPreferences("encodedSharedPref", MODE_PRIVATE)

        val paymentID = sharedpaymentID.getString("paymentID", null)

        val qrId = sharedQrId.getString("qrId", null)
        val encoded = sharedEncoded.getString("encoded", null)

        if (spinnerPosition == 0) {
            if (paymentID != null && encoded != null) {
                viewModel.fetchTinkoffPaymentInfo()
                getPaymentStatusTinkoff( paymentID, encoded)
            }
        }
        if (spinnerPosition == 1) {
            if (qrId != null) {
                viewModel.fetchRaiffPaymentInfo()
                getPaymentStatusRaiff(qrId)
            }
        }
        return binding.root
    }

    private fun getPaymentStatusRaiff(qrId: String) {
        viewModel.RaiffbankInfo.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    val currentDate = getCurrentDate()
                    if (it.data?.code == "SUCCESS" && it.data.paymentStatus == "SUCCESS") {
                        showPaymentInfo("Успешно!", true)
                        if (it.data.amount.toString().endsWith(".0")) {
                            viewModel.addRaiffPayment(
                                "+${it.data.amount.toInt()} P",
                                qrId,
                                R.drawable.ic_success_db,
                                currentDate, "Raiff"
                            )
                        } else {
                            viewModel.addRaiffPayment(
                                "+${it.data.amount} P",
                                qrId,
                                R.drawable.ic_success_db,
                                currentDate, "Raiff"
                            )
                        }
                    } else if (it.data?.code == "SUCCESS" && it.data.paymentStatus == "NO_INFO") {
                        showPaymentInfo("There Are No Payments", false)
                        if (it.data.amount.toString().endsWith(".0")) {
                            viewModel.addRaiffPayment(
                                "+${it.data.amount.toInt()} P",
                                qrId,
                                R.drawable.ic_failed_db,
                                currentDate, "Raiff"
                            )
                        } else {
                            viewModel.addRaiffPayment(
                                "+${it.data.amount} P",
                                qrId,
                                R.drawable.ic_failed_db,
                                currentDate, "Raiff"
                            )
                        }
                    }
                }

                Status.ERROR -> {
                    val str = requireContext().getString(R.string.timeout_error)
                    showPaymentInfo("ERROR \n$str", false)
                }
                else -> {
                    Log.d("TAG", "Unknown status")
                }
            }
        }
    }


    private fun getPaymentStatusTinkoff(paymentId: String, encoded: String) {
        viewModel.TinkoffbankInfo.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    val currentDate = getCurrentDate()
                    if (it.data?.errorCode == "0" && it.data.isSucceed && it.data.status == "FORM_SHOWED") {
                        showPaymentInfo("There Are No Payments", false)
                        viewModel.addTinkoffPayment(
                            "+ ${it.data.amount / 100} P",
                            paymentId, encoded,
                            R.drawable.ic_failed_db,
                            currentDate, "Tinkoff"
                        )
                    } else {
                        showPaymentInfo("ERROR", false)
                    }
                    if (it.data?.errorCode == "0" && it.data.isSucceed && it.data.status == "CONFIRMED") {
                        showPaymentInfo("Успешно!", false)
                        viewModel.addTinkoffPayment(
                            "+${it.data.amount / 100} P",
                            paymentId, encoded,
                            R.drawable.ic_success_db,
                            currentDate, "Tinkoff"
                        )
                    }
                }

                Status.ERROR -> {
                    val str = getString(R.string.timeout_error)
                    showPaymentInfo(str, false)
                }
                else -> {}
            }
        }
    }

    private fun showPaymentInfo(status: String, statusBool: Boolean) {
        binding.resultTxt.text = status
        val sh: SharedPreferences =
            requireActivity().getSharedPreferences("SharedPrefAddress", MODE_PRIVATE)

        val deviceAddress = sh.getString("deviceAddress", "")

       /* if (deviceAddress != null) {
            CommandUtil(requireContext(), mCoroutineScope).sendCommand(
                deviceAddress,
                Constants.btClean
            )
        }*/
        if (statusBool) {
            binding.resultIvPayment.setImageDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.success_big
                )
            )
            binding.paymentInfoTxt.visibility = View.VISIBLE
            if (deviceAddress != null) {
                CommandUtil(requireContext(), mCoroutineScope).sendCommand(
                    deviceAddress,
                    Constants.btSuccess
                )
            }
        } else {
            binding.resultIvPayment.setImageDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_fail
                )
            )
            if (deviceAddress != null) {
                CommandUtil(requireContext(), mCoroutineScope).sendCommand(deviceAddress, btFail)
            }
        }
    }

    private fun getCurrentDate(): String {
        val mDate = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd MMMM yyyy, HH:mm:ss", Locale.getDefault())
        return formatter.format(mDate)
    }
}