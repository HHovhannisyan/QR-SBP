package ru.mertech.sbpskb.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_payment_status.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.mertech.sbpskb.DataStoreManager
import ru.mertech.sbpskb.databinding.FragmentHistoryBinding
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity
import ru.mertech.sbpskb.ui.adapters.PaymentStatusAdapter
import ru.mertech.sbpskb.ui.viewModels.ShareViewModel
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding

    private val viewModel: ShareViewModel by viewModels()
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var paymentStatusAdapter: PaymentStatusAdapter
    private lateinit var dataStoreManager: DataStoreManager
    private lateinit var startDate:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        dataStoreManager = DataStoreManager(requireActivity())

        mLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        paymentStatusAdapter = PaymentStatusAdapter(viewModel, requireContext())

        binding.rvTodo.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        binding.rvTodo.adapter = paymentStatusAdapter

        binding.chipMonth.setOnClickListener {
            val cal: Calendar = Calendar.getInstance(TimeZone.getDefault())
            val firstDayOfMonth = cal.getActualMinimum(Calendar.DAY_OF_MONTH)
            val endDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)

            viewModel.getAllPayments()
                .observe(viewLifecycleOwner) { list ->
                    val monthList: ArrayList<PaymentStatusEntity> = ArrayList()
                    for (paymentStatusEntity: PaymentStatusEntity in list) {
                        val createdDay = paymentStatusEntity.date.substring(0, 2)
                        if (createdDay.toInt() in firstDayOfMonth..endDayOfMonth) {
                            monthList.add(paymentStatusEntity)
                        }
                    }
                    paymentStatusAdapter.setData(monthList)
                }
        }

        binding.chipWeek.setOnClickListener {
            viewModel.getAllPayments().observe(viewLifecycleOwner) { list ->
                val firstDayOfWeek = getFirstDayOfWeek()
                val lastDayOfWeek = getLastDayOfWeek()
                val weekList = ArrayList<PaymentStatusEntity>()
                for (paymentStatusEntity: PaymentStatusEntity in list) {
                    val createdDay = paymentStatusEntity.date.substring(0, 2)
                    if (createdDay in firstDayOfWeek..lastDayOfWeek) {
                        weekList.add(paymentStatusEntity)
                    }
                }
                paymentStatusAdapter.setData(weekList)
            }
        }

        binding.chipDateRange.setOnClickListener {
            /* val upTo = calendar.timeInMillis
             calendar.set(2022, 3, 1)
             val startFrom = calendar.timeInMillis
             val constraints = CalendarConstraints.Builder()
                 .setStart(startFrom)
                 .setEnd(upTo)
                 .build()
             val datePicker =
                 MaterialDatePicker.Builder.dateRangePicker().setTitleText("Указать диапазон")
                     .setTheme(R.style.ThemeOverlay_App_DatePicker).setCalendarConstraints(
                         constraints).build()

             datePicker.show(requireActivity().supportFragmentManager, "DatePicker")

             datePicker.addOnPositiveButtonClickListener {
                 calendar.timeInMillis = it.first
                 val firstDay: Int = calendar.get(Calendar.DAY_OF_MONTH)
                 val firstMonth: Int = calendar.get(Calendar.MONTH) + 1
                 val firstYear: Int = calendar.get(Calendar.YEAR)

                 calendar.timeInMillis = it.second
                 val endDay: Int = calendar.get(Calendar.DAY_OF_MONTH)
                 val endMonth: Int = calendar.get(Calendar.MONTH) + 1
                 val endYear: Int = calendar.get(Calendar.YEAR)

                 viewModel.getAllPayments().observe(viewLifecycleOwner) { list ->
                     val rangeDateList = ArrayList<PaymentStatusEntity>()
                     for (paymentStatusEntity: PaymentStatusEntity in list) {
                         val sdfIn = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault())
                         val sdfOut = SimpleDateFormat("dd MM yyyy", Locale.getDefault())
                         val date = sdfIn.parse(paymentStatusEntity.date)!!

                         val createdDay = sdfOut.format(date).substring(0, 2)
                         val createdMonth = sdfOut.format(date).substring(3, 5)
                         val createdYear = sdfOut.format(date).substring(6, 10)

                         if ((createdDay.toInt() in firstDay..endDay  || createdDay.toInt() in endDay..firstDay) && createdMonth.toInt() in firstMonth..endMonth && createdYear.toInt() in firstYear..endYear) {
                             rangeDateList.add(paymentStatusEntity)
                         }
                     }
                     paymentStatusAdapter.setData(rangeDateList)
                 }
             }
             datePicker.addOnNegativeButtonClickListener {}
             datePicker.addOnCancelListener {}*/

            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager
            supportFragmentManager.setFragmentResultListener(
                "REQUEST_KEY",
                viewLifecycleOwner
            ) { resultKey1, bundle1 ->
                if (resultKey1 == "REQUEST_KEY") {
                    Log.d(
                        "History",
                        "date: " + bundle1.getInt("startDay") + ", " + bundle1.getInt("startMonth") + ", " + bundle1.getInt(
                            "startYear"
                        )
                    )
                    val startDay = bundle1.getInt("startDay")
                    val startMonth = bundle1.getInt("startMonth")
                    val startYear = bundle1.getInt("startYear")

                    if (startDay.toString().isNotEmpty() && startMonth.toString()
                            .isNotEmpty() && startYear.toString()
                            .isNotEmpty()
                    ) {
                        showEndDateDialog(startDay, startMonth, startYear)
                    }
                }
            }
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment1")
        }

        viewModel.getAllPayments().observe(viewLifecycleOwner) { list ->
            paymentStatusAdapter.setData(list)
        }
        return binding.root
    }


    private fun getFirstDayOfWeek(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, Calendar.SUNDAY - calendar[Calendar.DAY_OF_WEEK])
        val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return formatter.format(calendar.time)
    }

    private fun getLastDayOfWeek(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, Calendar.SATURDAY - calendar[Calendar.DAY_OF_WEEK])
        val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return formatter.format(calendar.time)
    }


    private fun showEndDateDialog(
        startDay: Int,
        startMonth: Int,
        startYear: Int,
    ) {
        val datePickerFragment2 = DatePickerFragment2()
        val supportFragmentManager = requireActivity().supportFragmentManager
        supportFragmentManager.setFragmentResultListener(
            "REQUEST_KEY",
            viewLifecycleOwner
        ) { resultKey2, bundle2 ->
            if (resultKey2 == "REQUEST_KEY") {
                val endDate = bundle2.getString("END_DATE")
                val endDay = bundle2.getInt("endDay")
                val endMonth = bundle2.getInt("endMonth")
                val endYear = bundle2.getInt("endYear")


                if (endDay.toString().isNotEmpty() && endMonth.toString()
                        .isNotEmpty() && endYear.toString()
                        .isNotEmpty()
                ) {
                    dataStoreManager.date.asLiveData().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                        if (it != null) {
                            startDate=it
                        }
                    })

                    Toast.makeText(
                        requireContext(),
                        "Your selected Dates: \n$startDate-$endDate",
                        Toast.LENGTH_LONG
                    ).show()
                    searchPayments(startDay, endDay, startMonth, endMonth, startYear, endYear)
                }
            }
        }
        datePickerFragment2.show(supportFragmentManager, "DatePickerFragment2")
    }

    private fun searchPayments(
        startDay: Int,
        endDay: Int,
        startMonth: Int,
        endMonth: Int,
        startYear: Int,
        endYear: Int
    ) {
        viewModel.getAllPayments().observe(viewLifecycleOwner) { list ->
            val rangeDateList = ArrayList<PaymentStatusEntity>()
            for (paymentStatusEntity: PaymentStatusEntity in list) {
                val sdfIn = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault())
                val sdfOut = SimpleDateFormat("dd MM yyyy", Locale.getDefault())
                val date = sdfIn.parse(paymentStatusEntity.date)!!
                val createdDay = sdfOut.format(date).substring(0, 2)
                val createdMonth = sdfOut.format(date).substring(3, 5)
                val createdYear = sdfOut.format(date).substring(6, 10)
                if ((createdDay.toInt() in startDay..endDay || createdDay.toInt() in endDay..startDay) && createdMonth.toInt() in startMonth..endMonth && createdYear.toInt() in startYear..endYear) {
                    rangeDateList.add(paymentStatusEntity)
                }
            }
            paymentStatusAdapter.setData(rangeDateList)
        }
    }
}