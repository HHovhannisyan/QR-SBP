package ru.mertech.sbpskb.ui.fragments

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothDevice.TRANSPORT_LE
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.content.Context.BLUETOOTH_SERVICE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.mertech.sbpskb.Constants.BLUETOOTH_REQ_CODE

import ru.mertech.sbpskb.Constants.isGPS
import ru.mertech.sbpskb.utils.GPSUtil
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.bluetooth.BTConnectionEventListener
import ru.mertech.sbpskb.bluetooth.ConnectionManager
import ru.mertech.sbpskb.bluetooth.QrDisplayManager
import ru.mertech.sbpskb.databinding.SettingDisplayFragmentBinding
import ru.mertech.sbpskb.ui.adapters.ScanResultAdapter
import ru.mertech.sbpskb.ui.viewModels.SettingDisplayViewModel


@AndroidEntryPoint
class SettingDisplayFragment : Fragment() {
    private val mViewModel: SettingDisplayViewModel? = null
    private val TAG = "SettingDisplayFragment"


    private lateinit var binding: SettingDisplayFragmentBinding
    private lateinit var mCoroutineScope: CoroutineScope
    private lateinit var qrDisplayManager: QrDisplayManager

    private val bluetoothAdapter: BluetoothAdapter by lazy {
        val bluetoothManager =
            requireActivity().getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothManager.adapter
    }

    private val bleScanner by lazy {
        bluetoothAdapter.bluetoothLeScanner
    }

    private val scanSettings = ScanSettings.Builder()
        .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
        .build()

    private var isScanning = false

    private val scanResults = mutableListOf<ScanResult>()
    private val scanResultAdapter: ScanResultAdapter by lazy {
        ScanResultAdapter(requireContext(), scanResults) { result ->
            if (isScanning) {
                stopBleScan()
            }
            with(result.device) {
                Log.d("TAG", "Connecting to $address")

                ConnectionManager.connect(this, requireContext())
            }
        }
    }

    private lateinit var sh: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingDisplayFragmentBinding.inflate(inflater, container, false)
        val textView = requireActivity().findViewById<TextView>(R.id.title)
        textView.text = "Подключение дисплея"


        mCoroutineScope = CoroutineScope(Dispatchers.Main)
        val manager = QrDisplayManager(requireContext(), mCoroutineScope)
        this.qrDisplayManager = manager

        startBleScan()
        setupRecyclerView()
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        if (navBar.visibility == View.INVISIBLE) {
            navBar.visibility = View.VISIBLE
        }


        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_generate_qr, SettingsFragment())
                        .commit()
                }
            })
        //ConnectionManager.registerListener(connectionEventListener)
        sh =
            requireActivity().getSharedPreferences(
                "SharedPrefAddress",
                Context.MODE_PRIVATE
            )
        val deviceAddress = sh.getString("deviceAddress", "")

        if (!deviceAddress.isNullOrEmpty()) {
            val device: BluetoothDevice =
                bluetoothAdapter.getRemoteDevice(deviceAddress)
            val state = getState(deviceAddress)

            if (state == BluetoothProfile.STATE_CONNECTED) {
                binding.connectedDevice.visibility = View.VISIBLE
                binding.connectedDeviceName.text = device.name + "\t(Connected)"
            }

            if (state == BluetoothProfile.STATE_DISCONNECTED) {
                binding.connectedDevice.visibility = View.GONE
                disconnect(device)

                //  binding.connectedDeviceName.text = device.name + "\t(Connected)"
            }

            binding.disconnectDevice.setOnClickListener(View.OnClickListener {
                // qrDisplayManager.disconnect().enqueue()
                disconnect(device)
                if (binding.connectedDevice.visibility == View.VISIBLE) {
                    binding.connectedDevice.visibility = View.GONE
                }
                /* val   bluetoothGatt  = device.connectGatt(
                        context,
                        false, scanCallback)
                    bluetoothGatt.close()
                    bluetoothGatt.disconnect()*/

                sh.edit().clear().apply()

            })
        }

        return binding.root
    }


    override fun onResume() {
        super.onResume()
        ConnectionManager.registerListener(connectionEventListener)
        if (!bluetoothAdapter.isEnabled) {
            promptEnableBluetooth()
            startBleScan()
        }
        GPSUtil(requireActivity()).turnGPSOn(object : GPSUtil.onGPSListener {
            override fun gpsStatus(isGPSEnable: Boolean) {
                // turn on GPS
                isGPS = isGPSEnable
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            BLUETOOTH_REQ_CODE -> {
                if (resultCode != Activity.RESULT_OK) {
                    promptEnableBluetooth()
                }
            }
        }
    }

    private fun promptEnableBluetooth() {
        if (!bluetoothAdapter.isEnabled) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, BLUETOOTH_REQ_CODE)
        }
    }


    private fun startBleScan() {
        scanResults.clear()
        bleScanner.startScan(null, scanSettings, scanCallback)
        isScanning = true
    }


    private fun stopBleScan() {
        bleScanner.stopScan(scanCallback)
        isScanning = false
    }

    private fun setupRecyclerView() {
        binding.scanResultsRecyclerView.apply {
            adapter = scanResultAdapter
            layoutManager = LinearLayoutManager(
                requireActivity(),
                RecyclerView.VERTICAL,
                false
            )
            scanResultAdapter.setOnItemClickListener(object :
                ScanResultAdapter.OnItemClickListener {
                override fun onItemClicked(position: Int) {
                }
            })
            isNestedScrollingEnabled = false
        }
    }


    private val scanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            val indexQuery = scanResults.indexOfFirst { it.device.address == result.device.address }
            if (indexQuery != -1) { // A scan result already exists with the same address
                scanResults[indexQuery] = result
                scanResultAdapter.notifyItemChanged(indexQuery)
            } else {
                with(result.device) {
                    Log.d(
                        "TAG",
                        "Found BLE device! Name: ${name ?: "Unnamed"}, address: $address"
                    )
                }

                // if (result.device.name != null && result.device.name.startsWith("N5AL")) {
                scanResults.add(result)
                scanResultAdapter.notifyItemInserted(scanResults.size - 1)
                // }

            }
        }

        override fun onScanFailed(errorCode: Int) {
            Log.d("TAG", "onScanFailed: code $errorCode")
        }
    }

    private val connectionEventListener by lazy {
        BTConnectionEventListener().apply {
            onConnectionSetupComplete = { gatt ->
                val state = getState(gatt.device.address)
                requireActivity().runOnUiThread {
                    if (state == BluetoothProfile.STATE_CONNECTED && gatt.device.name.startsWith(
                            "N5AL"
                        )
                    ) {
                        if (binding.connectedDevice.visibility == View.GONE || binding.connectedDevice.visibility == View.INVISIBLE) {
                            binding.connectedDevice.visibility = View.VISIBLE
                        }
                        binding.connectedDeviceName.text = gatt.device.name + "\t(Connected)"

                        Toast.makeText(
                            context,
                            "Selected device: ${gatt.device}",
                            Toast.LENGTH_SHORT
                        ).show()
                        ConnectionManager.unregisterListener(this)
                    }
                }
            }
        }
    }

    private fun disconnect(bluetoothDevice: BluetoothDevice) {
        ConnectionManager.unregisterListener(connectionEventListener)
        ConnectionManager.teardownConnection(bluetoothDevice)
    }

    private fun getState(deviceAddress: String): Int {
        val bluetoothManager =
            requireActivity().getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        val device: BluetoothDevice =
            bluetoothAdapter.getRemoteDevice(deviceAddress)
        return bluetoothManager.getConnectionState(device, BluetoothProfile.GATT)
    }
}