package ru.mertech.sbpskb.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.databinding.FragmentOtherSettingsBinding
import ru.mertech.sbpskb.ui.adapters.SecurityListAdapter
import ru.mertech.sbpskb.ui.viewModels.OtherSettingsViewModel

class OtherSettingsFragment : Fragment() {

    companion object {
        fun newInstance() = OtherSettingsFragment()
    }

    private  val viewModel: OtherSettingsViewModel  by viewModels()
    private lateinit var binding: FragmentOtherSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentOtherSettingsBinding.inflate(inflater, container, false)
        val textView = requireActivity().findViewById<TextView>(R.id.title)
        textView.text = "Прочие настройки"

        val settingNames = arrayOf(
            "Использовать Touch-ID для входа в приложение",
            "Использовать Face-ID для входа в приложение",
            "Назначить код-пароль для входа в приложение",
        )
        val settingIcons = intArrayOf(
            R.drawable.ic_setting_display, R.drawable.ic_setting_display, R.drawable.ic_setting_display, R.drawable.ic_setting_display
        )


        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_generate_qr, SettingsFragment())
                        .commit()
                }
            })

        viewModel.mText.observe(viewLifecycleOwner, Observer {
           binding.txtSecurity.text=it

        })

        val myAdapter = SecurityListAdapter(context, settingNames)
        binding.lvSecurity.adapter = myAdapter

        return binding.root
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