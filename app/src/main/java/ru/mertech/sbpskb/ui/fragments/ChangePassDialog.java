package ru.mertech.sbpskb.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.text.Regex;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mertech.sbpskb.BasicAuthenticator;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.SbpApi;
import ru.mertech.sbpskb.pojo.sbp.ChangeUserPasswordReq;
import ru.mertech.sbpskb.pojo.sbp.ChangeUserPasswordResp;
import ru.mertech.sbpskb.ui.activities.AuthActivity;

public final class ChangePassDialog extends AppCompatDialogFragment {

    private final String successErrorCode = "0";

    @NonNull
    public Dialog onCreateDialog(Bundle paramBundle) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());

        ConstraintLayout mainLayout = requireActivity().findViewById(R.id.dialogChangePassRoot);

        View view = ((LayoutInflater) requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_change_pass, mainLayout, false);
        LinearLayout linearLayout = view.findViewById(R.id.fieldsChangePass);
        ProgressBar progressBar = view.findViewById(R.id.progressBarChangePass);
        EditText editText1 = view.findViewById(R.id.loginEtChangePassDialog);
        EditText editText2 = view.findViewById(R.id.passEtChangePassDialog);
        EditText editText3 = view.findViewById(R.id.newPassEtChangePassDialog);
        EditText editText4 = view.findViewById(R.id.newPassAgainEtChangePassDialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view).setTitle(R.string.change_pass_text)
                .setPositiveButton(R.string.change_btn_title, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((AlertDialog) dialogInterface).getButton(-1).setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View param1View) {

                                String str1 = editText1.getText().toString();
                                String str2 = editText2.getText().toString();
                                String str3 = editText3.getText().toString();
                                String str4 = editText4.getText().toString();

                                if (!(new Regex("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}")).containsMatchIn(str3)) {
                                    new AlertDialog.Builder(ChangePassDialog.this.getContext()).setTitle(R.string.error).setMessage(R.string.simple_password_error_message).setPositiveButton(R.string.ok, null).show();
                                    return;
                                }
                                if (!str3.equals(str4)) {
                                    new AlertDialog.Builder(ChangePassDialog.this.getContext()).setTitle(R.string.error).setMessage(R.string.password_not_equals_error_message).setPositiveButton(R.string.ok, null).show();
                                    return;
                                }

                                //hide keyboard
                                View view = ((AlertDialog) dialogInterface).getCurrentFocus();
                                if (view != null) {
                                    InputMethodManager manager = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                    manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                                }

                                linearLayout.setVisibility(View.GONE);
                                progressBar.setVisibility(View.GONE);

                                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                                httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
                                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                      //  .authenticator(new BasicAuthenticator(str1, str2))
                                        .followRedirects(false)
                                        .addInterceptor(httpLoggingInterceptor)
                                        .readTimeout(60L, TimeUnit.SECONDS)
                                        .connectTimeout(60L, TimeUnit.SECONDS)
                                        .build();
                                Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl("https://sbp.api.skbbank.ru/")
                                        .client(okHttpClient).addConverterFactory(GsonConverterFactory.create())
                                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                        .build();
                                ChangeUserPasswordReq changeUserPasswordReq = new ChangeUserPasswordReq(str1, str2, str3);
                                Disposable disposable = retrofit.create(SbpApi.class).changeUserPassword(changeUserPasswordReq).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<ChangeUserPasswordResp>() {
                                    @Override
                                    public void accept(ChangeUserPasswordResp changeUserPasswordResp) {
                                        linearLayout.setVisibility(View.GONE);
                                        progressBar.setVisibility(View.GONE);

                                        if (changeUserPasswordResp.getErrCode().equals(successErrorCode)) {
                                            new AlertDialog.Builder(getContext()).setTitle(R.string.success_change_pass_title).setMessage(R.string.success_change_pass_message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                                public final void onClick(DialogInterface param1DialogInterface, int param1Int) {

                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                    String str1 = ChangePassDialog.this.getString(R.string.key_pref_login);

                                                    editor.putString(str1, editText2.getText().toString());
                                                    String str2 = ChangePassDialog.this.getString(R.string.key_pref_pass);
                                                    editor.putString(str2, editText1.getText().toString());
                                                    editor.apply();
                                                    dismiss();
                                                    Intent intent = new Intent(getContext(), AuthActivity.class);
                                                    startActivity(intent);
                                                }
                                            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                                                public final void onCancel(DialogInterface param1DialogInterface) {

                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                    String str1 = ChangePassDialog.this.getString(R.string.key_pref_login);
                                                    editor.putString(str1, editText2.getText().toString());
                                                    String str2 = ChangePassDialog.this.getString(R.string.key_pref_pass);
                                                    editor.putString(str2, editText1.getText().toString());
                                                    editor.apply();
                                                    dismiss();
                                                    Intent intent = new Intent(ChangePassDialog.this.getContext(), AuthActivity.class);
                                                    ChangePassDialog.this.startActivity(intent);
                                                }
                                            }).show();
                                        } else {
                                            new AlertDialog.Builder(ChangePassDialog.this.getContext()).setTitle(R.string.error).setMessage(ChangePassDialog.this.getString(R.string.error_message, changeUserPasswordResp.getErrCode(), changeUserPasswordResp.getMessageId())).setPositiveButton(R.string.ok, null).show();
                                        }
                                    }

                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) {

                                        linearLayout.setVisibility(View.GONE);
                                        progressBar.setVisibility(View.GONE);

                                        if (throwable instanceof HttpException && ((HttpException) throwable).code() == 401) {
                                            new AlertDialog.Builder(ChangePassDialog.this.getContext()).setTitle(ChangePassDialog.this.getString(R.string.error_title)).setMessage(ChangePassDialog.this.getString(R.string.error_message, "401", ChangePassDialog.this.getString(R.string.incorrect_login_or_pass_message))).setPositiveButton(ChangePassDialog.this.getString(R.string.ok), null).show();
                                        } else {
                                            new AlertDialog.Builder(ChangePassDialog.this.getContext()).setTitle(ChangePassDialog.this.getString(R.string.error_title)).setMessage(ChangePassDialog.this.getString(R.string.error_message, "-1", throwable.getMessage())).setPositiveButton(ChangePassDialog.this.getString(R.string.ok), null).show();
                                        }
                                    }
                                });

                                ((AlertDialog) dialogInterface).setOnCancelListener(new DialogInterface.OnCancelListener() {
                                    public final void onCancel(DialogInterface param2DialogInterface) {
                                        disposable.dispose();
                                    }
                                });
                            }
                        });

                        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                String str1 = ChangePassDialog.this.getString(R.string.key_pref_login);
                                editor.putString(str1, editText2.getText().toString());
                                String str2 = ChangePassDialog.this.getString(R.string.key_pref_pass);
                                editor.putString(str2, editText1.getText().toString());
                                editor.apply();
                                Intent intent = new Intent(ChangePassDialog.this.getContext(), AuthActivity.class);
                                ChangePassDialog.this.startActivity(intent);
                            }
                        });
                    }
                });

        String str = sharedPreferences.getString(getString(R.string.key_pref_login), "");
        if (str == null || str.length() == 0) {
            editText1.setText(str);
            editText1.setEnabled(false);
            editText1.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorTextSecondary));
        }
        return builder.create();
    }
}


