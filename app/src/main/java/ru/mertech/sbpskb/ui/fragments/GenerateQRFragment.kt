package ru.mertech.sbpskb.ui.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.mertech.sbpskb.Constants
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.databinding.FragmentGenerateqrBinding
import ru.mertech.sbpskb.utils.CommandUtil


@AndroidEntryPoint
class GenerateQRFragment : Fragment(), View.OnClickListener {
    private lateinit var fragmentGenerateqrBinding: FragmentGenerateqrBinding
    private val minValueTinkoff = 10

    private lateinit var mCoroutineScope: CoroutineScope

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentGenerateqrBinding = FragmentGenerateqrBinding.inflate(inflater, container, false)
        mCoroutineScope = CoroutineScope(Dispatchers.Main)

        fragmentGenerateqrBinding.amountEdittxt.showSoftInputOnFocus = false
        fragmentGenerateqrBinding.pin1Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin2Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin3Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin4Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin5Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin6Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin7Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin8Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin9Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pin0Btn.setOnClickListener(this)
        fragmentGenerateqrBinding.pinCommaBtn.setOnClickListener(this)
        fragmentGenerateqrBinding.pinCleanBtn.isClickable = false

        fragmentGenerateqrBinding.pinCleanBtn.setOnClickListener {
            val text =
                fragmentGenerateqrBinding.amountEdittxt.text.toString()
            if (text.isNotEmpty()) {
                fragmentGenerateqrBinding.amountEdittxt.setText(
                    text.substring(
                        0,
                        text.length - 1
                    )
                )
            } else {
                fragmentGenerateqrBinding.amountEdittxt.setText("")
            }

            fragmentGenerateqrBinding.amountEdittxt.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    /* fragmentGenerateqrBinding.amountEdittxt.setSelection(
                         fragmentGenerateqrBinding.amountEdittxt.text.length
                     )*/

                    fragmentGenerateqrBinding.pinCleanBtn.isEnabled =
                        charSequence.toString().isNotEmpty()
                }

                override fun afterTextChanged(editable: Editable) {}
            })
        }


        val sh = requireActivity().getSharedPreferences("SpinnerSharedPref", MODE_PRIVATE)
        val spinnerPosition = sh.getInt("last_val", 0)

        val sharedPrefAddress =
            requireActivity().getSharedPreferences("SharedPrefAddress", MODE_PRIVATE)
        val deviceAddress = sharedPrefAddress.getString("deviceAddress", "")

        if (deviceAddress.isNullOrEmpty()) {
            Toast.makeText(
                requireContext(),
                "This device is not connected to a Qr Display. Please, turn on BT & Location and connect to the QR display",
                Toast.LENGTH_LONG
            ).show()
        }

        fragmentGenerateqrBinding.getQRBtn.setOnClickListener {

            if (deviceAddress.isNullOrEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "This device is not connected to a Qr Display. Please, turn on BT & Location and connect to the QR display",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                if (fragmentGenerateqrBinding.amountEdittxt.text.toString().isNotEmpty()) {
                    val numberAsString = fragmentGenerateqrBinding.amountEdittxt.text.toString()

                    val bundle = Bundle()
                    val statusFragment = StatusFragment()
                    statusFragment.arguments = bundle

                    bundle.putString("amount", numberAsString)


                    if (spinnerPosition == 1) {
                        try {
                            val number = numberAsString.toInt()
                            if (number in 1..9999999) {
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(
                                        R.id.nav_host_fragment_activity_generate_qr,
                                        statusFragment
                                    ).commit()
                            } else {
                                Toast.makeText(
                                    context,
                                    "The amount must be from 1 to  10000000",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } catch (e: NumberFormatException) {
                            try {
                                val number = numberAsString.toFloat()
                                if (number < 1.0) {

                                    Toast.makeText(
                                        context,
                                        "The amount must be getter than 0",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    requireActivity().supportFragmentManager.beginTransaction()
                                        .replace(
                                            R.id.nav_host_fragment_activity_generate_qr,
                                            statusFragment
                                        ).commit()
                                }
                            } catch (ex: NumberFormatException) {
                                ex.printStackTrace()

                            }
                        }
                    }

                    if (spinnerPosition == 0) {
                        try {
                            val number = numberAsString.toInt()
                            if (number in minValueTinkoff..599999) {
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(
                                        R.id.nav_host_fragment_activity_generate_qr,
                                        statusFragment
                                    ).commit()
                                //CommandUtil(requireContext(), mCoroutineScope).sendCommand(deviceAddress, Constants.btClean)
                            } else {
                                Toast.makeText(
                                    context,
                                    "Неверная сумма. Сумма должна быть в диапазоне от 10 до 6000 рублей.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } catch (e: NumberFormatException) {
                            try {
                                val number = numberAsString.toDouble()
                                if (number < 10.0) {

                                    Toast.makeText(
                                        context,
                                        "Неверная сумма. Сумма должна быть в диапазоне от 10 до 6000 рублей.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    requireActivity().supportFragmentManager.beginTransaction()
                                        .replace(
                                            R.id.nav_host_fragment_activity_generate_qr,
                                            statusFragment
                                        ).commit()
                                   // CommandUtil(requireContext(), mCoroutineScope).sendCommand(deviceAddress, Constants.btClean)
                                }
                            } catch (ex: NumberFormatException) {

                                ex.printStackTrace()
                            }
                        }
                    }
                } else {
                    Toast.makeText(context, "The amount is empty", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return fragmentGenerateqrBinding.root
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.pin1Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "1"
            )
            R.id.pin2Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "2"
            )
            R.id.pin3Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "3"
            )
            R.id.pin4Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "4"
            )
            R.id.pin5Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "5"
            )
            R.id.pin6Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "6"
            )
            R.id.pin7Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "7"
            )
            R.id.pin8Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "8"
            )
            R.id.pin9Btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "9"
            )
            R.id.pin0_btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "0"
            )

            R.id.pin_comma_btn -> fragmentGenerateqrBinding.amountEdittxt.setText(
                fragmentGenerateqrBinding.amountEdittxt.text.toString() + "."
            )
        }
    }
}