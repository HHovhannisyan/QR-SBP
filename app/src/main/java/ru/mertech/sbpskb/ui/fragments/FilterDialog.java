package ru.mertech.sbpskb.ui.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.pojo.sbp.OperationType;
import ru.mertech.sbpskb.pojo.sbp.PaymentStatus;
import ru.mertech.sbpskb.pojo.sbp.RefundStatus;
import ru.mertech.sbpskb.ui.activities.OperationsListActivity;

public final class FilterDialog extends AppCompatDialogFragment {
    public static final String DATE_END = "ru.ascintegraciya.sbpskbandroid.date_end";

    public static final String DATE_START = "ru.ascintegraciya.sbpskbandroid.date_start";

    public static final String NO_FILTER = "Не фильтровать";

    public static final String STATUS = "ru.ascintegraciya.sbpskbandroid.status";

    public static final String TYPE = "ru.ascintegraciya.sbpskbandroid.type";


    private String dateEnd = "";

    private String dateStart = "";

    private final SimpleDateFormat dfDisplay = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

    private final SimpleDateFormat dfSend = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());


    @NonNull
    public Dialog onCreateDialog(Bundle paramBundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LinearLayout mainLayout = requireActivity().findViewById(R.id.dialogDateRangeRoot);

        View view = getLayoutInflater().inflate(R.layout.dialog_filter, mainLayout, false);
        Spinner spinner1 = view.findViewById(R.id.typeOperationSpnDialog);
        Spinner spinner2 = view.findViewById(R.id.statusOperationSpnDialog);
        RadioGroup radioGroup = view.findViewById(R.id.selectRangeRGDialog);

        TextView textView1 = view.findViewById(R.id.dateStartRangeTvDialog);
        TextView textView2 = view.findViewById(R.id.dateEndRangeTvDialog);
        builder.setTitle(R.string.dialog_date_range_title).setView(view).setPositiveButton(R.string.dialog_ok_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(FilterDialog.this.getContext(), OperationsListActivity.class);
                String strSpinner1 = spinner1.getSelectedItem().toString();

                if (strSpinner1.equals(OperationType.PAYMENT.getLabel())) {
                    intent.putExtra(TYPE, OperationType.PAYMENT.getCode());
                } else if (strSpinner1.equals(OperationType.REFUND.getLabel())) {
                    intent.putExtra(TYPE, OperationType.REFUND.getCode());
                } else if (strSpinner1.equals(NO_FILTER)) {
                    intent.putExtra(TYPE, NO_FILTER);
                }


                if (spinner2.getAdapter() == null) {
                    intent.putExtra(STATUS, NO_FILTER);
                } else {
                    String strSpinner2 = spinner2.getSelectedItem().toString();
                    if (strSpinner2.equals(NO_FILTER)) {
                        intent.putExtra(STATUS, NO_FILTER);
                    } else if (strSpinner2.equals(PaymentStatus.NOT_STARTED.getMessage())) {
                        intent.putExtra(STATUS, PaymentStatus.NOT_STARTED.getCode());
                    } else if (strSpinner2.equals(PaymentStatus.RECEIVED.getMessage())) {
                        intent.putExtra(STATUS, PaymentStatus.RECEIVED.getCode());
                    } else if (strSpinner2.equals(PaymentStatus.REJECTED.getMessage())) {
                        intent.putExtra(STATUS, PaymentStatus.REJECTED.getCode());
                    } else if (strSpinner2.equals(PaymentStatus.ACCEPTED.getMessage())) {
                        intent.putExtra(STATUS, PaymentStatus.ACCEPTED.getCode());
                    } else if (strSpinner2.equals(RefundStatus.RECEIVED.getMessage())) {
                        intent.putExtra(STATUS, RefundStatus.RECEIVED.getCode());
                    } else if (strSpinner2.equals(RefundStatus.REJECTED.getMessage())) {
                        intent.putExtra(STATUS, RefundStatus.REJECTED.getCode());
                    } else if (strSpinner2.equals(RefundStatus.ACCEPTED.getMessage())) {
                        intent.putExtra(STATUS, RefundStatus.ACCEPTED.getCode());
                    }
                }

                Calendar calendar = GregorianCalendar.getInstance();
                TimeZone timeZone = calendar.getTimeZone();
                int timeZoneRawOffset = timeZone.getRawOffset();
                Date date = new Date();
                try {
                    date = FilterDialog.this.dfSend.parse(FilterDialog.this.dateStart);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                long l1 = Objects.requireNonNull(date).getTime();

                Date date1 = new Date();

                try {
                    date1 = FilterDialog.this.dfSend.parse(FilterDialog.this.dateEnd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                long l2 = Objects.requireNonNull(date1).getTime();
                FilterDialog.this.dateStart = FilterDialog.this.dfSend.format(new Date(l1 - timeZoneRawOffset));
                FilterDialog.this.dateEnd = FilterDialog.this.dfSend.format(new Date(l2 - timeZoneRawOffset));
                intent.putExtra(DATE_START, FilterDialog.this.dateStart);
                intent.putExtra(DATE_END, FilterDialog.this.dateEnd);
                FilterDialog.this.startActivity(intent);

                (new AlertDialog.Builder(FilterDialog.this.getContext())).setTitle(FilterDialog.this.getString(R.string.dialog_error_date_title)).setMessage(FilterDialog.this.getString(R.string.dialog_empty_date_error_message)).setPositiveButton(FilterDialog.this.getString(R.string.dialog_ok_btn), null).show();

            }
        }).setNegativeButton(R.string.dialog_cancel_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });


        List<String> arrayList2 = new ArrayList<>();
        arrayList2.add(0, NO_FILTER);
        arrayList2.add(1, OperationType.PAYMENT.getLabel());
        arrayList2.add(2, OperationType.REFUND.getLabel());

        List<String> arrayList1 = new ArrayList<>();
        arrayList1.add(RefundStatus.ACCEPTED.getMessage());
        arrayList1.add(RefundStatus.RECEIVED.getMessage());
        arrayList1.add(RefundStatus.REJECTED.getMessage());
        arrayList1.add(NO_FILTER);


        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(arrayAdapter1);
        spinner2.setAdapter(arrayAdapter2);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.weekRadioDialog) {
                    textView1.setEnabled(false);
                    textView2.setEnabled(false);
                    Calendar calendar = GregorianCalendar.getInstance();
                    calendar.set(7, 2);
                    calendar.set(14, 0);
                    calendar.set(13, 0);
                    calendar.set(12, 0);
                    calendar.set(11, 0);
                    textView1.setText(FilterDialog.this.dfDisplay.format(calendar.getTime()));
                    FilterDialog filterDialog1 = FilterDialog.this;
                    filterDialog1.dateStart = filterDialog1.dfSend.format(calendar.getTime());
                    calendar.set(7, 1);
                    calendar.set(14, 999);
                    calendar.set(13, 59);
                    calendar.set(12, 59);
                    calendar.set(11, 23);
                    textView2.setText(FilterDialog.this.dfDisplay.format(calendar.getTime()));
                    FilterDialog filterDialog2 = FilterDialog.this;
                    filterDialog2.dateEnd = filterDialog2.dfSend.format(calendar.getTime());
                }
                if (i == R.id.userRangeRadioDialog) {
                    textView1.setEnabled(true);
                    textView2.setEnabled(true);
                    textView1.setText("");
                    textView2.setText("");
                    FilterDialog.this.dateStart = "";
                    FilterDialog.this.dateEnd = "";
                }
                if (i == R.id.monthRadioDialog) {
                    textView1.setEnabled(false);
                    textView2.setEnabled(false);
                    Calendar calendar = GregorianCalendar.getInstance();
                    calendar.set(5, calendar.getActualMinimum(5));
                    calendar.set(14, 0);
                    calendar.set(13, 0);
                    calendar.set(12, 0);
                    calendar.set(11, 0);
                    textView1.setText(FilterDialog.this.dfDisplay.format(calendar.getTime()));
                    FilterDialog filterDialog2 = FilterDialog.this;
                    filterDialog2.dateStart = filterDialog2.dfSend.format(calendar.getTime());
                    calendar.set(5, calendar.getActualMaximum(5));
                    calendar.set(14, 999);
                    calendar.set(13, 59);
                    calendar.set(12, 59);
                    calendar.set(11, 23);
                    textView2.setText(FilterDialog.this.dfDisplay.format(calendar.getTime()));
                    FilterDialog filterDialog1 = FilterDialog.this;
                    filterDialog1.dateEnd = filterDialog1.dfSend.format(calendar.getTime());
                }
            }
        });
        radioGroup.check(R.id.weekRadioDialog);
        Calendar calendar = Calendar.getInstance();

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener filterDialog$onCreateDialog$6$onDateSetListener$1 = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        calendar.set(1, i);
                        calendar.set(2, i1);
                        calendar.set(5, i2);


                        if (textView2.getText() != null && calendar.after(dateEnd)) {
                            (new AlertDialog.Builder(FilterDialog.this.getContext())).setTitle(FilterDialog.this.getString(R.string.dialog_error_date_title)).setMessage(FilterDialog.this.getString(R.string.dialog_start_date_error_message)).setPositiveButton(FilterDialog.this.getString(R.string.dialog_ok_btn), null).show();
                        } else {
                            Calendar calendar1 = Calendar.getInstance();
                            calendar1.set(14, 0);
                            calendar1.set(13, 0);
                            calendar1.set(12, 0);
                            calendar1.set(11, 0);

                            textView1.setText(FilterDialog.this.dfDisplay.format(calendar.getTime()));
                            FilterDialog filterDialog = FilterDialog.this;
                            filterDialog.dateStart = FilterDialog.this.dfSend.format(calendar1.getTime());
                        }
                    }
                };
                final Context context = FilterDialog.this.getContext();

                (new DatePickerDialog(context, filterDialog$onCreateDialog$6$onDateSetListener$1, calendar.get(1), calendar.get(2), calendar.get(5))).show();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener filterDialog$onCreateDialog$7$onDateSetListener$1 = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(1, i);
                        calendar.set(2, i1);
                        calendar.set(5, i2);

                        if (textView1.getText() != null && (calendar.after(dateStart))) {
                            (new AlertDialog.Builder(FilterDialog.this.getContext())).setTitle(FilterDialog.this.getString(R.string.dialog_error_date_title)).setMessage(FilterDialog.this.getString(R.string.dialog_end_date_error_message)).setPositiveButton(FilterDialog.this.getString(R.string.dialog_ok_btn), null).show();
                        } else {
                            calendar.set(14, 999);
                            calendar.set(13, 59);
                            calendar.set(12, 59);
                            calendar.set(11, 23);
                            textView1.setText(FilterDialog.this.dfDisplay.format(calendar.getTime()));
                            FilterDialog filterDialog = FilterDialog.this;
                            filterDialog.dateEnd = FilterDialog.this.dfSend.format(calendar.getTime());
                        }
                    }
                };
                Context context = FilterDialog.this.getContext();

                (new DatePickerDialog(context, filterDialog$onCreateDialog$7$onDateSetListener$1, calendar.get(1), calendar.get(2), calendar.get(5))).show();
            }
        });
        return builder.create();
    }

}

