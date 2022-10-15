package ru.mertech.sbpskb.ui.activities

import android.content.IntentFilter
import android.content.res.ColorStateList
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint
import ru.mertech.sbpskb.utils.GPSUtil
import ru.mertech.sbpskb.InternetConnectionReceiver
import ru.mertech.sbpskb.InternetConnectionReceiver.ReceiverListener
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.databinding.ActivityGenerateQrBinding
import ru.mertech.sbpskb.ui.fragments.GenerateQRFragment
import ru.mertech.sbpskb.ui.fragments.HistoryFragment
import ru.mertech.sbpskb.ui.fragments.SettingsFragment


@AndroidEntryPoint
class GenerateQRActivity : AppCompatActivity(), ReceiverListener {
    private lateinit var activityGenerateQrBinding: ActivityGenerateQrBinding
    private var isGPS = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityGenerateQrBinding = ActivityGenerateQrBinding.inflate(
            layoutInflater
        )
        setContentView(activityGenerateQrBinding.root)
        setSupportActionBar(activityGenerateQrBinding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.logo)
        supportActionBar!!.setDisplayUseLogoEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        checkConnection()
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_generate_qr) as NavHostFragment

        val navController = navHostFragment.navController
        //  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_generate_qr);
        setupWithNavController(activityGenerateQrBinding.navView, navController)
        activityGenerateQrBinding.navView.selectedItemId = R.id.navigation_qr
        activityGenerateQrBinding.getQRBtn.imageTintList = ColorStateList.valueOf(
            ContextCompat.getColor(
                applicationContext, R.color.red
            )
        )
        activityGenerateQrBinding.navView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_history -> {
                    activityGenerateQrBinding.getQRBtn.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            applicationContext, R.color.grey
                        )
                    )

                     supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_generate_qr, HistoryFragment())
                        .commit()
                    activityGenerateQrBinding.title.text = "История транзакций"
                    return@OnItemSelectedListener true
                }
                R.id.navigation_qr -> {
                    activityGenerateQrBinding.getQRBtn.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            applicationContext, R.color.red
                        )
                    )
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_generate_qr, GenerateQRFragment())
                        .commit()
                    activityGenerateQrBinding.title.setText(R.string.kuayring)
                    return@OnItemSelectedListener true
                }
                R.id.navigation_settings -> {
                    activityGenerateQrBinding.getQRBtn.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            applicationContext, R.color.grey
                        )
                    )
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_generate_qr, SettingsFragment())
                        .commit()
                    activityGenerateQrBinding.title.text = "Настройки"
                    return@OnItemSelectedListener true
                }
            }
            false
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun checkConnection() {
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.new.conn.CONNECTIVITY_CHANGE")
        registerReceiver(InternetConnectionReceiver(), intentFilter)
        InternetConnectionReceiver.Listener = this
        val manager =
            applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = manager.activeNetworkInfo
        val isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting
        showToast(isConnected)
    }

    private fun showToast(isConnected: Boolean) {
        val message: String
        if (!isConnected) {
            message = "Not Connected to Internet"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNetworkChange(isConnected: Boolean) {
        showToast(isConnected)
    }

    override fun onResume() {
        super.onResume()
        checkConnection()
        GPSUtil(this).turnGPSOn(object : GPSUtil.onGPSListener {
            override fun gpsStatus(isGPSEnable: Boolean) {
                // turn on GPS
                isGPS = isGPSEnable
            }
        })
    }


    override fun onPause() {
        super.onPause()
        checkConnection()
    }
}