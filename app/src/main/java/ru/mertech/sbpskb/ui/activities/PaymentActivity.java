package ru.mertech.sbpskb.ui.activities;

import static com.google.zxing.BarcodeFormat.QR_CODE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.FileProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.SbpApi;
import ru.mertech.sbpskb.api.TelegramAPI;
import ru.mertech.sbpskb.pojo.sbp.AgentRaiffRegisterQrReq;
import ru.mertech.sbpskb.pojo.sbp.AgentRaiffRegisterQrResp;
import ru.mertech.sbpskb.pojo.sbp.GetDataResp;
import ru.mertech.sbpskb.pojo.sbp.Merchant;
import ru.mertech.sbpskb.pojo.sbp.QrType;
import ru.mertech.sbpskb.pojo.sbp.StatusRegisterQr;

public final class PaymentActivity extends AppCompatActivity {

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

    private MenuItem shareBtn;

    SharedPreferences sharedPref;

    private final String successErrCode = "RQ00000";
    private String predefinedApps = "com.idamob.tinkoff.android;com.openbank;com.webmoney.my;ru.mkb.mobile;ru.vtb24.mobilebanking.android;logo.com.mbanking;ru.skbbank.ib;ru.wildberries.razz";
    private BottomSheetDialog dialog;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private void sendFirstPaymentMessage() {
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

    private void switchToQr(String paramString) {
        TextView textView3 = findViewById(R.id.waitMessagePayment);
        textView3.setVisibility(View.INVISIBLE);
        ProgressBar progressBar = findViewById(R.id.progressBarPayment);
        progressBar.setVisibility(View.INVISIBLE);
        Button button = findViewById(R.id.getPaymentStatusBtnPayment);
        button.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.qrIvPayment);
        imageView.setVisibility(View.VISIBLE);
        TextView textView2 = findViewById(R.id.totalTvPayment);
        textView2.setVisibility(View.VISIBLE);
        //  MenuItem menuItem = this.cancelBtn;
        // menuItem.setVisible(true);
        //  menuItem = this.shareBtn;
        // menuItem.setVisible(true);
        TextView textView1 = findViewById(R.id.paymentStatusTvPayment);
        textView1.setVisibility(View.VISIBLE);
        textView1 = findViewById(R.id.paymentStatusTvPayment);
        textView1.setText(paramString);
    }

    private void switchToResult(String paramString, Boolean paramBoolean) {
        Button button2 = findViewById(R.id.getPaymentStatusBtnPayment);
        button2.setVisibility(View.INVISIBLE);
        ImageView imageView2 = findViewById(R.id.qrIvPayment);
        imageView2.setVisibility(View.INVISIBLE);
        TextView textView4 = findViewById(R.id.totalTvPayment);
        textView4.setVisibility(View.INVISIBLE);
        // MenuItem menuItem = this.cancelBtn;
        // menuItem.setVisible(paramBoolean);
        //  menuItem = this.shareBtn;
        // menuItem.setVisible(paramBoolean);
        TextView textView3 = findViewById(R.id.paymentStatusTvPayment);
        textView3.setVisibility(View.INVISIBLE);
        textView3 = findViewById(R.id.waitMessagePayment);
        textView3.setVisibility(View.INVISIBLE);
        ProgressBar progressBar = findViewById(R.id.progressBarPayment);
        progressBar.setVisibility(View.INVISIBLE);
        TextView textView2 = findViewById(R.id.resultTvPayment);
        textView2.setVisibility(View.VISIBLE);
        ImageView imageView1 = findViewById(R.id.resultIvPayment);
        imageView1.setVisibility(View.VISIBLE);
        Button button1 = findViewById(R.id.newPaymentBtnPayment);
        button1.setVisibility(View.VISIBLE);
        if (paramBoolean.equals(Boolean.TRUE)) {
            ((ImageView) findViewById(R.id.resultIvPayment)).setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_success));
        } else if (paramBoolean.equals(Boolean.FALSE)) {
            ((ImageView) findViewById(R.id.resultIvPayment)).setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_fail));
        }
        textView2.setText(paramString);
    }

    private void switchToWait(String paramString) {
        Button button = findViewById(R.id.getPaymentStatusBtnPayment);
        button.setVisibility(View.INVISIBLE);
        ImageView imageView = findViewById(R.id.qrIvPayment);
        imageView.setVisibility(View.INVISIBLE);
        TextView textView3 = findViewById(R.id.totalTvPayment);
        textView3.setVisibility(View.INVISIBLE);
        //  MenuItem menuItem = this.cancelBtn;
//        menuItem.setVisible(false);
        //  menuItem = this.shareBtn;
        //  menuItem.setVisible(false);
        TextView textView2 = findViewById(R.id.paymentStatusTvPayment);
        textView2.setVisibility(View.INVISIBLE);
        ProgressBar progressBar = findViewById(R.id.progressBarPayment);
        progressBar.setVisibility(View.VISIBLE);
        TextView textView1 = findViewById(R.id.waitMessagePayment);
        textView1.setVisibility(View.VISIBLE);
        textView1 = findViewById(R.id.waitMessagePayment);
        textView1.setText(paramString);
    }


   /* public final void getPaymentStatus(String qrId) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNQTQ2NzY5OSIsImp0aSI6IjIxZDU0NDMwLWM1ODctNGU0MC1iNDQxLTI5ZWU2Y2QyNjMwNSJ9.-bD4cSz56DgUgM9aXp9mXAt67yfjslCVrI3KJNfhQ5U")
                                .build();
                        return chain.proceed(newRequest);
                    }
                })
                .readTimeout(60L, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS).build();

        retrofitClient = new Retrofit.Builder()
                .baseUrl("https://test.ecom.raiffeisen.ru/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        String str = getString(R.string.get_payment_status_message);
        switchToWait(str);
        str = UUID.randomUUID().toString();
        //GetPaymentsStatusReq getPaymentsStatusReq = new GetPaymentsStatusReq(qrId);

        retrofitClient.create(SbpApi.class)
                .getPaymentsStatus(qrId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetPaymentsStatusRaiffResp>() {
                    @Override
                    public void accept(GetPaymentsStatusRaiffResp getPaymentsStatusRaiffResp) {
                       *//* if (getPaymentsStatusResp.getCode().equals(successErrCode)) {
                           // if (!getPaymentsStatusResp.getPaymentStatus().isEmpty()) {
                                String str1 = getPaymentsStatusResp.getPaymentStatus();
                                if (str1.equals(PaymentStatus.NOT_STARTED.getCode())) {
                                    switchToQr(PaymentStatus.NOT_STARTED.getMessage());
                                } else if (str1.equals(PaymentStatus.SUCCESS.getCode())) {
                                    switchToQr(PaymentStatus.SUCCESS.getMessage());
                                } else {
                                    if (str1.equals(PaymentStatus.ACCEPTED.getCode())) {
                                        if (isFirstPayment) {
                                            sendFirstPaymentMessage();
                                        } else {
                                            str1 = getString(R.string.success_payment_message);
                                            switchToResult(str1, Boolean.TRUE);
                                        }
                                    } else if (str1.equals(PaymentStatus.REJECTED.getCode())) {
                                        String stringBuilder = "Перевод отклонен.\n" +
                                                getPaymentsStatusResp.getPaymentStatus();
                                        switchToResult(stringBuilder, Boolean.FALSE);
                                    }
                                }
                           *//**//* } else {
                                switchToQr(PaymentStatus.NOT_STARTED.getMessage());
                            }*//**//*
                        } else {

                            switchToQr( getPaymentsStatusResp.getCode());
                        }*//*
                        if (getPaymentsStatusRaiffResp.getCode().equals("SUCCESS") && getPaymentsStatusRaiffResp.getPaymentStatus().equals("SUCCESS")) {
                            switchToResult(PaymentStatus.SUCCESS.getMessage(), true);
                        } else if (getPaymentsStatusRaiffResp.getCode().equals("SUCCESS") && getPaymentsStatusRaiffResp.getPaymentStatus().equals("NO_INFO")) {
                            switchToQr("NO_INFO");
                        } else {
                            switchToResult("ERROR", false);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        if (throwable instanceof HttpException && ((HttpException) throwable).code() == 405) {
                            String str = getString(R.string.timeout_error);
                            switchToQr(str);
                        } else {
                            switchToQr(throwable.getMessage());
                        }
                    }
                });
    }*/

    public final void newPaymentBtnOnClick(View paramView) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_payment);
        Button btncheckStatus = findViewById(R.id.getPaymentStatusBtnPayment);
        sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String str1 = sharedPref.getString(getString(R.string.key_pref_login), "");

        String str2 = sharedPref.getString(getString(R.string.key_pref_pass), "");


        isFirstPayment = sharedPref.getBoolean(getString(R.string.key_pref_is_first_payment), true);
        String str3 = sharedPref.getString(getString(R.string.key_pref_merchant_id), "");


        String amount = getIntent().getStringExtra("amount");

        if (amount.contains(",")) {
            amount.replace(',', '.');
        }
        BigDecimal bigDecimal = new BigDecimal("0.0").add(new BigDecimal(amount));
        amount = bigDecimal.toString();
        String str4 = bigDecimal.multiply(new BigDecimal(100)).setScale(0, 0).toString();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = (new OkHttpClient.Builder())
                .authenticator(new Authenticator() {
                    @NonNull
                    @Override
                    public Request authenticate(@Nullable Route route, @NonNull Response response) {
                        Request.Builder builder = response.request().newBuilder();

                        // return builder.header("Authorization", Credentials.basic(str1, str2)).build();
                        return builder.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNQTQ2NzY5OSIsImp0aSI6IjIxZDU0NDMwLWM1ODctNGU0MC1iNDQxLTI5ZWU2Y2QyNjMwNSJ9.-bD4cSz56DgUgM9aXp9mXAt67yfjslCVrI3KJNfhQ5U").build();
                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();
        retrofitClient = new Retrofit.Builder()
                .baseUrl("https://test.ecom.raiffeisen.ru/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        String str5 = UUID.randomUUID().toString();
        AgentRaiffRegisterQrReq agentRaiffRegisterQrReq = new AgentRaiffRegisterQrReq("MA467699", QrType.QR_DYNAMIC.getCode(), amount, "RUB", "1-2-7");


        String finalAmount = amount;

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = retrofitClient.create(SbpApi.class)
                .registerRaiffQr(agentRaiffRegisterQrReq)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AgentRaiffRegisterQrResp>() {
                    @Override
                    public void accept(AgentRaiffRegisterQrResp agentRegisterQrResp) throws Exception {

                        qrUrl = agentRegisterQrResp.getQrUrl();

                        boolean bool = agentRegisterQrResp.getCode().equals(StatusRegisterQr.SUCCESS.getCode());
                        TextView textView = findViewById(R.id.totalTvPayment);
                        textView.setText(String.format(getString(R.string.sum_rub), finalAmount));
                        if (bool) {

                            BitMatrix result = new MultiFormatWriter().encode(qrUrl,
                                    QR_CODE, 800, 800, null);
                            //  Bitmap bitmap1 = QRCode.from(agentRegisterQrResp.getPayload()).withErrorCorrection(ErrorCorrectionLevel.H).withSize(500, 500).bitmap();
                            //   bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo_sbp);
                            int i = (int) (result.getWidth() / 1.85D);
                            float f = (float) result.getHeight() / result.getWidth();
                            //   bitmap = Bitmap.createScaledBitmap(bitmap, i, (int) (i * f), true);
                            qrWithLogo = Bitmap.createBitmap(result.getWidth(), result.getHeight(), Bitmap.Config.RGB_565);
                            for (int x = 0; x < result.getWidth(); x++) {
                                for (int y = 0; y < result.getHeight(); y++) {
                                    qrWithLogo.setPixel(x, y, result.get(x, y) ? Color.BLACK : Color.WHITE);
                                }
                            }
                            Canvas canvas = new Canvas(qrWithLogo);
                            canvas.drawBitmap(qrWithLogo, new Matrix(), null);
                            canvas.drawBitmap(qrWithLogo, ((canvas.getWidth() - qrWithLogo.getWidth()) / 2f), ((canvas.getHeight() - qrWithLogo.getHeight()) / 2f), null);
                            switchToQr(agentRegisterQrResp.getCode());
                            ((ImageView) findViewById(R.id.qrIvPayment)).setImageBitmap(qrWithLogo);

                            btncheckStatus.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                   // getPaymentStatus(agentRegisterQrResp.getQrId());
                                }
                            });

                        } else if (agentRegisterQrResp.getCode().equals("ERROR.ORDER_NUMBER_ALREADY_REGISTERED")) {
                            String stringBuilder = "Ошибка: " +
                                    agentRegisterQrResp.getCode();
                            switchToResult(stringBuilder, false);
                        } else {
                            switchToResult(agentRegisterQrResp.getMessage(), false);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        boolean bool = throwable instanceof HttpException;
                        if (bool && ((HttpException) throwable).code() == 401) {
                            String str = getString(R.string.auth_error_message);
                            switchToResult(str, false);
                        } else {
                            switchToResult(throwable.getMessage(), false);
                        }
                        String str = getString(R.string.empty_pref_error_message);
                        switchToResult(str, false);
                    }
                });

        compositeDisposable.add(disposable);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_payment, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionPutAside) {

            if (qrWithLogo == null) {
                return false;
            }
            Context context = getApplicationContext();
            File file = new File(context.getCacheDir(), "images");
            file.mkdirs();
            String stringBuilder = file +
                    "/qr.png";
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(stringBuilder);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            qrWithLogo.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            try {
                Objects.requireNonNull(fileOutputStream).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file = new File(file, "qr.png");
            Uri uri = FileProvider.getUriForFile(getApplicationContext(), "ru.ascintegraciya.sbpskbandroid.fileprovider", file);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri, getContentResolver().getType(uri));
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("android.intent.extra.TEXT", qrUrl);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.actionShare) {
            String str = getString(R.string.put_aside_message);
            switchToResult(str, false);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
