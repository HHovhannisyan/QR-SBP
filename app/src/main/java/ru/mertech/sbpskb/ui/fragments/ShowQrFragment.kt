package ru.mertech.sbpskb.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.*
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okio.ByteString.Companion.toByteString
import ru.mertech.sbpskb.Constants
import ru.mertech.sbpskb.Constants.btClean
import ru.mertech.sbpskb.Constants.btSuccess
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.databinding.ShowQrFragmentBinding
import ru.mertech.sbpskb.ui.viewModels.ShowQrViewModel
import ru.mertech.sbpskb.utils.CommandUtil
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.util.*
import java.util.concurrent.Executors


@AndroidEntryPoint
class ShowQrFragment : Fragment() {
    private val mViewModel: ShowQrViewModel? = null
    lateinit var binding: ShowQrFragmentBinding
    lateinit var result: BitMatrix
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var mCoroutineScope: CoroutineScope

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShowQrFragmentBinding.inflate(inflater, container, false)
        switchToWait()
        val bundle = this.arguments
        val qrUrl = bundle?.getString("QRUrl")
        mCoroutineScope = CoroutineScope(Dispatchers.Main)

        val sh = requireActivity().getSharedPreferences("SpinnerSharedPref", Context.MODE_PRIVATE)
        val spinnerPosition = sh.getInt("last_val", 0)


        if (qrUrl != null && qrUrl.isNotEmpty()) {
            countDownTimer = object : CountDownTimer(2000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val sec = millisUntilFinished / 1000 % 60
                    binding.waitForQrTxt.text = getString(R.string.wait_for_qr, sec)
                }

                override fun onFinish() {
                    showQrCode()
                    if (spinnerPosition == 0) {
                        generateQRcode(qrUrl)
                        sendString(qrUrl)
                    }
                    if (spinnerPosition == 1) {
                        downloadImage(qrUrl)
                        sendString("hello")
                    }
                }
            }.start()
        }

        binding.checkPaymentBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_generate_qr, PaymentInfoFragment())
                .commit()
        }

        return binding.root
    }


    private fun switchToWait() {
        binding.qrIvPayment.visibility = View.INVISIBLE
    }


    private fun generateQRcode(qrUrl: String?) {
        try {
            result = MultiFormatWriter().encode(qrUrl, BarcodeFormat.QR_CODE, 800, 800, null)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
        val qrWithLogo = Bitmap.createBitmap(result.width, result.height, Bitmap.Config.RGB_565)
        for (x in 0 until result.width) {
            for (y in 0 until result.height) {
                qrWithLogo.setPixel(x, y, if (result[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        val canvas = Canvas(qrWithLogo)
        canvas.drawBitmap(qrWithLogo, Matrix(), null)
        canvas.drawBitmap(
            qrWithLogo,
            (canvas.width - qrWithLogo.width) / 2f,
            (canvas.height - qrWithLogo.height) / 2f,
            null
        )
        binding.qrIvPayment.setImageBitmap(qrWithLogo)
    }


    fun showQrCode() {
        binding.qrIvPayment.visibility = View.VISIBLE
        binding.checkPaymentBtn.visibility = View.VISIBLE
        binding.scanForPayment.visibility = View.VISIBLE
        binding.waitForQrTxt.visibility = View.INVISIBLE
        binding.getQRFast.visibility = View.INVISIBLE
    }


    fun downloadImage(mWebPath: String) {
        // Declaring and initializing an Executor and a Handler
        val executor = Executors.newSingleThreadExecutor()
        val myHandler = Handler(Looper.getMainLooper())
        executor.execute {
            val mImage = mLoad(mWebPath)
            myHandler.post { binding.qrIvPayment.setImageBitmap(mImage) }

            Log.d("TAG", "mImage.toByteArray(): $mImage")

            //sendQrCodeImg(mImage)
            //  sendString(mWebPath)
        }
    }

    // Function to establish connection and load image
    private fun mLoad(string: String?): Bitmap? {
        val url = mStringToURL(string)
        val connection: HttpURLConnection
        try {
            connection = Objects.requireNonNull(url).openConnection() as HttpURLConnection
            connection.connect()
            val inputStream = connection.inputStream
            val bufferedInputStream = BufferedInputStream(inputStream)
            return BitmapFactory.decodeStream(bufferedInputStream)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        }
        return null
    }

    // Function to convert string to URL
    private fun mStringToURL(string: String?): URL {
        try {
            return URL(string)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        return URL(null)
    }


    private fun sendQrCodeImg(bitmap: Bitmap) {
        val qrStx = byteArrayOf(0x02, (0xf2 and 0xff).toByte(), 0x02)
        val qrEtx = byteArrayOf(0x02, (0xf2 and 0xff).toByte(), 0x03)
        // Log.i("TAG", "generateqRLink str: $byteArray")

        //  if (str.isNotEmpty() && str != "") {
        // val dataBytes = str.toByteArray(StandardCharsets.UTF_8)
        val dataBytes = bitmap.toByteArray()
        val length = byteArrayOf(
            (dataBytes.size shr 8 and 0xff).toByte(),
            (dataBytes.size and 0xff).toByte()
        )
        val buff = ByteBuffer.wrap(ByteArray(dataBytes.size + 8))
        buff.put(qrStx)
        buff.put(length)
        buff.put(dataBytes)
        buff.put(qrEtx)
        Log.i("TAG", "buff.array() : ${buff.array()}")

        val sh: SharedPreferences =
            requireActivity().getSharedPreferences("SharedPrefAddress", Context.MODE_PRIVATE)

        val deviceAddress = sh.getString("deviceAddress", "")
        if (deviceAddress != null) {
            CommandUtil(requireContext(), mCoroutineScope).sendCommand(deviceAddress, buff.array())
        }

        //}
    }


    private fun sendString(str: String) {
        val sh: SharedPreferences =
            requireActivity().getSharedPreferences("SharedPrefAddress", Context.MODE_PRIVATE)

        val deviceAddress = sh.getString("deviceAddress", "")

        /*if (deviceAddress != null) {
            CommandUtil(requireContext(), mCoroutineScope).sendCommand(deviceAddress, btClean)
        }*/
        val qrStx = byteArrayOf(0x02, (0xf2 and 0xff).toByte(), 0x02)
        val qrEtx = byteArrayOf(0x02, (0xf2 and 0xff).toByte(), 0x03)
        // Log.i("TAG", "generateqRLink str: $byteArray")

        if (str.isNotEmpty() && str != "") {
            val dataBytes = str.toByteArray(StandardCharsets.UTF_8)
            // val dataBytes=bitmap.toByteArray(StandardCharsets.UTF_8)
            val length = byteArrayOf(
                (dataBytes.size shr 8 and 0xff).toByte(),
                (dataBytes.size and 0xff).toByte()
            )
            val buff = ByteBuffer.wrap(ByteArray(dataBytes.size + 8))
            buff.put(qrStx)
            buff.put(length)
            buff.put(dataBytes)
            buff.put(qrEtx)
            Log.i("TAG", "buff.array() : ${length.toByteString()}")
            Log.i("TAG", "buff.array() : ${  buff.array()}")

            if (deviceAddress != null) {
             //   Handler(Looper.getMainLooper()).postDelayed({ //Do something after delay
                    CommandUtil(requireContext(), mCoroutineScope).sendCommand(
                        deviceAddress,
                        buff.array()
                    )
               // }, 2000)
            }
        }
    }


    private fun Bitmap.toByteArray(): ByteArray {
        ByteArrayOutputStream().apply {
            compress(Bitmap.CompressFormat.PNG, 80, this)
            return toByteArray()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }
}