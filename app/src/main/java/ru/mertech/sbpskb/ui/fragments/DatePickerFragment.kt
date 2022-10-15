package ru.mertech.sbpskb.ui.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.mertech.sbpskb.DataStoreManager
import ru.mertech.sbpskb.R
import java.text.SimpleDateFormat
import java.util.*


class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private val calendar = Calendar.getInstance()
    private lateinit var dataStoreManager: DataStoreManager
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dataStoreManager = DataStoreManager(requireActivity())

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            requireActivity(), R.style.DialogTheme, this, year, month, day
        )
        dpd.datePicker.maxDate = Date().time

        calendar.set(2021, 5, 3)
        dpd.datePicker.minDate = calendar.timeInMillis
        val myMsg = TextView(requireActivity())
        myMsg.apply {
            text = "Select the first date"
            gravity = Gravity.CENTER_HORIZONTAL
            textSize = 24f
            setTextColor(Color.RED)
            setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.cream))
        }
        dpd.setCustomTitle(myMsg)

        val datePickerHeader = dpd.datePicker.getChildAt(0).resources.getIdentifier(
            "date_picker_header",
            "id",
            "android"
        )
        (dpd.datePicker as ViewGroup).findViewById<View>(datePickerHeader).visibility =
            View.GONE

        return dpd
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }
        val startDay = calendar.get(Calendar.DAY_OF_MONTH)
        val startMonth = calendar.get(Calendar.MONTH) + 1
        val startYear = calendar.get(Calendar.YEAR)
        val startDate = SimpleDateFormat("d/M/yyyy", Locale.getDefault()).format(calendar.time)

        val selectedDateBundle = Bundle()
        selectedDateBundle.apply {
            putInt("startDay", startDay)
            putInt("startMonth", startMonth)
            putInt("startYear", startYear)
        }
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("SharedPrefStartDate", Context.MODE_PRIVATE)

        sharedPreferences.edit().putInt("startDay", startDay).apply()
        sharedPreferences.edit().putInt("startMonth", startMonth).apply()
        sharedPreferences.edit().putInt("startYear", startYear).apply()

        lifecycleScope.launch {
            dataStoreManager.setDate(startDate)
        }

        setFragmentResult("REQUEST_KEY", selectedDateBundle)
    }
}