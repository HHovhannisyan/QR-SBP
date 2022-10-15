package ru.mertech.sbpskb.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.TelegramAPI;
import ru.mertech.sbpskb.pojo.telegram.SendMessageResp;

public final class HelpDialog extends AppCompatDialogFragment {

    private final String botToken = "1097886742:AAG49a7EQ76AAYdGBpABwJfXAB1RNaYjTd8";

    private final String chatId = "-1001146408971";
    Disposable disposable;

    @NonNull
    public Dialog onCreateDialog(Bundle paramBundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LinearLayout mainLayout = requireActivity().findViewById(R.id.dialogHelpRoot);

        View view = getLayoutInflater().inflate(R.layout.dialog_help, mainLayout, false);
        EditText editText2 = view.findViewById(R.id.contactPersonEtHelpDialog);
        EditText editText1 = view.findViewById(R.id.phoneNumberEtHelpDialog);
        EditText editText3 = view.findViewById(R.id.commentEtHelpDialog);
        editText1.addTextChangedListener(new PhoneNumberFormattingTextWatcher("RU"));
        builder.setView(view).setPositiveButton(R.string.dialog_send_request_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                editText2.setEnabled(false);
                editText1.setEnabled(false);
                editText3.setEnabled(false);
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
                OkHttpClient okHttpClient = (new OkHttpClient.Builder()).addInterceptor(httpLoggingInterceptor).readTimeout(60L, TimeUnit.SECONDS).connectTimeout(60L, TimeUnit.SECONDS).build();
                Retrofit retrofit = (new Retrofit.Builder()).baseUrl("https://api.telegram.org").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Новая заявка на помощь:\n\n");
                String stringBuilder3 = "Контакт: " +
                        editText2.getText() +
                        '\n';
                stringBuilder1.append(stringBuilder3);
                String stringBuilder4 = "Телефон: " +
                        editText1.getText() +
                        '\n';
                stringBuilder1.append(stringBuilder4);
                String stringBuilder2 = "Комментарий:\n" +
                        editText3.getText() +
                        '\n';
                stringBuilder1.append(stringBuilder2);
                TelegramAPI telegramAPI = retrofit.create(TelegramAPI.class);
                String str1 = stringBuilder1.toString();
                disposable = telegramAPI.sendMessage(HelpDialog.this.botToken, HelpDialog.this.chatId, str1).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<SendMessageResp>() {
                    @Override
                    public void accept(SendMessageResp sendMessageResp) {
                        if (sendMessageResp.getOk()) {
                            //   new AlertDialog.Builder(getActivity()).setTitle(R.string.success_help_dialog).setMessage(R.string.request_accepted_help_dialog_message).setPositiveButton(R.string.ok, null).show();
                            dismiss();
                        } else {
                            new AlertDialog.Builder(getActivity()).setTitle(R.string.error).setMessage(R.string.request_not_accepted_help_dialog_message).setPositiveButton(R.string.ok, null).show();
                            editText2.setEnabled(true);

                            editText1.setEnabled(true);
                            editText3.setEnabled(true);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        (new AlertDialog.Builder(getContext())).setTitle(R.string.error).setMessage(R.string.request_not_accepted_help_dialog_message).setPositiveButton(R.string.ok, null).show();

                        editText2.setEnabled(true);
                        editText2.setEnabled(true);
                        editText3.setEnabled(true);
                    }
                });


                new AlertDialog.Builder(getContext()).setTitle(R.string.error).setMessage(R.string.empty_fields_error_help_dialog_message).setPositiveButton(R.string.ok, null).show();

            }
        }).setNegativeButton(R.string.dialog_cancel_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                disposable.dispose();

            }
        });

        return builder.create();
    }
}
