// Generated by view binder compiler. Do not edit!
package ru.mertech.sbpskb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.mertech.sbpskb.R;

public final class ActivityAuthBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button getSbpBtnAuth;

  @NonNull
  public final ImageButton helpBtnAuth;

  @NonNull
  public final Button loginBtnAuth;

  private ActivityAuthBinding(@NonNull ConstraintLayout rootView, @NonNull Button getSbpBtnAuth,
      @NonNull ImageButton helpBtnAuth, @NonNull Button loginBtnAuth) {
    this.rootView = rootView;
    this.getSbpBtnAuth = getSbpBtnAuth;
    this.helpBtnAuth = helpBtnAuth;
    this.loginBtnAuth = loginBtnAuth;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAuthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAuthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_auth, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAuthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.getSbpBtnAuth;
      Button getSbpBtnAuth = ViewBindings.findChildViewById(rootView, id);
      if (getSbpBtnAuth == null) {
        break missingId;
      }

      id = R.id.helpBtnAuth;
      ImageButton helpBtnAuth = ViewBindings.findChildViewById(rootView, id);
      if (helpBtnAuth == null) {
        break missingId;
      }

      id = R.id.loginBtnAuth;
      Button loginBtnAuth = ViewBindings.findChildViewById(rootView, id);
      if (loginBtnAuth == null) {
        break missingId;
      }

      return new ActivityAuthBinding((ConstraintLayout) rootView, getSbpBtnAuth, helpBtnAuth,
          loginBtnAuth);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}