package ru.mertech.sbpskb.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mertech.sbpskb.BasicAuthenticator;
import ru.mertech.sbpskb.R;

public final class AuthDialog extends DialogFragment {

    private final String successErrorCode = "0";

    String login = "202333682792";
    String password = "Aa123456";


    private void createRetrofitClient(String paramString1, String paramString2) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
               // .authenticator(new BasicAuthenticator(paramString1, paramString2))
                .followRedirects(false)
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(60L, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sbp.api.skbbank.ru/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    /*   retrofit.create(DaDataApi.class).getOrgList("Token 6c65d080d0dd898e6d6f43c40ca1d28dfc994844", new GetOrgListReq("ankaaap", 10)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GetOrgListResp>() {
            @Override
            public void accept(GetOrgListResp getOrgListResp)  {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable){
            }
        });*/
    }


    @NonNull
    public Dialog onCreateDialog(Bundle paramBundle) {

        FragmentActivity fragmentActivity1 = getActivity();
        TextView textView;
        EditText editText1, editText2;

        ConstraintLayout mainLayout = Objects.requireNonNull(fragmentActivity1).findViewById(R.id.rootAuthDialog);

        LayoutInflater layoutInflater =
                (LayoutInflater) Objects.requireNonNull(fragmentActivity1).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.dialog_auth, mainLayout, false);

        editText1 = view.findViewById(R.id.loginEtAuthDialog);

        editText2 = view.findViewById(R.id.passEtAuthDialog);

        editText1.setText(login);
        editText2.setText(password);


        ProgressBar progressBar = view.findViewById(R.id.progressBarAuthDialog);
        textView = view.findViewById(R.id.changePassTvAuthDialog);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setTitle(R.string.auth);
        alertDialogBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
                Toast.makeText(getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.setPositiveButton(R.string.login_btn_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                createRetrofitClient(login, password);
                Toast.makeText(getContext(), "Clicked!", Toast.LENGTH_SHORT).show();

                //hide keyboard
                View view = ((AlertDialog) dialogInterface).getCurrentFocus();
                if (view != null) {
                    InputMethodManager manager = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePassDialog changePassDialog = new ChangePassDialog();
                FragmentActivity fragmentActivity = AuthDialog.this.requireActivity();
                changePassDialog.show(fragmentActivity.getSupportFragmentManager(), "dialog");
            }
        });
        return alertDialogBuilder.create();
    }
}
