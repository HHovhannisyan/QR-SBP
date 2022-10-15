// Generated by view binder compiler. Do not edit!
package ru.mertech.sbpskb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.mertech.sbpskb.R;

public final class DialogFilterBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView dateEndRangeTvDialog;

  @NonNull
  public final TextView dateStartRangeTvDialog;

  @NonNull
  public final LinearLayout dialogDateRangeRoot;

  @NonNull
  public final RadioButton monthRadioDialog;

  @NonNull
  public final RadioGroup selectRangeRGDialog;

  @NonNull
  public final Spinner statusOperationSpnDialog;

  @NonNull
  public final Spinner typeOperationSpnDialog;

  @NonNull
  public final RadioButton userRangeRadioDialog;

  @NonNull
  public final RadioButton weekRadioDialog;

  private DialogFilterBinding(@NonNull LinearLayout rootView,
      @NonNull TextView dateEndRangeTvDialog, @NonNull TextView dateStartRangeTvDialog,
      @NonNull LinearLayout dialogDateRangeRoot, @NonNull RadioButton monthRadioDialog,
      @NonNull RadioGroup selectRangeRGDialog, @NonNull Spinner statusOperationSpnDialog,
      @NonNull Spinner typeOperationSpnDialog, @NonNull RadioButton userRangeRadioDialog,
      @NonNull RadioButton weekRadioDialog) {
    this.rootView = rootView;
    this.dateEndRangeTvDialog = dateEndRangeTvDialog;
    this.dateStartRangeTvDialog = dateStartRangeTvDialog;
    this.dialogDateRangeRoot = dialogDateRangeRoot;
    this.monthRadioDialog = monthRadioDialog;
    this.selectRangeRGDialog = selectRangeRGDialog;
    this.statusOperationSpnDialog = statusOperationSpnDialog;
    this.typeOperationSpnDialog = typeOperationSpnDialog;
    this.userRangeRadioDialog = userRangeRadioDialog;
    this.weekRadioDialog = weekRadioDialog;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogFilterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_filter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogFilterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dateEndRangeTvDialog;
      TextView dateEndRangeTvDialog = ViewBindings.findChildViewById(rootView, id);
      if (dateEndRangeTvDialog == null) {
        break missingId;
      }

      id = R.id.dateStartRangeTvDialog;
      TextView dateStartRangeTvDialog = ViewBindings.findChildViewById(rootView, id);
      if (dateStartRangeTvDialog == null) {
        break missingId;
      }

      LinearLayout dialogDateRangeRoot = (LinearLayout) rootView;

      id = R.id.monthRadioDialog;
      RadioButton monthRadioDialog = ViewBindings.findChildViewById(rootView, id);
      if (monthRadioDialog == null) {
        break missingId;
      }

      id = R.id.selectRangeRGDialog;
      RadioGroup selectRangeRGDialog = ViewBindings.findChildViewById(rootView, id);
      if (selectRangeRGDialog == null) {
        break missingId;
      }

      id = R.id.statusOperationSpnDialog;
      Spinner statusOperationSpnDialog = ViewBindings.findChildViewById(rootView, id);
      if (statusOperationSpnDialog == null) {
        break missingId;
      }

      id = R.id.typeOperationSpnDialog;
      Spinner typeOperationSpnDialog = ViewBindings.findChildViewById(rootView, id);
      if (typeOperationSpnDialog == null) {
        break missingId;
      }

      id = R.id.userRangeRadioDialog;
      RadioButton userRangeRadioDialog = ViewBindings.findChildViewById(rootView, id);
      if (userRangeRadioDialog == null) {
        break missingId;
      }

      id = R.id.weekRadioDialog;
      RadioButton weekRadioDialog = ViewBindings.findChildViewById(rootView, id);
      if (weekRadioDialog == null) {
        break missingId;
      }

      return new DialogFilterBinding((LinearLayout) rootView, dateEndRangeTvDialog,
          dateStartRangeTvDialog, dialogDateRangeRoot, monthRadioDialog, selectRangeRGDialog,
          statusOperationSpnDialog, typeOperationSpnDialog, userRangeRadioDialog, weekRadioDialog);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
