package ru.mertech.sbpskb.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mertech.sbpskb.ui.fragments.FilterDialog;
import ru.mertech.sbpskb.ui.adapters.OperationsAdapter;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.SbpApi;
import ru.mertech.sbpskb.pojo.sbp.GetOperationsReq;
import ru.mertech.sbpskb.pojo.sbp.GetOperationsResp;
import ru.mertech.sbpskb.pojo.sbp.Operation;

public final class OperationsListActivity extends AppCompatActivity {
    public static final String AMOUNT = "ru.ascintegraciya.sbpskbandroid.amount";

    public static final String COMMISSION = "ru.ascintegraciya.sbpskbandroid.commission";

    public static final String OPERATION_DATE = "ru.ascintegraciya.sbpskbandroid.operation_date";

    public static final String OPERATION_ID = "ru.ascintegraciya.sbpskbandroid.operation_id";

    public static final String PAYER_BANK_ID = "ru.ascintegraciya.sbpskbandroid.payer_bank_id";

    public static final String PAYER_BANK_NAME = "ru.ascintegraciya.sbpskbandroid.payer_bank_name";

    public static final String PAYER_NAME = "ru.ascintegraciya.sbpskbandroid.payer_name";

    public static final String STATUS_OPERATION = "ru.ascintegraciya.sbpskbandroid.status_operation";

    public static final String TYPE_OPERATION = "ru.ascintegraciya.sbpskbandroid.type_operation";


    private final String successErrCode = "00000";

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Operation> sortAndFilterList(List<Operation> paramList) {
      /*  paramList.removeAll(Collections.singleton(new Function1<Operation, Boolean>() {
            @Override
            public Boolean invoke(Operation operation) {
                return operation.getStatus().equals(operation.toString());
            }
        }));*/


        paramList.stream().filter(operation-> operation.getStatus().equals(operation.toString())).collect(Collectors.<Operation>toList());

        if (paramList.size() > 1) {
            paramList.sort(new Comparator<Operation>() {
                @Override
                public int compare(Operation operation, Operation t1) {
                    return operation.getDatePayed().compareTo(t1.getDatePayed());
                }
            });
        }
        Calendar calendar = GregorianCalendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        int i = timeZone.getRawOffset();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EE, dd MMMM HH:mm", Locale.getDefault());
        for (Operation operation : paramList) {
            Date date = null;
            try {
                date = simpleDateFormat1.parse(operation.getDatePayed());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String str = simpleDateFormat2.format(new Date(Objects.requireNonNull(date).getTime() + i));
            StringBuilder stringBuilder = new StringBuilder();
            String str1 = str.substring(0, 1);
            str1 = str1.toUpperCase();
            stringBuilder.append(str1);
            str = str.substring(1);
            stringBuilder.append(str);
            operation.setDatePayed(stringBuilder.toString());
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
            decimalFormatSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("0.00", decimalFormatSymbols);
            decimalFormat.getDecimalFormatSymbols();
            BigDecimal bigDecimal2 = new BigDecimal(operation.getAmount());
            BigDecimal bigDecimal1 = new BigDecimal(operation.getTspCommission());
            bigDecimal2 = bigDecimal2.divide(new BigDecimal(100),1);
            bigDecimal2.setScale(2, 0);
            bigDecimal1 = bigDecimal1.divide(new BigDecimal(100),1);
            bigDecimal1.setScale(2, 0);
            String str3 = decimalFormat.format(bigDecimal2);
            operation.setAmount(str3);
            String str2 = decimalFormat.format(bigDecimal1);
            operation.setTspCommission(str2);
        }
        return paramList;
    }


    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_operations_list);
        ProgressBar progressBar =  findViewById(R.id.progressBarOperationsList);
        TextView waitMsgTxt =  findViewById(R.id.waitMessageTvOperationsList);
        TextView errorMsgTxt =  findViewById(R.id.errorMessageTvOperationsList);
        RecyclerView recyclerView = findViewById(R.id.operationsListRV);

        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String string = defaultSharedPreferences.getString(getString(R.string.key_pref_login), "");
        String string2 = defaultSharedPreferences.getString(getString(R.string.key_pref_pass), "");
        String string3 = defaultSharedPreferences.getString(getString(R.string.key_pref_merchant_id), "");

                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
                    Retrofit build = new Retrofit.Builder().baseUrl("https://sbp.api.skbbank.ru/").client(new OkHttpClient.Builder().authenticator(new Authenticator() {
                        @NonNull
                        @Override
                        public Request authenticate(@Nullable Route route, @NonNull Response response)  {
                            return response.request().newBuilder().header("Authorization", Credentials.basic(string, string2)).build();
                        }
                    }).addInterceptor(httpLoggingInterceptor).readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
                    String stringExtra = getIntent().getStringExtra(FilterDialog.TYPE);
                    String stringExtra2 = getIntent().getStringExtra(FilterDialog.STATUS);
                    String stringExtra3 = getIntent().getStringExtra(FilterDialog.DATE_START);

                    String stringExtra4 = getIntent().getStringExtra(FilterDialog.DATE_END);

                    GetOperationsReq getOperationsReq = new GetOperationsReq(string3, stringExtra3, stringExtra4);
                    build.create(SbpApi.class).getOperations(getOperationsReq).flatMap(new Function<GetOperationsResp, Single<GetOperationsResp>>() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public Single<GetOperationsResp> apply(GetOperationsResp getOperationsResp)  {
                            if (getOperationsResp.getErrCode().equals(OperationsListActivity.this.successErrCode)) {

                                getOperationsResp.setOperations(OperationsListActivity.this.sortAndFilterList(getOperationsResp.getOperations()));
                            } else {
                                progressBar.setVisibility(View.INVISIBLE);
                                waitMsgTxt.setVisibility(View.INVISIBLE);
                                errorMsgTxt.setText(OperationsListActivity.this.getString(R.string.operations_list_error_message, getOperationsResp.getErrCode(), getOperationsResp.getErrMess()));
                            }
                            return Single.just(getOperationsResp);                        }
                    }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(t -> {

                        progressBar.setVisibility(View.INVISIBLE);
                        waitMsgTxt.setVisibility(View.INVISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        recyclerView.setLayoutManager(new LinearLayoutManager(OperationsListActivity.this));
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setAdapter(new OperationsAdapter(t.getOperations(), new OperationsAdapter.CallBack() {
                            public void onItemClicked(Operation param1Operation) {
                                Intent intent = new Intent(OperationsListActivity.this, OperationActivity.class);
                                intent.putExtra(TYPE_OPERATION, param1Operation.getOperationType());
                                intent.putExtra(STATUS_OPERATION, param1Operation.getStatus());
                                intent.putExtra(PAYER_NAME, param1Operation.getPam());
                                intent.putExtra(PAYER_BANK_NAME, param1Operation.getPayerBankName());
                                intent.putExtra(AMOUNT, param1Operation.getAmount());
                                intent.putExtra(COMMISSION, param1Operation.getTspCommission());
                                intent.putExtra(OPERATION_DATE, param1Operation.getDatePayed());
                                intent.putExtra(OPERATION_ID, param1Operation.getTransactionNumber());
                                intent.putExtra(PAYER_BANK_ID, param1Operation.getPayerBankId());
                                OperationsListActivity.this.startActivity(intent);
                            }
                        }));
                    }, throwable -> {
                        progressBar.setVisibility(View.INVISIBLE);
                        waitMsgTxt.setVisibility(View.INVISIBLE);
                        errorMsgTxt.setText(throwable.getMessage());
                    });

        progressBar.setVisibility(View.INVISIBLE);
        waitMsgTxt.setVisibility(View.INVISIBLE);
        errorMsgTxt.setText(getString(R.string.empty_pref_error_message));
    }
}

