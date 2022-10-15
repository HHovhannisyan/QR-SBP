package ru.mertech.sbpskb.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.ui.activities.AuthActivity;
import ru.mertech.sbpskb.ui.activities.PaymentActivity;
import ru.mertech.sbpskb.ui.fragments.FilterDialog;


public class StartActivity extends AppCompatActivity {
    public static final String AMOUNT = "amount";
    EditText editText;

    public final void getQrBtnOnClick(View paramView) {
       // editText = findViewById(R.id.amountEt);

        Intent intent = new Intent(this, PaymentActivity.class);

        intent.putExtra(AMOUNT, editText.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


   /*     editText =findViewById(R.id.amountEt);
        editText.requestFocus();
        getWindow().setSoftInputMode(4);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str1 = String.valueOf(editable);
                if (str1.contains(".")) {
                    int i = str1.indexOf( '.');
                    if (str1.length() - i > 2) {
                        EditText editText =  findViewById(R.id.amountEt);
                        int j = str1.length();
                        editText.setText(str1.substring( j - 1, j));
                    }
                }
                if (str1.contains(",")) {
                    int i = str1.indexOf( ',');
                    if (str1.length() - 1 - i > 2) {
                        EditText editText =  findViewById(R.id.amountEt);
                        int j = str1.length();
                        editText.setText(str1.substring(j - 1, j));
                    }
                }
            }
        });*/
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.menu_main, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        int i = paramMenuItem.getItemId();
        if (i == R.id.actionLk) {

            new FilterDialog().show(getSupportFragmentManager(), "dialog");
        }

        if (i == R.id.actionPaymentsList) {
            startActivity(new Intent(this, AuthActivity.class));
        }

        return super.onOptionsItemSelected(paramMenuItem);
    }
}