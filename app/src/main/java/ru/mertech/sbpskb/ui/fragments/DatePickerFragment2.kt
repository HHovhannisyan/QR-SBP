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
import ru.mertech.sbpskb.DataStoreManager
import ru.mertech.sbpskb.R
import java.text.SimpleDateFormat
import java.util.*

class DatePickerFragment2 : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private val calendar = Calendar.getInstance()
    private lateinit var dataStoreManager: DataStoreManager


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dataStoreManager = DataStoreManager(requireActivity())

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val sh: SharedPreferences =
            requireActivity().getSharedPreferences(
                "SharedPrefStartDate",
                Context.MODE_PRIVATE
            )

        val startDay = sh.getInt("startDay", 0)
        val startMonth = sh.getInt("startMonth", 0)
        val startYear = sh.getInt("startYear", 0)


        val dpd = DatePickerDialog(
            requireActivity(), R.style.DialogTheme, this, year, month, day
        )

        if (startMonth <= month) {
            calendar.set(startYear, startMonth - 1, startDay)
        }
        dpd.datePicker.minDate = calendar.timeInMillis

        dpd.datePicker.maxDate = Date().time
        val myMsg = TextView(requireActivity())
        myMsg.apply {
            text = "Select the end date"
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
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        val endDay = calendar.get(Calendar.DAY_OF_MONTH)
        val endMonth = calendar.get(Calendar.MONTH) + 1
        val endYear = calendar.get(Calendar.YEAR)
        val endDate = SimpleDateFormat("d/M/yyyy", Locale.getDefault()).format(calendar.time)

        val selectedDateBundle = Bundle()
        selectedDateBundle.putString("END_DATE", endDate)

        selectedDateBundle.putInt("endDay", endDay)
        selectedDateBundle.putInt("endMonth", endMonth)
        selectedDateBundle.putInt("endYear", endYear)

        setFragmentResult("REQUEST_KEY", selectedDateBundle)
    }
}