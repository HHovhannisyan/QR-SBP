package ru.mertech.sbpskb.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.api.SbpApi
import ru.mertech.sbpskb.databinding.ItemPaymentStatusBinding
import ru.mertech.sbpskb.db.entity.PaymentStatusEntity
import ru.mertech.sbpskb.pojo.sbp.GetQRTinkoffReq
import ru.mertech.sbpskb.ui.viewModels.ShareViewModel
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class PaymentStatusAdapter(
    private val shareViewModel: ShareViewModel,
    private val context: Context
) :
    RecyclerView.Adapter<PaymentStatusAdapter.MyViewHolder>() {

    private var dataList = emptyList<PaymentStatusEntity>()

    class MyViewHolder(private val binding: ItemPaymentStatusBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            paymentStatusEntity: PaymentStatusEntity,
            shareViewModel: ShareViewModel,
            context: Context
        ) {
            binding.reload.setOnClickListener(View.OnClickListener {
                Toast.makeText(context, "Reloads", Toast.LENGTH_SHORT).show()
                if (binding.reload.rotation==0f) {
                    binding.reload.animate().rotation(360f).setDuration(1000).start()
                }else{
                    binding.reload.rotation=0f
                    binding.reload.animate().rotation(360f).setDuration(1000).start()
                }

                if (paymentStatusEntity.bankName == "Tinkoff") {

                    shareViewModel.updatePaymentTinkoffDB(
                        paymentStatusEntity.paymentID,
                        paymentStatusEntity.encoded,
                        context,
                        adapterPosition
                    )
                }

                if (paymentStatusEntity.bankName == "Raiff") {
                    shareViewModel.updatePaymentRaiffDB(
                        paymentStatusEntity.qrId,
                        context,
                        adapterPosition
                    )
                }
            })
            binding.payment = paymentStatusEntity
            binding.viewModel = shareViewModel
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: ItemPaymentStatusBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_payment_status,
            parent,
            false
        )
        /* view.reload.setOnClickListener(View.OnClickListener {
             Toast.makeText(parent.context, "Reloads", Toast.LENGTH_SHORT).show()
         })*/
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem, shareViewModel, context)
    }

    fun setData(paymentData: List<PaymentStatusEntity>) {
        val paymentDiffUtil = PaymentDiffUtil(dataList, paymentData)
        val paymentDiffResult = DiffUtil.calculateDiff(paymentDiffUtil)
        this.dataList = paymentData
        paymentDiffResult.dispatchUpdatesTo(this)
    }

}