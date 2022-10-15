package ru.mertech.sbpskb.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.preference.PreferenceManager;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mertech.sbpskb.BasicAuthenticator;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.SbpApi;
import ru.mertech.sbpskb.pojo.sbp.ApproveRefundTransferReq;
import ru.mertech.sbpskb.pojo.sbp.ApproveRefundTransferResp;
import ru.mertech.sbpskb.pojo.sbp.CheckRefundTransferReq;
import ru.mertech.sbpskb.pojo.sbp.CheckRefundTransferResp;
import ru.mertech.sbpskb.pojo.sbp.RefundStatus;


public final class RefundActivity extends AppCompatActivity {

    private Disposable approveRefundTransferDisp;

    private Disposable checkRefundTransferDisp;

    private String corelationId = "";

    private boolean isSuccess;

    private Retrofit retrofitClient;

    private final String successErrCode = "0";
    private String amountForDisplay = "";


    private Consumer<Throwable> onErrorCheckRefund() {
        return throwable -> {
            isSuccess = false;
            switchToResult(String.valueOf(throwable.getMessage()));
        };
    }

    private Consumer<CheckRefundTransferResp> onSuccessCheckRefund() {
        return checkRefundTransferResp -> {
            if (checkRefundTransferResp.getErrCode().equals(successErrCode)) {

                if (checkRefundTransferResp.getCorelationId().length() > 0) {
                    ProgressBar progressBar = findViewById(R.id.progressBarRefund);
                    progressBar.setVisibility(View.GONE);
                    TextView waitMsg = findViewById(R.id.waitMessageRefund);
                    waitMsg.setVisibility(View.GONE);
                    Button button = findViewById(R.id.refundTransferBtnRefund);
                    button.setVisibility(View.VISIBLE);
                    TextView refundTxt = findViewById(R.id.tvRefund);
                    refundTxt.setVisibility(View.VISIBLE);
                    TextView amountTRefund = findViewById(R.id.amountTvRefund);
                    amountTRefund.setVisibility(View.VISIBLE);
                    corelationId = checkRefundTransferResp.getCorelationId();
                    amountTRefund.setText(getString(R.string.amount_operation));
                    refundTxt.setText(RefundActivity.this.getString(R.string.refund_approved_message));
                } else {
                    isSuccess = false;
                    String stringBuilder = "Код ошибки: " +
                            checkRefundTransferResp.getErrCode() +
                            "\nОшибка:\n" +
                            checkRefundTransferResp.getErrMess();
                    switchToResult(stringBuilder);
                }
            }
        };
    }

    private void switchToResult(String paramString) {
        ProgressBar progressBar = findViewById(R.id.progressBarRefund);
        progressBar.setVisibility(View.GONE);
        TextView textView3 = findViewById(R.id.waitMessageRefund);
        textView3.setVisibility(View.GONE);
        Button button = findViewById(R.id.newPaymentBtnRefund);
        button.setVisibility(View.VISIBLE);
        TextView textView2 = findViewById(R.id.resultTvRefund);
        textView2.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.resultIvRefund);
        imageView.setVisibility(View.VISIBLE);
        textView2.setText(paramString);
        if (this.isSuccess) {
            ((ImageView) findViewById(R.id.resultIvRefund)).setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_success));
        } else {
            ((ImageView) findViewById(R.id.resultIvRefund)).setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_fail));
        }
    }


    public final void newPaymentBtnOnClick(View paramView) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_refund);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String str2 = sharedPreferences.getString(getString(R.string.key_pref_merchant_id), "");
        String str3 = sharedPreferences.getString(getString(R.string.key_pref_login), "");
        String str1 = sharedPreferences.getString(getString(R.string.key_pref_pass), "");


        if (str2 == null || str2.length() == 0) {
            String str4 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.refund_amount");
            String str5 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.transaction_id");

            if (str4.contains(",")) {
                str4.replace(',', '.');
            }
            BigDecimal bigDecimal = new BigDecimal("0.0").add(new BigDecimal(str4));
            str4 = bigDecimal.setScale(2, 0).toString();
            amountForDisplay = bigDecimal.multiply(new BigDecimal(100)).setScale(0, 0).toString();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    //.authenticator(new BasicAuthenticator(str3, str1))
                    .addInterceptor(httpLoggingInterceptor)
                    .readTimeout(60L, TimeUnit.SECONDS)
                    .connectTimeout(60L, TimeUnit.SECONDS).build();
            retrofitClient = new Retrofit.Builder()
                    .baseUrl("https://sbp.api.skbbank.ru/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            //check this!!
            CheckRefundTransferReq checkRefundTransferReq = new CheckRefundTransferReq(UUID.randomUUID().toString(), str5, str4);     //check this!!
//            RefundActivity$sam$io_reactivex_functions_Consumer$0 refundActivity$sam$io_reactivex_functions_Consumer$02;
//            RefundActivity$sam$io_reactivex_functions_Consumer$0 refundActivity$sam$io_reactivex_functions_Consumer$01;

            Single<CheckRefundTransferResp> single = retrofitClient.create(SbpApi.class)
                    .checkRefundTransfer(checkRefundTransferReq)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io());
            //  Function1<CheckRefundTransferResp, Unit> function13 = onSuccessCheckRefund();
            // if (function13 != null)
            //     refundActivity$sam$io_reactivex_functions_Consumer$02 = new RefundActivity$sam$io_reactivex_functions_Consumer$0(function13);
            //  RefundActivity$sam$io_reactivex_functions_Consumer$0 refundActivity$sam$io_reactivex_functions_Consumer$03 = refundActivity$sam$io_reactivex_functions_Consumer$02;
            //  function13 = (Function1) onErrorCheckRefund();
            //  Function1<CheckRefundTransferResp, Unit> function11 = function13;
            //   if (function13 != null)
            //     refundActivity$sam$io_reactivex_functions_Consumer$01 = new RefundActivity$sam$io_reactivex_functions_Consumer$0(function13);
            checkRefundTransferDisp = single.subscribe(onSuccessCheckRefund(), onErrorCheckRefund());
        }

        isSuccess = false;
        switchToResult(getString(R.string.empty_pref_error_message));
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.menu_refund, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {

        approveRefundTransferDisp.dispose();
        checkRefundTransferDisp.dispose();

        finish();
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public final void refundTransferBtnOnClick(View paramView) {
        ProgressBar progressBar = findViewById(R.id.progressBarRefund);
        progressBar.setVisibility(View.VISIBLE);
        TextView textView2 = findViewById(R.id.waitMessageRefund);
        textView2.setVisibility(View.VISIBLE);
        paramView.setVisibility(View.GONE);
        TextView textView1 = findViewById(R.id.amountTvRefund);
        textView1.setVisibility(View.GONE);
        textView1 = findViewById(R.id.tvRefund);
        textView1.setVisibility(View.GONE);
        textView2.setText(getString(R.string.refund_transfer_message));
        ApproveRefundTransferReq approveRefundTransferReq = new ApproveRefundTransferReq(UUID.randomUUID().toString(), corelationId);

        approveRefundTransferDisp = retrofitClient.create(SbpApi.class)
                .approveRefundTransfer(approveRefundTransferReq)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ApproveRefundTransferResp>() {
                    @Override
                    public void accept(ApproveRefundTransferResp approveRefundTransferResp) {
                        if (approveRefundTransferResp.getErrCode().equals(successErrCode)) {
                            if (approveRefundTransferResp.getStatus().equals(RefundStatus.ACCEPTED.getCode())) {
                                isSuccess = true;
                                switchToResult(getString(R.string.accepted_refund_message));
                            } else if (approveRefundTransferResp.getStatus().equals(RefundStatus.REJECTED.getCode())) {
                                isSuccess = false;
                                String stringBuilder = "Код ошибки: " +
                                        approveRefundTransferResp.getErrCode() +
                                        '\n' +
                                        "Ошибка:\n" +
                                        approveRefundTransferResp.getErrMess();
                                switchToResult(stringBuilder);
                            } else {
                                isSuccess = false;
                                switchToResult(getString(R.string.unknown_status_refund_transfer_message));
                            }
                        } else {
                            isSuccess = false;
                            String stringBuilder = "Код ошибки: " +
                                    approveRefundTransferResp.getErrCode() +
                                    '\n' +
                                    "Ошибка:\n" +
                                    approveRefundTransferResp.getErrMess();
                            switchToResult(stringBuilder);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        isSuccess = false;
                        String str = throwable.getMessage();
                        if (str == null) {
                            str = "Error";
                        }
                        switchToResult(str);
                    }
                });
    }
}

