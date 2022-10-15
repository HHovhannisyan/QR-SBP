// Generated by view binder compiler. Do not edit!
package ru.mertech.sbpskb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.mertech.sbpskb.R;

public final class FragmentGenerateqrBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText amountEdittxt;

  @NonNull
  public final Button getQRBtn;

  @NonNull
  public final Button pin0Btn;

  @NonNull
  public final Button pin1Btn;

  @NonNull
  public final Button pin2Btn;

  @NonNull
  public final Button pin3Btn;

  @NonNull
  public final Button pin4Btn;

  @NonNull
  public final Button pin5Btn;

  @NonNull
  public final Button pin6Btn;

  @NonNull
  public final Button pin7Btn;

  @NonNull
  public final Button pin8Btn;

  @NonNull
  public final Button pin9Btn;

  @NonNull
  public final Button pinCleanBtn;

  @NonNull
  public final Button pinCommaBtn;

  private FragmentGenerateqrBinding(@NonNull LinearLayout rootView, @NonNull EditText amountEdittxt,
      @NonNull Button getQRBtn, @NonNull Button pin0Btn, @NonNull Button pin1Btn,
      @NonNull Button pin2Btn, @NonNull Button pin3Btn, @NonNull Button pin4Btn,
      @NonNull Button pin5Btn, @NonNull Button pin6Btn, @NonNull Button pin7Btn,
      @NonNull Button pin8Btn, @NonNull Button pin9Btn, @NonNull Button pinCleanBtn,
      @NonNull Button pinCommaBtn) {
    this.rootView = rootView;
    this.amountEdittxt = amountEdittxt;
    this.getQRBtn = getQRBtn;
    this.pin0Btn = pin0Btn;
    this.pin1Btn = pin1Btn;
    this.pin2Btn = pin2Btn;
    this.pin3Btn = pin3Btn;
    this.pin4Btn = pin4Btn;
    this.pin5Btn = pin5Btn;
    this.pin6Btn = pin6Btn;
    this.pin7Btn = pin7Btn;
    this.pin8Btn = pin8Btn;
    this.pin9Btn = pin9Btn;
    this.pinCleanBtn = pinCleanBtn;
    this.pinCommaBtn = pinCommaBtn;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGenerateqrBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGenerateqrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_generateqr, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGenerateqrBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.amount_edittxt;
      EditText amountEdittxt = ViewBindings.findChildViewById(rootView, id);
      if (amountEdittxt == null) {
        break missingId;
      }

      id = R.id.get_q_r_btn;
      Button getQRBtn = ViewBindings.findChildViewById(rootView, id);
      if (getQRBtn == null) {
        break missingId;
      }

      id = R.id.pin0_btn;
      Button pin0Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin0Btn == null) {
        break missingId;
      }

      id = R.id.pin1Btn;
      Button pin1Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin1Btn == null) {
        break missingId;
      }

      id = R.id.pin2Btn;
      Button pin2Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin2Btn == null) {
        break missingId;
      }

      id = R.id.pin3Btn;
      Button pin3Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin3Btn == null) {
        break missingId;
      }

      id = R.id.pin4Btn;
      Button pin4Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin4Btn == null) {
        break missingId;
      }

      id = R.id.pin5Btn;
      Button pin5Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin5Btn == null) {
        break missingId;
      }

      id = R.id.pin6Btn;
      Button pin6Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin6Btn == null) {
        break missingId;
      }

      id = R.id.pin7Btn;
      Button pin7Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin7Btn == null) {
        break missingId;
      }

      id = R.id.pin8Btn;
      Button pin8Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin8Btn == null) {
        break missingId;
      }

      id = R.id.pin9Btn;
      Button pin9Btn = ViewBindings.findChildViewById(rootView, id);
      if (pin9Btn == null) {
        break missingId;
      }

      id = R.id.pin_clean_btn;
      Button pinCleanBtn = ViewBindings.findChildViewById(rootView, id);
      if (pinCleanBtn == null) {
        break missingId;
      }

      id = R.id.pin_comma_btn;
      Button pinCommaBtn = ViewBindings.findChildViewById(rootView, id);
      if (pinCommaBtn == null) {
        break missingId;
      }

      return new FragmentGenerateqrBinding((LinearLayout) rootView, amountEdittxt, getQRBtn,
          pin0Btn, pin1Btn, pin2Btn, pin3Btn, pin4Btn, pin5Btn, pin6Btn, pin7Btn, pin8Btn, pin9Btn,
          pinCleanBtn, pinCommaBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}