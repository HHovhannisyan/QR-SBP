package ru.mertech.sbpskb.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.ui.activities.RefundActivity;

public final class RefundDialog extends AppCompatDialogFragment {

    public static final String OPERATION_ID = "ru.ascintegraciya.sbpskbandroid.transaction_id";

    public static final String REFUND_AMOUNT = "ru.ascintegraciya.sbpskbandroid.refund_amount";


    private final String operationId;

    public RefundDialog(String paramString) {
        this.operationId = paramString;
    }


    @NonNull
    public Dialog onCreateDialog(Bundle paramBundle) {
        LinearLayout mainLayout =  requireActivity().findViewById(R.id.rootViewRefundDialog);

        View view = ((LayoutInflater) requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_refund, mainLayout);
        EditText editText =view.findViewById(R.id.amountRefundEtRefundDialog);
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
                    int i = str1.lastIndexOf('.');
                    if (str1.length() - i > 2) {
                        i = str1.length();
                        editText.setText(str1.substring(i-1, i));
                    }
                }
                if (str1.contains(",")) {
                    int i = str1.lastIndexOf(',');
                    if (str1.length() - 1 - i > 2) {
                        int j = str1.length();
                        editText.setText(str1.substring(j - 1, j));
                    }
                }
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view).setTitle(R.string.refund).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = editText.getText().toString();
                boolean bool = str.equals(".");
                if (!bool) {
                    if (str.length() > 0) {

                        Intent intent = new Intent(RefundDialog.this.getContext(), RefundActivity.class);
                        intent.putExtra(REFUND_AMOUNT, str);
                        intent.putExtra(OPERATION_ID, RefundDialog.this.operationId);
                        RefundDialog.this.startActivity(intent);
                        return;
                    }
                }
                (new AlertDialog.Builder(RefundDialog.this.getContext())).setTitle(R.string.error).setMessage(R.string.amount_is_incorrect_message).setPositiveButton(R.string.ok, null).show();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }
}
