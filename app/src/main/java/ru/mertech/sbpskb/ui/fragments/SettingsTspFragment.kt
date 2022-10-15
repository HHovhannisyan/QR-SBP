package ru.mertech.sbpskb.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.mertech.sbpskb.DataStoreManager
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.databinding.SettingsTspFragmentBinding
import ru.mertech.sbpskb.ui.viewModels.SettingsTspViewModel

class SettingsTspFragment : Fragment(), AdapterView.OnItemClickListener {
    private val mViewModel: SettingsTspViewModel? = null
    private lateinit var binding: SettingsTspFragmentBinding
    private lateinit var prefs: SharedPreferences
    private lateinit var dataStoreManager: DataStoreManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingsTspFragmentBinding.inflate(inflater, container, false)
        val textView = requireActivity().findViewById<TextView>(R.id.title)
        textView.text = "Настройки ТСП"
        binding.autoCompleteTextView.onItemClickListener = this
        val banks = resources.getStringArray(R.array.banks)

        // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(),  R.layout.drop_down_item, R.id.dropdown_txt,  banks);
        //binding.spinner.setAdapter(arrayAdapter);
        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.drop_down_item, R.id.dropdown_txt, banks)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        dataStoreManager = DataStoreManager(requireActivity())

        prefs = requireActivity().getSharedPreferences("SpinnerSharedPref", Context.MODE_PRIVATE)
        val selectedItem = prefs.getInt("last_val", 0)

        /* lifecycleScope.launch {
             dataStoreManager.selectedItem.collect { item ->
                 binding.autoCompleteTextView.setText(banks[item], false)
             }
         }*/

        binding.autoCompleteTextView.setText(banks[selectedItem], false)


        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_generate_qr, SettingsFragment())
                        .commit()
                }
            })
        return binding.root
    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        prefs = requireActivity().getSharedPreferences("SpinnerSharedPref", Context.MODE_PRIVATE)
        prefs.edit().putInt("last_val", i).apply()
      /*  lifecycleScope.launch {
            dataStoreManager.setBank(i)
        }*/

    }


    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayUseLogoEnabled(false)
        }
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(false)
            it.setDisplayUseLogoEnabled(true)
        }
    }
}