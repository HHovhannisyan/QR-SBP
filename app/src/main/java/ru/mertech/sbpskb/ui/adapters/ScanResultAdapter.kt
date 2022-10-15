package ru.mertech.sbpskb.ui.adapters

import android.Manifest
import android.app.Activity
import android.bluetooth.le.ScanResult
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_scan_result.view.*
import ru.mertech.sbpskb.Constants
import ru.mertech.sbpskb.R


class ScanResultAdapter(
    private val context: Context,
    private val items: List<ScanResult>,
    private val onClickListener: ((device: ScanResult) -> Unit)
) : RecyclerView.Adapter<ScanResultAdapter.ViewHolder>() {
    private lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.row_scan_result,
            parent,
            false
        )
        return ViewHolder(context, view, onClickListener, onItemClickListener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ViewHolder(
        private val context: Context,
        private val view: View,
        private val onClickListener: ((device: ScanResult) -> Unit),
        private val onItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(view) {

        fun bind(result: ScanResult) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.BLUETOOTH_CONNECT),
                        Constants.BLUETOOTH_REQ_CODE
                    )
                }
            }
            view.device_name.text = result.device.name ?: "Unnamed"
            view.mac_address.text = result.device.address


            /* view.setOnClickListener {
                 onClickListener.invoke(result)
             }*/
            view.setOnClickListener {

                // Toast.makeText(it.context, "Selected device: ${result.device.name}", Toast.LENGTH_SHORT).show()
                onItemClickListener.onItemClicked(adapterPosition)
                onClickListener.invoke(result)

                val sharedPreferences: SharedPreferences =
                    context.getSharedPreferences("SharedPrefAddress", MODE_PRIVATE)

                sharedPreferences.edit().putString("deviceAddress", result.device.toString())
                    .apply()
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int)
    }
}
