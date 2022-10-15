package ru.mertech.sbpskb.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.pojo.sbp.Operation;
import ru.mertech.sbpskb.pojo.sbp.OperationType;
import ru.mertech.sbpskb.pojo.sbp.PaymentStatus;
import ru.mertech.sbpskb.pojo.sbp.RefundStatus;

public final class OperationsAdapter extends RecyclerView.Adapter<OperationsAdapter.OperationsViewHolder> {
    private final CallBack callback;

    private final List<Operation> operations;

    public OperationsAdapter(List<Operation> paramList, CallBack paramCallBack) {
        this.operations = paramList;
        this.callback = paramCallBack;
    }

    public int getItemCount() {
        return this.operations.size();
    }

    public void onBindViewHolder(OperationsViewHolder paramOperationsViewHolder, int paramInt) {
        paramOperationsViewHolder.bind(this.operations.get(paramInt));
    }

    @NonNull
    public OperationsViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
        View view = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.item_operations_list, paramViewGroup, false);
        return new OperationsViewHolder(view);
    }

    public interface CallBack {
        void onItemClicked(Operation param1Operation);
    }

    public final class OperationsViewHolder extends RecyclerView.ViewHolder {
        private final TextView amountOperationTv;

        private final TextView operationDateTv;

        private final TextView operationStatusTv;

        private final TextView operationTypeTv;

        private final TextView payerBankNameTv;

        private final TextView payerNameTv;

        public OperationsViewHolder(View param1View) {
            super(param1View);
            operationDateTv = param1View.findViewById(R.id.operationDateTvItem);
            operationTypeTv = param1View.findViewById(R.id.operationTypeTvItem);
            operationStatusTv = param1View.findViewById(R.id.operationStatusTvItem);
            payerNameTv = param1View.findViewById(R.id.payerNameTvItem);
            payerBankNameTv = param1View.findViewById(R.id.payerBankNameTvItem);
            amountOperationTv = param1View.findViewById(R.id.amountOperationTvItem);
        }

        public final void bind(Operation param1Operation) {
            operationDateTv.setText(param1Operation.getDatePayed());
            if (param1Operation.getOperationType().equals(OperationType.PAYMENT.getCode())) {
                operationTypeTv.setText(OperationType.PAYMENT.getLabel());
                if (param1Operation.getStatus().equals(PaymentStatus.REJECTED.getCode())) {
                    operationStatusTv.setText(PaymentStatus.REJECTED.getMessage());
                } else {
                    if (operationStatusTv.getText().toString().equals(PaymentStatus.RECEIVED.getCode())) {
                        operationStatusTv.setText(PaymentStatus.RECEIVED.getMessage());
                    } else if (operationStatusTv.getText().toString().equals(PaymentStatus.ACCEPTED.getCode())) {
                        operationStatusTv.setText(PaymentStatus.ACCEPTED.getMessage());
                    } else if (operationStatusTv.getText().toString().equals(PaymentStatus.NOT_STARTED.getCode())) {
                        operationStatusTv.setText(PaymentStatus.NOT_STARTED.getMessage());
                    }
                }
            } else if (operationStatusTv.getText().toString().equals(OperationType.REFUND.getCode())) {

                operationTypeTv.setText(OperationType.REFUND.getLabel());
                if (param1Operation.getStatus().equals(RefundStatus.REJECTED.getCode())) {
                    operationStatusTv.setText(RefundStatus.REJECTED.getMessage());
                } else if (operationStatusTv.getText().toString().equals(RefundStatus.RECEIVED.getCode())) {
                    operationStatusTv.setText(RefundStatus.RECEIVED.getMessage());
                } else if (operationStatusTv.getText().toString().equals(RefundStatus.ACCEPTED.getCode())) {
                    operationStatusTv.setText(RefundStatus.ACCEPTED.getMessage());
                }
            }
            amountOperationTv.setText(itemView.getContext().getString(R.string.sum_rub, param1Operation.getAmount()));
            payerNameTv.setText(param1Operation.getPam());
            payerBankNameTv.setText(param1Operation.getPayerBankName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() != -1)
                        callback.onItemClicked(param1Operation);
                }
            });
        }
    }
}
