package ru.mertech.sbpskb.utils

import android.app.Activity
import android.content.Context
import android.content.IntentSender
import android.location.LocationManager
import android.util.Log
import android.widget.Toast
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import ru.mertech.sbpskb.Constants


class GPSUtil (private val context: Context) {
    private val mSettingsClient: SettingsClient = LocationServices.getSettingsClient(context)
    private val mLocationSettingsRequest: LocationSettingsRequest
    private val locationManager: LocationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    // method for turn on GPS
    fun turnGPSOn(onGpsListener: onGPSListener?) {
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            onGpsListener?.gpsStatus(true)
        } else {
            mSettingsClient
                .checkLocationSettings(mLocationSettingsRequest)
                .addOnSuccessListener((context as Activity)) { //  GPS is already enable, callback GPS status through listener
                    onGpsListener?.gpsStatus(true)
                }
                .addOnFailureListener(context) { e ->
                    when ((e as ApiException).statusCode) {
                        LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> try {
                            // Show the dialog by calling startResolutionForResult(), and check the
                            // result in onActivityResult().
                            val rae = e as ResolvableApiException
                            rae.startResolutionForResult(context,
                                Constants.GPS_REQUEST
                            )

                         /*   val builder: AlertDialog.Builder =AlertDialog.Builder(context)
                            builder.setTitle("Login Alert")
                                .setMessage("Are you sure, you want to continue ?")
                                .setCancelable(false)
                                .setPositiveButton("Yes",
                                    DialogInterface.OnClickListener { dialog, which ->
                                        Toast.makeText(
                                            context,
                                            "Selected Option: YES",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        val rae = e as ResolvableApiException
                                        rae.startResolutionForResult(context,
                                            Constants.GPS_REQUEST
                                        )
                                    })
                                .setNegativeButton("No",
                                    DialogInterface.OnClickListener { dialog, which ->
                                        Toast.makeText(
                                            context,
                                            "Selected Option: No",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    })
                            val dialog: AlertDialog = builder.create()
                            dialog.show()*/

                        } catch (sie: IntentSender.SendIntentException) {
                            Log.d("TAG", "PendingIntent unable to execute request.")
                        }
                        LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                            val errorMessage = "Location settings are inadequate, and cannot be " +
                                    "fixed here. Fix in Settings."
                            Log.d("TAG", errorMessage)
                            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }
                }
        }
    }

    interface onGPSListener {
        fun gpsStatus(isGPSEnable: Boolean)
    }

    init {
        val locationRequest = com.google.android.gms.location.LocationRequest.create()
        locationRequest.priority =
            com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 10 * 1000
        locationRequest.fastestInterval = 2 * 1000
        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
        mLocationSettingsRequest = builder.build()
        builder.setAlwaysShow(true) //this is the key ingredient
    }
}