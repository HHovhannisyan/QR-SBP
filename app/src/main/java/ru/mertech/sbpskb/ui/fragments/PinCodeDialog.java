package ru.mertech.sbpskb.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.switchmaterial.SwitchMaterial;

import kotlin.text.Regex;
import ru.mertech.sbpskb.R;

public final class PinCodeDialog extends AppCompatDialogFragment {

    private final SwitchMaterial setPinCodeSw;

    public PinCodeDialog(SwitchMaterial paramSwitch) {
        this.setPinCodeSw = paramSwitch;
    }


    public void onCancel(@NonNull DialogInterface paramDialogInterface) {
        SwitchMaterial switch_ = this.setPinCodeSw;
        switch_.setChecked(!switch_.isChecked());
        super.onCancel(paramDialogInterface);
    }

    @NonNull
    public Dialog onCreateDialog(Bundle paramBundle) {
        LayoutInflater layoutInflater = (LayoutInflater) requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout mainLayout =  requireActivity().findViewById(R.id.setPinCodeDialogRoot);

        View view = layoutInflater.inflate(R.layout.dialog_pin_code, mainLayout, false);
        TextView textView1 = view.findViewById(R.id.pinCodeTvDialog);
        EditText editText1 =  view.findViewById(R.id.pinCodeEtDialog);
        TextView textView2 =  view.findViewById(R.id.newPinCodeTvDialog);
        EditText editText2 =  view.findViewById(R.id.newPinCodeEtDialog);
        TextView textView3 =  view.findViewById(R.id.newPinCodeAgainTvDialog);
        EditText editText3 =  view.findViewById(R.id.newPinCodeAgainEtDialog);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String str = sharedPreferences.getString(getString(R.string.key_pref_pin_code), "");
        if (this.setPinCodeSw.isChecked()) {
            textView2.setVisibility(View.VISIBLE);
            editText2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            editText3.setVisibility(View.VISIBLE);
        } else {
            editText1.setVisibility(View.VISIBLE);
            textView1.setVisibility(View.VISIBLE);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view).setTitle(R.string.pin_code_title).setPositiveButton(R.string.change_btn_title, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (PinCodeDialog.this.setPinCodeSw.isChecked()) {
                    Regex regex = new Regex("^\\d{4}$");
                    String str = editText2.getText().toString();
                    if (str.equals(editText3.getText().toString())) {
                        if (regex.matches(editText3.getText().toString())) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            String str1 = PinCodeDialog.this.getString(R.string.key_pref_pin_code);
                            editor.putString(str1, editText2.getText().toString());
                            editor.apply();
                            (new AlertDialog.Builder(PinCodeDialog.this.getContext())).setTitle(R.string.success_set_pin_code_title).setMessage(R.string.success_set_pin_code_message).setPositiveButton(R.string.success_set_pin_code_message, null).show();
                            return;
                        }
                    }
                    (new AlertDialog.Builder(PinCodeDialog.this.getContext())).setTitle(R.string.error_title).setMessage(R.string.error_set_pin_code_message).setPositiveButton(R.string.dialog_ok_btn, null).show();
                    PinCodeDialog.this.setPinCodeSw.setChecked(!PinCodeDialog.this.setPinCodeSw.isChecked());
                } else {
                    if (editText2.getText().toString().equals(editText3.getText().toString())) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(PinCodeDialog.this.getString(R.string.key_pref_pin_code), "");
                        editor.apply();
                        (new AlertDialog.Builder(PinCodeDialog.this.getContext())).setTitle(R.string.success_disable_lock_screen_title).setMessage(R.string.success_disable_lock_screen_message).setPositiveButton(R.string.dialog_ok_btn, null).show();
                    } else {
                        (new AlertDialog.Builder(PinCodeDialog.this.getContext())).setTitle(R.string.error_title).setMessage(R.string.error_disable_lock_screen_message).setPositiveButton(R.string.dialog_ok_btn, null).show();
                        PinCodeDialog.this.setPinCodeSw.setChecked(!PinCodeDialog.this.setPinCodeSw.isChecked());
                    }
                }
            }
        }).setNegativeButton(R.string.dialog_cancel_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PinCodeDialog.this.setPinCodeSw.setChecked(!PinCodeDialog.this.setPinCodeSw.isChecked());
            }
        });
        return  builder.create();

    }


}

