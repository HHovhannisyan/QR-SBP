package ru.mertech.sbpskb.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.ui.fragments.RefundDialog;
import ru.mertech.sbpskb.pojo.sbp.OperationType;
import ru.mertech.sbpskb.pojo.sbp.PaymentStatus;
import ru.mertech.sbpskb.pojo.sbp.RefundStatus;

public final class OperationActivity extends AppCompatActivity {

    private String amount = "";

    private String operationId = "";

    private boolean refundActionVisibility;

    private boolean repeatActionVisibility;


    protected void onCreate(Bundle paramBundle) {
        TextView textView2;
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_operation);
        TextView textView3 = findViewById(R.id.statusOperationTvOperation);
        textView2 =  findViewById(R.id.typeOperationTvOperation);

        String str2 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.type_operation");
        String str3 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.status_operation");
        String str4 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.payer_name");
        String str5 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.payer_bank_id");
        String str6 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.payer_bank_name");
        this.amount = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.amount");
        String str1 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.commission");
        String str7 = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.operation_date");
        this.operationId = getIntent().getStringExtra("ru.ascintegraciya.sbpskbandroid.operation_id");
        if (str2.equals(OperationType.PAYMENT.getCode())) {
            textView2.setText(OperationType.PAYMENT.getLabel());
            if (str3.equals(PaymentStatus.REJECTED.getCode())) {
                textView3.setText(PaymentStatus.REJECTED.getMessage());
                this.repeatActionVisibility = true;
            } else if (textView3.getText().toString().equals(PaymentStatus.RECEIVED.getCode())) {
                textView3.setText(PaymentStatus.RECEIVED.getMessage());
            } else if (textView3.getText().toString().equals(PaymentStatus.ACCEPTED.getCode())) {
                textView3.setText(PaymentStatus.ACCEPTED.getMessage());
                this.refundActionVisibility = true;
                this.repeatActionVisibility = true;
            } else if (textView3.getText().toString().equals(PaymentStatus.NOT_STARTED.getCode())) {
                textView3.setText(PaymentStatus.NOT_STARTED.getMessage());
            }
        } else if (textView2.getText().toString().equals( OperationType.REFUND.getCode())) {
            textView2.setText(OperationType.REFUND.getLabel());
            if (textView3.getText().toString().equals(RefundStatus.REJECTED.getCode())) {
                textView3.setText(RefundStatus.REJECTED.getMessage());
            } else if (textView3.getText().toString().equals(RefundStatus.RECEIVED.getCode())) {
                textView3.setText(RefundStatus.RECEIVED.getMessage());
            } else if (textView3.getText().toString().equals(RefundStatus.ACCEPTED.getCode())) {
                textView3.setText(RefundStatus.ACCEPTED.getMessage());
            }
        }
        TextView textView8 = findViewById(R.id.operationDateTvOperation);
        textView8.setText(str7);
        TextView textView7 = findViewById(R.id.payerNameTvOperation);
        textView7.setText(str4);
        TextView textView4 =  findViewById(R.id.payerBankIdTvOperation);
        textView4.setText(str5);
        TextView textView5 = findViewById(R.id.payerBankNameTvOperation);
        textView5.setText(str6);
        TextView textView6 = findViewById(R.id.amountTvOperation);
        textView6.setText(getString(R.string.amount_operation, this.amount));
        textView6 = findViewById(R.id.commissionTvOperation);
        textView6.setText(getString(R.string.commission, str1));
        TextView textView1 =  findViewById(R.id.operationIdTvOperation);
        textView1.setText(this.operationId);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.menu_operation, paramMenu);
        if (paramMenu != null) {
            MenuItem menuItem = paramMenu.findItem(R.id.actionRefund);
            if (menuItem != null)
                menuItem.setVisible(this.refundActionVisibility);
        }
        if (paramMenu != null) {
            MenuItem menuItem = paramMenu.findItem(R.id.actionRepeat);
            if (menuItem != null)
                menuItem.setVisible(this.repeatActionVisibility);
        }
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if(paramMenuItem.getItemId()==R.id.actionRepeat){
           Intent intent = new Intent( this, PaymentActivity.class);
            if (amount != null) {
                intent.putExtra("ru.ascintegraciya.sbpskbandroid.amount", amount);
                startActivity(intent);
                finish();
            }
        }

        if(paramMenuItem.getItemId()==R.id.actionRepeat) {
            if (operationId != null)
                (new RefundDialog(operationId)).show(getSupportFragmentManager(), "dialog");
        }



        return super.onOptionsItemSelected(paramMenuItem);
    }

    public final void toOperationsListBtnOnClick(View paramView) {
        onBackPressed();
        finish();
    }
}

