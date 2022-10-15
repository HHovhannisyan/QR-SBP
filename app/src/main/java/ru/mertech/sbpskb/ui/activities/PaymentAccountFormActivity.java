package ru.mertech.sbpskb.ui.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.DaDataApi;
import ru.mertech.sbpskb.api.SkbApi;
import ru.mertech.sbpskb.api.TelegramAPI;
import ru.mertech.sbpskb.pojo.dadata.GetOrgListReq;
import ru.mertech.sbpskb.pojo.dadata.GetOrgListResp;
import ru.mertech.sbpskb.pojo.dadata.Organization;
import ru.mertech.sbpskb.pojo.skb.GetListCitiesResp;
import ru.mertech.sbpskb.pojo.skb.PostClaimResp;
import ru.mertech.sbpskb.pojo.skb.PostClaimResponse;

public final class PaymentAccountFormActivity extends AppCompatActivity {

    private final String botToken = "1097886742:AAG49a7EQ76AAYdGBpABwJfXAB1RNaYjTd8";

    private final String chatId = "-1001146408971";

    private Map<String, String> citiesMap;

    private Retrofit retrofitClient;

    private String savedCity = "";

    private void showDialog(String paramString2) {
        new AlertDialog.Builder(this).setTitle("Ошибка").setMessage(paramString2).setPositiveButton(getString(R.string.dialog_pin_btn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }


    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_payment_account_form);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.payment_account_form_title);
        builder.setMessage(R.string.payment_account_form_message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //dialogInterface.dismiss();
            }
        });
        builder.create();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).readTimeout(60L, TimeUnit.SECONDS).connectTimeout(60L, TimeUnit.SECONDS).build();
        retrofitClient = new Retrofit.Builder().baseUrl(SkbApi.BASE_URL).client(okHttpClient).addConverterFactory(ScalarsConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        ((AutoCompleteTextView) findViewById(R.id.nameOrgEtForm)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (String.valueOf(s).length() <= 3)
                    return;
                retrofitClient.create(DaDataApi.class).getOrgList("Token 6c65d080d0dd898e6d6f43c40ca1d28dfc994844", new GetOrgListReq(String.valueOf(s), 10)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<GetOrgListResp>() {
                    @Override
                    public void accept(GetOrgListResp getOrgListResp) {
                        List<String> arrayList = new ArrayList<>();
                        for (Organization organization : getOrgListResp.getOrganizations()) {
                            String stringBuilder = organization.getName() +
                                    ';' +
                                    organization.getData().getAddress().getData().getCity() +
                                    ';' +
                                    organization.getData().getInn() +
                                    ';' +
                                    organization.getData().getOgrn();
                            arrayList.add(stringBuilder);
                        }
                        //   MyArrayAdapter myArrayAdapter = new MyArrayAdapter(PaymentAccountFormActivity.this, 17367053);
                        //  myArrayAdapter.setData(arrayList);
                        //  ((AutoCompleteTextView) findViewById(R.id.nameOrgEtForm)).setAdapter(myArrayAdapter);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {

                    }
                });
            }
        });
        /*((AutoCompleteTextView) findViewById(R.id.nameOrgEtForm)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AutoCompleteTextView) view.findViewById(R.id.nameOrgEtForm)).setText(R.string.name_form_title);
                ((EditText) view.findViewById(R.id.innEtForm)).setText(R.string.inn_form_title);
                ((EditText) view.findViewById(R.id.ogrnEtForm)).setText(R.string.ogrn_form_title);
                // SmartMaterialSpinner<String> searchableSpinner = view.findViewById(R.id.spinner);

                // SpinnerAdapter spinnerAdapter = searchableSpinner.getAdapter();
                //   boolean bool = spinnerAdapter instanceof ArrayAdapter;

                //  ArrayAdapter arrayAdapter = (ArrayAdapter) spinnerAdapter;
                //   int i = arrayAdapter.getPosition(R.string.city_form_title);
                // searchableSpinner.setSelection(i);
                ((AutoCompleteTextView) view.findViewById(R.id.nameOrgEtForm)).dismissDropDown();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        Retrofit retrofit2 = new Retrofit.Builder().baseUrl(DaDataApi.BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();


        retrofit2.create(SkbApi.class).getListCities(null, SkbApi.SKB_TOKEN, null, null).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {
                GetListCitiesResp getListCitiesResp1 = null;
                try {
                    Gson gson = new Gson();
                    getListCitiesResp1 = gson.fromJson(s, GetListCitiesResp.class);
                } catch (JsonParseException jsonParseException) {
                }
                if (getListCitiesResp1 != null) {
                    citiesMap = getListCitiesResp1.getResp().getCites();
                    List<String> arrayList = new ArrayList<>();

                    arrayList.addAll(citiesMap.values());
                    // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(PaymentAccountFormActivity.this, android.R.layout.simple_spinner_item, arrayList);
                    //  SmartMaterialSpinner<String> searchableSpinner = findViewById(R.id.spinner);
                    //  searchableSpinner.setAdapter(arrayAdapter);
                    // searchableSpinner.setSelection(arrayList.indexOf(PaymentAccountFormActivity.this.savedCity));
                } else {
                    finish();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                finish();
            }
        });
        ((CheckBox) findViewById(R.id.agreementCheckBoxForm)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                new AlertDialog.Builder(PaymentAccountFormActivity.this).setTitle("Согласие на обработку персональных данных").setMessage(PaymentAccountFormActivity.this.getString(R.string.user_agreement)).setPositiveButton("Принять", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface param1DialogInterface, int param1Int) {
                        CompoundButton compoundButton = findViewById(R.id.agreementCheckBoxForm);
                        compoundButton.setChecked(true);
                    }
                }).setNegativeButton("Отказать", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface param1DialogInterface, int param1Int) {
                        CompoundButton compoundButton = findViewById(R.id.agreementCheckBoxForm);
                        compoundButton.setChecked(false);
                    }
                }).setOnCancelListener(param1DialogInterface -> {
                    CompoundButton compoundButton = findViewById(R.id.agreementCheckBoxForm);
                    compoundButton.setChecked(false);
                }).show();
            }
        });
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        ((AutoCompleteTextView) findViewById(R.id.nameOrgEtForm)).setText(paramBundle.getString(getString(R.string.key_org_name), ""));
        ((EditText) findViewById(R.id.innEtForm)).setText(paramBundle.getString(getString(R.string.key_inn), ""));
        ((EditText) findViewById(R.id.ogrnEtForm)).setText(paramBundle.getString(getString(R.string.key_ogrn), ""));
        ((EditText) findViewById(R.id.nameEtForm)).setText(paramBundle.getString(getString(R.string.key_name), ""));
        ((EditText) findViewById(R.id.lastNameEtForm)).setText(paramBundle.getString(getString(R.string.key_last_name), ""));
        ((EditText) findViewById(R.id.emailEtForm)).setText(paramBundle.getString(getString(R.string.key_email), ""));
        ((EditText) findViewById(R.id.phoneEtForm)).setText(paramBundle.getString(getString(R.string.key_phone), ""));
        this.savedCity = paramBundle.getString(getString(R.string.key_phone), "");
    }

    public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle) {
        super.onSaveInstanceState(paramBundle, paramPersistableBundle);
        String str3 = getString(R.string.key_org_name);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.nameOrgEtForm);
        paramBundle.putString(str3, autoCompleteTextView.getText().toString());
        String str6 = getString(R.string.key_inn);
        EditText editText2 = findViewById(R.id.innEtForm);
        paramBundle.putString(str6, editText2.getText().toString());
        String str7 = getString(R.string.ogrn);
        editText2 = findViewById(R.id.ogrnEtForm);
        paramBundle.putString(str7, editText2.getText().toString());
        String str1 = getString(R.string.key_name);
        EditText editText3 = findViewById(R.id.nameEtForm);
        paramBundle.putString(str1, editText3.getText().toString());
        String str4 = getString(R.string.key_last_name);
        editText3 = findViewById(R.id.lastNameEtForm);
        paramBundle.putString(str4, editText3.getText().toString());
        String str2 = getString(R.string.key_email);
        EditText editText1 = findViewById(R.id.emailEtForm);
        paramBundle.putString(str2, editText1.getText().toString());
        String str5 = getString(R.string.key_phone);
        editText1 = findViewById(R.id.phoneEtForm);
        paramBundle.putString(str5, editText1.getText().toString());
        SmartMaterialSpinner<String> searchableSpinner = findViewById(R.id.spinner);
        if (searchableSpinner != null && searchableSpinner.getSelectedItem() != null) {
            str2 = getString(R.string.key_city);
            paramBundle.putString(str2, searchableSpinner.getSelectedItem());
        }
    }

    public final void openPaymentAccountFormOnClick(View paramView) {
        String str;
        String str2;
        TextView tvFormTxt = findViewById(R.id.tvForm);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.nameOrgEtForm);

        //hide keyboard
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        String text = autoCompleteTextView.getText().toString();

        EditText editText = findViewById(R.id.innEtForm);
        String text2 = editText.getText().toString();

        EditText editText2 = findViewById(R.id.ogrnEtForm);
        String text3 = editText2.getText().toString();

        EditText editText3 = findViewById(R.id.nameEtForm);
        String text4 = editText3.getText().toString();

        EditText editText4 = findViewById(R.id.lastNameEtForm);
        String text5 = editText4.getText().toString();

        EditText editText5 = findViewById(R.id.phoneEtForm);
        String text6 = editText5.getText().toString();
        if (text.length() == 0 && text2.length() == 0 && text3.length() == 0 && text4.length() == 0 && text5.length() == 0 && text6.length() == 0) {
            showDialog("Необходимо заполнить все поля");
            return;
        }
        CheckBox checkBox = findViewById(R.id.agreementCheckBoxForm);
        if (!checkBox.isChecked()) {
            showDialog("Не принято пользователельское соглашение");
            return;
        }
        String obj = autoCompleteTextView.getText().toString();
        String obj2 = editText.getText().toString();
        String obj3 = editText2.getText().toString();
        SmartMaterialSpinner<String> searchableSpinner = findViewById(R.id.spinner);
        String obj4 = searchableSpinner.getSelectedItem();
        String obj5 = editText3.getText().toString();
        String obj6 = editText4.getText().toString();
        String obj7 = editText5.getText().toString();
        EditText editText11 = findViewById(R.id.emailEtForm);
        if (editText11.getText().toString().length() > 0) {
            str = editText11.getText().toString();
        } else {
            str = "na@na.ru";
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        Retrofit build = new Retrofit.Builder()
                .baseUrl("https://api.telegram.org")
                .client(new OkHttpClient.Builder()
                        .hostnameVerifier(new HostnameVerifier() {
                            @Override
                            public boolean verify(String hostname, SSLSession session) {
                                return false;
                            }
                        })
                        .addInterceptor(httpLoggingInterceptor)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .connectTimeout(60, TimeUnit.SECONDS).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        StringBuilder sb = new StringBuilder();
        sb.append("Новая заявка на окрыте р/с:\n\n");
        sb.append("Наименование организации: ").append(obj).append(10);
        sb.append("ИНН: ").append(obj2).append(10);
        sb.append("ОГРН: ").append(obj3).append(10);
        sb.append("Город: ").append(obj4).append(10);
        sb.append("Имя: ").append(obj5).append(10);
        sb.append("Фамилия: ").append(obj6).append(10);
        sb.append("Email: ").append(str).append(10);
        sb.append("Телефон: ").append(obj7).append(10);
        EditText editText13 = findViewById(R.id.promoCodeEtForm);
        if (editText13.getText().toString().length() > 0) {
            String sb2 = "Промокод " +
                    editText13.getText() +
                    10;
            sb.append(sb2);
        }
        String sb3 = sb.toString();
        build.create(TelegramAPI.class).sendMessage(botToken, chatId, sb3).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe();
        TextView textView = findViewById(R.id.titleTvPaymentAccountForm);
        textView.setVisibility(View.INVISIBLE);
        ScrollView scrollView = findViewById(R.id.scrollPaymentAccountForm);
        scrollView.setVisibility(View.INVISIBLE);
        Button button = findViewById(R.id.openPaymentAccountBtnForm);
        button.setVisibility(View.INVISIBLE);
        TextView waitMsgTxt = findViewById(R.id.waitMessageForm);
        waitMsgTxt.setVisibility(View.VISIBLE);
        ProgressBar progressBar = findViewById(R.id.progressBarForm);
        progressBar.setVisibility(View.VISIBLE);


        Set<String> keySet = citiesMap.keySet();
        String obj8 = searchableSpinner.getSelectedItem();
        Iterator<String> it = keySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = "";
                break;
            }
            String next = it.next();

            if (Objects.requireNonNull(citiesMap.get(next)).equals(obj8)) {
                str2 = next;
                break;
            }
        }
        Retrofit retrofit = retrofitClient;

        RequestBody create = RequestBody.Companion.create(obj5, MultipartBody.FORM);
        RequestBody create2 = RequestBody.Companion.create(obj6, MultipartBody.FORM);
        RequestBody create3 = RequestBody.Companion.create(str, MultipartBody.FORM);
        RequestBody.Companion companion = RequestBody.Companion;
        String sb4 = '7' + obj7;
        retrofit.create(SkbApi.class).postClaim(SkbApi.SKB_TOKEN, null, null, null, create, create2, create3, companion.create(sb4, MultipartBody.FORM), RequestBody.Companion.create(obj, MultipartBody.FORM), RequestBody.Companion.create(obj2, MultipartBody.FORM), RequestBody.Companion.create(obj3, MultipartBody.FORM), RequestBody.Companion.create(str2, MultipartBody.FORM), RequestBody.Companion.create("sib-integ", MultipartBody.FORM), RequestBody.Companion.create("delo_a_LIGHT", MultipartBody.FORM)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {

                waitMsgTxt.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                PostClaimResponse postClaimResponse = null;
                PostClaimResp postClaimResp = null;
                try {
                    Gson gson = new Gson();
                    postClaimResp = gson.fromJson(s, PostClaimResp.class);
                } catch (JsonParseException jsonParseException) {

                }

                if (postClaimResponse != null) {
                    if (postClaimResp.getResponse().getStates().getDuplicateType() == 0 && postClaimResp.getResponse().getStates().isVerified() == 1) {
                        retrofit.create(TelegramAPI.class).sendMessage(botToken, chatId, "Заявка принята банком").observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe();

                        tvFormTxt.setText("Заявка успешно принята, ожидайте, с Вами свяжется менеджер банка.");
                    } else {
                        TelegramAPI telegramAPI = retrofit.create(TelegramAPI.class);
                        String stringBuilder = "Заявка отклонена банком:\n" +
                                postClaimResp.getResponse().getStates().getStateMessage();
                        telegramAPI.sendMessage(botToken, chatId, stringBuilder)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe();
                        tvFormTxt.setText(postClaimResp.getResponse().getStates().getStateMessage());
                    }
                } else {
                    String str1 = tvFormTxt.getText().toString().replace(":", ":\n");

                    TelegramAPI telegramAPI = retrofit.create(TelegramAPI.class);
                    String stringBuilder = "Заявка отклонена банком:\n" +
                            str1;
                    telegramAPI.sendMessage(botToken, chatId, stringBuilder)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe();
                    TextView textView = findViewById(R.id.tvForm);
                    textView.setText(str1);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                HttpException httpException = null;
                waitMsgTxt.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                if (throwable instanceof HttpException) {
                    Response response = ((HttpException) throwable).response();

                    assert response != null;
                    String str1 = String.valueOf(response.body());
                    TelegramAPI telegramAPI = retrofit.create(TelegramAPI.class);
                    String stringBuilder = "Запрос не прошел:\nОшибка: " +
                            httpException.code() +
                            '\n' +
                            str1;
                    telegramAPI.sendMessage(botToken, chatId, stringBuilder)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe();
                    httpException.code();
                } else {
                    TelegramAPI telegramAPI = retrofit.create(TelegramAPI.class);
                    String stringBuilder2 = "Запрос не прошел:\nОшибка: " +
                            throwable.getMessage();
                    telegramAPI.sendMessage(botToken, chatId, stringBuilder2)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe();
                    assert httpException != null;
                    String stringBuilder1 = "Ошибка: " +
                            httpException.getMessage();
                    tvFormTxt.setText(stringBuilder1);
                }
            }
        });
    }
}



