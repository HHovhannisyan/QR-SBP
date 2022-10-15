package ru.mertech.sbpskb.ui.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Authenticator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mertech.sbpskb.BasicAuthenticator;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.SbpApi;
import ru.mertech.sbpskb.api.TelegramAPI;
import ru.mertech.sbpskb.databinding.StatusFragmentBinding;
import ru.mertech.sbpskb.pojo.sbp.AgentRaiffRegisterQrReq;
import ru.mertech.sbpskb.pojo.sbp.AgentRaiffRegisterQrResp;
import ru.mertech.sbpskb.pojo.sbp.AgentTinkoffRegisterQrReq;
import ru.mertech.sbpskb.pojo.sbp.AgentTinkoffRegisterQrResp;
import ru.mertech.sbpskb.pojo.sbp.GetDataResp;
import ru.mertech.sbpskb.pojo.sbp.GetQRTinkoffReq;
import ru.mertech.sbpskb.pojo.sbp.Merchant;
import ru.mertech.sbpskb.pojo.sbp.QrType;
import ru.mertech.sbpskb.pojo.sbp.StatusRegisterQr;
import ru.mertech.sbpskb.ui.viewModels.StatusViewModel;

@AndroidEntryPoint

public class StatusFragment extends Fragment {

    private StatusViewModel mViewModel;
    private final String botToken = "1097886742:AAG49a7EQ76AAYdGBpABwJfXAB1RNaYjTd8";

    private MenuItem cancelBtn;

    private final String chatId = "-1001146408971";

    private boolean isFirstPayment = true;

    private String login = "";

    private String pass = "";

    private String qrUrl;

    private Bitmap qrWithLogo;

    private final List<String> qrcId = new ArrayList<>();

    private Retrofit retrofitClient;


    SharedPreferences sharedPref;
    StatusFragmentBinding statusFragmentBinding;
    SharedPreferences sharedAmount;

    private final String successErrCode = "RQ00000";
    private String predefinedApps = "com.idamob.tinkoff.android;com.openbank;com.webmoney.my;ru.mkb.mobile;ru.vtb24.mobilebanking.android;logo.com.mbanking;ru.skbbank.ib;ru.wildberries.razz";
    private BottomSheetDialog dialog;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        statusFragmentBinding = StatusFragmentBinding.inflate(inflater, container, false);

        //   View root = inflater.inflate(R.layout.status_fragment, container, false)
        // Button btncheckStatus = root.findViewById(R.id.getPaymentStatusBtnPayment);
        sharedPref = requireContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String str1 = sharedPref.getString(getString(R.string.key_pref_login), "");

        String str2 = sharedPref.getString(getString(R.string.key_pref_pass), "");


        isFirstPayment = sharedPref.getBoolean(getString(R.string.key_pref_is_first_payment), true);
        String str3 = sharedPref.getString(getString(R.string.key_pref_merchant_id), "");


        //String amount = getIntent().getStringExtra("amount");

        Bundle bundle = this.getArguments();
        String amount = Objects.requireNonNull(bundle).getString("amount");


        BigDecimal bigDecimal = new BigDecimal(amount).multiply(new BigDecimal(100));

        SharedPreferences sh = requireActivity().getSharedPreferences("SpinnerSharedPref", MODE_PRIVATE);
        int spinnerPosition = sh.getInt("last_val", 0);

        if (spinnerPosition == 0) {
            getTinkoffRegisterStatus(bigDecimal.intValue());
        }
        if (spinnerPosition == 1) {
            getRaiffRegisterStatus(amount);
        }
        return statusFragmentBinding.getRoot();
    }

  /*  private void sendFirstPaymentMessage() {
        SbpApi sbpApi = retrofitClient.create(SbpApi.class);
        Single<GetDataResp> single = sbpApi.getData().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        single.subscribe(getDataResp -> {
            String str = getDataResp.getErrCode();

            if (str.length() == 0) {
                Merchant merchant = getDataResp.getMerchants().get(0);
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(httpLoggingInterceptor)
                        .readTimeout(60L, TimeUnit.SECONDS)
                        .connectTimeout(60L, TimeUnit.SECONDS).build();
                retrofitClient = new Retrofit.Builder()
                        .baseUrl("https://api.telegram.org")
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                String str2 = "Клиент " +
                        merchant.getName() +
                        " провёл свой первый платёж через наше приложение.";
                retrofitClient.create(TelegramAPI.class)
                        .sendMessage(botToken, chatId, str2)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor = editor.putBoolean(getString(R.string.key_pref_is_first_payment), false);
                editor.commit();

                switchToResult(getString(R.string.success_payment_message), true);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {

            }
        });
    }
*/

    private void switchToResult(String paramString, Boolean paramBoolean) {

        statusFragmentBinding.qrTxt.setVisibility(View.VISIBLE);

        statusFragmentBinding.progressBarPayment.setVisibility(View.INVISIBLE);
        statusFragmentBinding.qrTxt.setVisibility(View.INVISIBLE);
        statusFragmentBinding.resultTvPayment.setVisibility(View.VISIBLE);
        statusFragmentBinding.resultIvPayment.setVisibility(View.VISIBLE);
        if (paramBoolean.equals(Boolean.TRUE)) {
            statusFragmentBinding.resultIvPayment.setImageDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.success_big));
            statusFragmentBinding.showQrBtn.setVisibility(View.VISIBLE);
        } else {
            statusFragmentBinding.resultIvPayment.setImageDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_fail));
        }
        statusFragmentBinding.resultTvPayment.setText(paramString);
    }


    void getRaiffRegisterStatus(String amount) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = (new OkHttpClient.Builder())
                .authenticator(new BasicAuthenticator())
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();
        retrofitClient = new Retrofit.Builder()
                .baseUrl("https://test.ecom.raiffeisen.ru/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AgentRaiffRegisterQrReq agentRaiffRegisterQrReq = new AgentRaiffRegisterQrReq("MA467699", QrType.QR_DYNAMIC.getCode(), amount, "RUB", UUID.randomUUID().toString());

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = retrofitClient.create(SbpApi.class)
                .registerRaiffQr(agentRaiffRegisterQrReq)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AgentRaiffRegisterQrResp>() {
                    @Override
                    public void accept(AgentRaiffRegisterQrResp agentRegisterQrResp) {

                        qrUrl = agentRegisterQrResp.getQrUrl();

                        boolean bool = agentRegisterQrResp.getCode().equals(StatusRegisterQr.SUCCESS.getCode());
                        //  statusFragmentBinding.totalTvPayment.setText(String.format(getString(R.string.sum_rub), finalAmount));
                        if (bool) {
                            switchToResult("Успешно!", true);
                            statusFragmentBinding.qrTxt.setVisibility(View.VISIBLE);
                            statusFragmentBinding.showQrBtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    //getPaymentStatus(agentRegisterQrResp.getQrId());
                                    Bundle bundle = new Bundle();
                                    ShowQrFragment showQrFragment = new ShowQrFragment();
                                    bundle.putString("QRUrl", qrUrl);
                                    //bundle.putString("amount", agentRegisterQrResp.get);
                                    if (qrUrl != null) {
                                        showQrFragment.setArguments(bundle); //data being send to SecondFragment

                                        SharedPreferences prefs = requireActivity().getSharedPreferences("QrIdSharedPref", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = prefs.edit();
                                        editor.putString("qrId", agentRegisterQrResp.getQrId());
                                        editor.apply();
                                        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, showQrFragment).commit();
                                    } else {
                                        Toast.makeText(requireActivity(), "Error!. Please, try again!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            String stringBuilder = "Ошибка: " +
                                    "\n" + agentRegisterQrResp.getMessage();
                            switchToResult(stringBuilder, false);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        boolean bool = throwable instanceof HttpException;
                        if (bool && ((HttpException) throwable).code() == 401) {
                            String str = getString(R.string.timeout_error);
                            switchToResult("Ошибка" + "\n" + str, false);
                        }
                    }
                });

        compositeDisposable.add(disposable);
    }


     void getTinkoffRegisterStatus(int amount) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = (new OkHttpClient.Builder())
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();
        retrofitClient = new Retrofit.Builder()
                .baseUrl("https://securepay.tinkoff.ru/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AgentTinkoffRegisterQrReq agentTinkoffRegisterQrReq = new AgentTinkoffRegisterQrReq("1605280872049", amount, 643, UUID.randomUUID().toString());

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = retrofitClient.create(SbpApi.class)
                .registerTinkoffQr(agentTinkoffRegisterQrReq)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AgentTinkoffRegisterQrResp>() {
                    @Override
                    public void accept(AgentTinkoffRegisterQrResp agentTinkoffRegisterQrResp) throws JSONException, NoSuchAlgorithmException {
                        JSONObject rootObject = new JSONObject();
                        rootObject.put("Password", "xtiprrmg73jkiklh");
                        rootObject.put("PaymentId", agentTinkoffRegisterQrResp.getPaymentId());
                        rootObject.put("TerminalKey", "1605280872049");

                        String conc = rootObject.getString("Password")
                                + rootObject.getString("PaymentId")
                                + rootObject.getString("TerminalKey");

                        String encoded = toHexString(getSHA(conc));

                        GetQRTinkoffReq getQRTinkoffReq = new GetQRTinkoffReq("1605280872049", agentTinkoffRegisterQrResp.getPaymentId(), encoded);
                        CompositeDisposable compositeDisposable1 = new CompositeDisposable();
                        Disposable disposable1 = retrofitClient.create(SbpApi.class)
                                .getTinkoffQr(getQRTinkoffReq)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new Consumer<AgentTinkoffRegisterQrResp>() {
                                    @Override
                                    public void accept(AgentTinkoffRegisterQrResp agentTinkoffRegisterQrResp1) {

                                        boolean bool = agentTinkoffRegisterQrResp.getErrorCode().equals("0") && agentTinkoffRegisterQrResp.isSucceed();
                                        //  statusFragmentBinding.totalTvPayment.setText(String.format(getString(R.string.sum_rub), finalAmount));
                                        if (bool) {
                                            switchToResult("Успешно!", true);
                                            statusFragmentBinding.qrTxt.setVisibility(View.VISIBLE);
                                            statusFragmentBinding.showQrBtn.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    //getPaymentStatus(agentRegisterQrResp.getQrId());
                                                    Bundle bundle = new Bundle();
                                                    ShowQrFragment showQrFragment = new ShowQrFragment();
                                                    bundle.putString("QRUrl", agentTinkoffRegisterQrResp1.getDataQr());
                                                    bundle.putString("paymentID", agentTinkoffRegisterQrResp1.getPaymentId());
                                                    bundle.putString("encoded", encoded);
                                                    sharedAmount = requireActivity().getSharedPreferences("AmountSharedPref", MODE_PRIVATE);
                                                    sharedAmount.edit().putInt("amount", agentTinkoffRegisterQrResp1.getAmount()).apply();

                                                    SharedPreferences sharedpaymentID = requireActivity().getSharedPreferences("paymentIDSharedPref", MODE_PRIVATE);
                                                    sharedpaymentID.edit().putString("paymentID", agentTinkoffRegisterQrResp1.getPaymentId()).apply();

                                                    SharedPreferences sharedencoded = requireActivity().getSharedPreferences("encodedSharedPref", MODE_PRIVATE);
                                                    sharedencoded.edit().putString("encoded", encoded).apply();

                                                    //bundle.putString("qrId", agentRegisterQrResp.getQrId());
                                                    showQrFragment.setArguments(bundle); //data being send to SecondFragment
                                                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, showQrFragment).commit();

                                                }
                                            });

                                        } else if (!agentTinkoffRegisterQrResp.getErrorCode().equals("0") && !agentTinkoffRegisterQrResp.isSucceed()) {
                                            String stringBuilder = "Ошибка: " +
                                                    agentTinkoffRegisterQrResp.getMessage();
                                            switchToResult(stringBuilder, false);
                                        } else {
                                            switchToResult(agentTinkoffRegisterQrResp.getMessage(), false);
                                        }

                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) {
                                        boolean bool = throwable instanceof HttpException;
                                        if (bool && ((HttpException) throwable).code() == 401) {
                                            String str = getString(R.string.timeout_error);
                                            switchToResult("Ошибка" + "\n" + str, false);
                                        }
                                    }
                                });
                        compositeDisposable1.add(disposable1);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        boolean bool = throwable instanceof HttpException;
                        if (bool && ((HttpException) throwable).code() == 401) {
                            String str = getString(R.string.timeout_error);
                            switchToResult("Ошибка" + "\n" + str, false);
                        }
                    }
                });
        compositeDisposable.add(disposable);
    }


    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayUseLogoEnabled(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayUseLogoEnabled(true);
    }
}