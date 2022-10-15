package ru.mertech.sbpskb.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import ru.mertech.sbpskb.ui.fragments.HelpDialog;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.ui.fragments.AuthDialog;

public final class AuthActivity extends AppCompatActivity {

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_auth);
        SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(this);

        String str1 = sharedPreferences1.getString("key_pref_login", "");

        String str2 = sharedPreferences1.getString("key_pref_pass", "");


        if (str1.length() != 0 && str2.length() != 0) {
            startActivity(new Intent(this, LKActivity.class));
            finish();
            return;
        }

        (findViewById(R.id.getSbpBtnAuth)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(AuthActivity.this, PaymentAccountFormActivity.class));
             finish();
            }
        });

        findViewById(R.id.loginBtnAuth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AuthDialog().show(AuthActivity.this.getSupportFragmentManager(), "auth dialog");
            }
        });

        findViewById(R.id.helpBtnAuth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new HelpDialog().show(AuthActivity.this.getSupportFragmentManager(), "help dialog");
            }
        });
    }
}
