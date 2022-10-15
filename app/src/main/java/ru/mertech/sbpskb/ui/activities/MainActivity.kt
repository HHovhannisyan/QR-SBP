package ru.mertech.sbpskb.ui.activities

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import ru.mertech.sbpskb.Constants
import ru.mertech.sbpskb.Constants.LOCATION_PERMISSION_REQUEST_CODE
import ru.mertech.sbpskb.Constants.isGPS
import ru.mertech.sbpskb.databinding.ActivityMainBinding
import ru.mertech.sbpskb.utils.GPSUtil


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(activityMainBinding.root)

        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter = bluetoothManager.adapter

        if (!bluetoothAdapter.isEnabled) {
            val blueToothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.BLUETOOTH_CONNECT),
                       Constants.BLUETOOTH_REQ_CODE
                    )
                }
            }
            startActivityForResult(blueToothIntent, Constants.BLUETOOTH_REQ_CODE)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !isLocationPermissionGranted) {
            requestLocationPermission()
        }
        activityMainBinding.start.setOnClickListener {
            val intent = Intent(this@MainActivity, GenerateQRActivity::class.java)
            startActivity(intent)
        }
    }

    private val isLocationPermissionGranted
        get() = hasPermission()

    private fun hasPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }


    private fun requestLocationPermission() {
        if (isLocationPermissionGranted) {
            return
        }
        requestPermission()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show()
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(
                this, "Bluetooth operation is cancelled",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.firstOrNull() == PackageManager.PERMISSION_DENIED) {
                    requestLocationPermission()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        GPSUtil(this).turnGPSOn(object : GPSUtil.onGPSListener {
            override fun gpsStatus(isGPSEnable: Boolean) {
                // turn on GPS
                isGPS = isGPSEnable
            }
        })
    }

}