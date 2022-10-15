package ru.mertech.sbpskb.ui.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mertech.sbpskb.BasicAuthenticator;
import ru.mertech.sbpskb.ui.fragments.ChangePassDialog;
import ru.mertech.sbpskb.ui.fragments.PinCodeDialog;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.api.SbpApi;
import ru.mertech.sbpskb.pojo.sbp.GetDataResp;
import ru.mertech.sbpskb.pojo.sbp.Merchant;

public final class LKActivity extends AppCompatActivity {

    private AnimationDrawable addressWaitAnim;

    private AnimationDrawable brandNameWaitAnim;

    private AnimationDrawable idWaitAnim;

    private AnimationDrawable mccWaitAnim;

    private AnimationDrawable nameWaitAnim;

    private AnimationDrawable phoneNumberWaitAnim;

    private SharedPreferences sharedPref;

    private void stopAnimAndHideWaitRectangle() {

        nameWaitAnim.stop();
        nameWaitAnim = null;
        View view6 = findViewById(R.id.nameWaitRectangle);
        view6.setVisibility(View.GONE);
        TextView textView6 = findViewById(R.id.nameTvLk);
        textView6.setVisibility(View.VISIBLE);

        brandNameWaitAnim.stop();
        brandNameWaitAnim = null;
        View view5 = findViewById(R.id.brandNameWaitRectangle);
        view5.setVisibility(View.GONE);
        TextView textView5 = findViewById(R.id.brandNameTvLk);
        textView5.setVisibility(View.GONE);
        mccWaitAnim.stop();
        mccWaitAnim = null;
        View view4 = findViewById(R.id.mccWaitRectangle);
        view4.setVisibility(View.GONE);
        TextView textView4 = findViewById(R.id.mccTvLk);
        textView4.setVisibility(View.GONE);

        phoneNumberWaitAnim.stop();
        phoneNumberWaitAnim = null;
        View view3 = findViewById(R.id.phoneNumberWaitRectangle);
        view3.setVisibility(View.GONE);
        TextView textView3 = findViewById(R.id.phoneNumberTvLk);
        textView3.setVisibility(View.GONE);

        idWaitAnim.stop();
        idWaitAnim = null;
        View view2 = findViewById(R.id.idWaitRectangle);
        view2.setVisibility(View.GONE);
        TextView textView2 = findViewById(R.id.idTvLk);
        textView2.setVisibility(View.GONE);

        addressWaitAnim.stop();
        addressWaitAnim = null;
        View view1 = findViewById(R.id.addressWaitRectangle);
        view1.setVisibility(View.GONE);
        TextView textView1 = findViewById(R.id.addressTvLk);
        textView1.setVisibility(View.VISIBLE);
    }


    public final void changePassOnClick(View paramView) {
        new ChangePassDialog().show(getSupportFragmentManager(), "dialog");
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_lk);
        View view = findViewById(R.id.nameWaitRectangle);
        Drawable drawable = view.getBackground();
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        this.nameWaitAnim = animationDrawable;
        animationDrawable.setEnterFadeDuration(10);

        animationDrawable.setExitFadeDuration(200);

        animationDrawable.start();
        View view1 = findViewById(R.id.brandNameWaitRectangle);
        Drawable drawable1 = view1.getBackground();
        AnimationDrawable animationDrawable1 = (AnimationDrawable) drawable1;
        this.brandNameWaitAnim = animationDrawable1;

        animationDrawable1.setEnterFadeDuration(10);
        animationDrawable1 = this.brandNameWaitAnim;

        animationDrawable1.setExitFadeDuration(200);
        animationDrawable1 = this.brandNameWaitAnim;

        animationDrawable1.start();
        View view2 = findViewById(R.id.mccWaitRectangle);
        Drawable drawable2 = view2.getBackground();
        AnimationDrawable animationDrawable2 = (AnimationDrawable) drawable2;
        this.mccWaitAnim = animationDrawable2;

        animationDrawable2.setEnterFadeDuration(10);
        animationDrawable2 = this.mccWaitAnim;

        animationDrawable2.setExitFadeDuration(200);
        animationDrawable2 = this.mccWaitAnim;

        animationDrawable2.start();
        View view3 = findViewById(R.id.phoneNumberWaitRectangle);
        Drawable drawable3 = view3.getBackground();
        AnimationDrawable animationDrawable3 = (AnimationDrawable) drawable3;
        this.phoneNumberWaitAnim = animationDrawable3;

        animationDrawable3.setEnterFadeDuration(10);
        animationDrawable3 = this.phoneNumberWaitAnim;

        animationDrawable3.setExitFadeDuration(200);
        animationDrawable3 = this.phoneNumberWaitAnim;

        animationDrawable3.start();
        View view4 = findViewById(R.id.idWaitRectangle);
        Drawable drawable4 = view4.getBackground();
        AnimationDrawable animationDrawable4 = (AnimationDrawable) drawable4;
        this.idWaitAnim = animationDrawable4;

        animationDrawable4.setEnterFadeDuration(10);
        animationDrawable4 = this.idWaitAnim;

        animationDrawable4.setExitFadeDuration(200);
        animationDrawable4 = this.idWaitAnim;

        animationDrawable4.start();
        View view5 = findViewById(R.id.addressWaitRectangle);
        Drawable drawable5 = view5.getBackground();
        AnimationDrawable animationDrawable5 = (AnimationDrawable) drawable5;
        this.addressWaitAnim = animationDrawable5;

        animationDrawable5.setEnterFadeDuration(10);
        animationDrawable5 = this.addressWaitAnim;

        animationDrawable5.setExitFadeDuration(200);
        animationDrawable5 = this.addressWaitAnim;

        animationDrawable5.start();
        SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(this);
        this.sharedPref = sharedPreferences1;

        String str2 = sharedPreferences1.getString(getString(R.string.key_pref_pin_code), "");

        sharedPreferences1 = this.sharedPref;

        String str1 = sharedPreferences1.getString(getString(R.string.key_pref_login), "");

        SharedPreferences sharedPreferences2 = this.sharedPref;

        String str3 = sharedPreferences2.getString(getString(R.string.key_pref_pass), "");

        SharedPreferences sharedPreferences3 = this.sharedPref;

        boolean bool = sharedPreferences3.getBoolean(getString(R.string.key_pref_is_first_launch), true);
        SwitchMaterial switch_ = findViewById(R.id.setPinCodeSw);
        switch_.setChecked(str2.equals(""));
        if (bool) {
            SharedPreferences sharedPreferences = this.sharedPref;

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(getString(R.string.key_pref_is_first_launch), false);
            editor.apply();
            AudioManager audioManager = (AudioManager) LKActivity.this.getSystemService(Context.AUDIO_SERVICE);

            new AlertDialog.Builder(this).setTitle(R.string.attention_title).setMessage(R.string.change_temp_pass_message).setPositiveButton(R.string.change_pass_text, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (audioManager != null) {
                        audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK, 0.5F);
                        (new ChangePassDialog()).show(LKActivity.this.getSupportFragmentManager(), "dialog");
                    }
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (audioManager != null) {
                        audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK, 0.5F);
                    }
                }
            }).show();
        }
        TextView textView = findViewById(R.id.loginTvLk);
        textView.setText(str1);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
              //  .authenticator(new BasicAuthenticator(str1, str3))
                .followRedirects(false)
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(60L, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sbp.api.skbbank.ru/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory
                        .create()).build();
        retrofit.create(SbpApi.class).getData().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<GetDataResp>() {
            @Override
            public void accept(GetDataResp getDataResp) {
                LKActivity.this.stopAnimAndHideWaitRectangle();

                List<Merchant> getDataRespMerchants = getDataResp.getMerchants();
                for (Merchant geMerchant : getDataRespMerchants) {
                    TextView textView1 = findViewById(R.id.nameTvLk);
                    textView1.setText(geMerchant.getName());
                    TextView textView2 = findViewById(R.id.brandNameTvLk);
                    textView2.setText(geMerchant.getBrandName());
                    TextView textView3 = findViewById(R.id.mccTvLk);
                    textView3.setText(geMerchant.getMcc());
                    TextView textView4 = findViewById(R.id.phoneNumberTvLk);
                    textView4.setText(geMerchant.getContactPhoneNumber());
                    TextView textView5 = findViewById(R.id.idTvLk);
                    textView5.setText(geMerchant.getId());
                    TextView textView6 = findViewById(R.id.addressTvLk);
                    textView6.setText(getString(R.string.merchant_address, geMerchant.getZip(), geMerchant.getCity(), geMerchant.getAddress()));
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                stopAnimAndHideWaitRectangle();
                if (throwable instanceof HttpException && ((HttpException) throwable).code() == 401) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LKActivity.this).setTitle(getString(R.string.error_title));
                    builder.setMessage(getString(R.string.error_message, "401", getString(R.string.incorrect_login_or_pass_message))).setPositiveButton(getString(R.string.ok), null).show();
                } else {
                    new AlertDialog.Builder(LKActivity.this).setTitle(getString(R.string.error_title)).setMessage(getString(R.string.error_message, "-1", throwable.getMessage())).setPositiveButton(getString(R.string.error_message), null).show();
                }
            }
        });
        (findViewById(R.id.setPinCodeSw)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PinCodeDialog((SwitchMaterial) view).show(getSupportFragmentManager(), "dialog");
            }

        });
    }


    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.menu_lk, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == R.id.actionLogoffLk)
            new AlertDialog.Builder(this).setTitle(R.string.exit_lk_dialog_title).setMessage(R.string.do_you_want_exit_dialog_message).setPositiveButton(R.string.log_off_btn, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences sharedPreferences = LKActivity.this.sharedPref;

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(getString(R.string.key_pref_login), "");
                    editor.putString(getString(R.string.key_pref_pass), "");
                    editor.putString(getString(R.string.key_pref_merchant_id), "");
                    editor.putString(getString(R.string.key_pref_pin_code), "");
                    editor.apply();
                    Intent intent = new Intent(LKActivity.this, AuthActivity.class);
                    LKActivity.this.startActivity(intent);
                    LKActivity.this.finish();
                }
            }).setNegativeButton(R.string.cancel, null).show();
        return super.onOptionsItemSelected(paramMenuItem);
    }

    protected void onPause() {

        if (nameWaitAnim.isRunning()) {
            nameWaitAnim.stop();
        }

        if (brandNameWaitAnim.isRunning()) {
            brandNameWaitAnim.stop();
        }

        if (mccWaitAnim.isRunning()) {
            mccWaitAnim.stop();
        }

        if (phoneNumberWaitAnim.isRunning()) {
            phoneNumberWaitAnim.stop();
        }

        if (idWaitAnim.isRunning()) {
            idWaitAnim.stop();
        }

        if (addressWaitAnim.isRunning()) {
            addressWaitAnim.stop();
        }
        super.onPause();
    }

    protected void onResume() {

        if (!nameWaitAnim.isRunning()) {
            nameWaitAnim.start();
        }

        if (!brandNameWaitAnim.isRunning()) {
            brandNameWaitAnim.start();
        }

        if (!mccWaitAnim.isRunning()) {
            mccWaitAnim.start();
        }

        if (!phoneNumberWaitAnim.isRunning()) {
            phoneNumberWaitAnim.start();
        }

        if (!idWaitAnim.isRunning()) {
            idWaitAnim.start();
        }

        if (!addressWaitAnim.isRunning()) {
            addressWaitAnim.start();
        }
        super.onResume();
    }

    public final void toSalesBtnOnClick(View paramView) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
