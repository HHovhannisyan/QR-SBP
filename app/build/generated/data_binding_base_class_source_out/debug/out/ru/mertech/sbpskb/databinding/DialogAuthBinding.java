// Generated by view binder compiler. Do not edit!
package ru.mertech.sbpskb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.mertech.sbpskb.R;

public final class DialogAuthBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView changePassTvAuthDialog;

  @NonNull
  public final EditText loginEtAuthDialog;

  @NonNull
  public final EditText passEtAuthDialog;

  @NonNull
  public final ProgressBar progressBarAuthDialog;

  @NonNull
  public final ConstraintLayout rootAuthDialog;

  private DialogAuthBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView changePassTvAuthDialog, @NonNull EditText loginEtAuthDialog,
      @NonNull EditText passEtAuthDialog, @NonNull ProgressBar progressBarAuthDialog,
      @NonNull ConstraintLayout rootAuthDialog) {
    this.rootView = rootView;
    this.changePassTvAuthDialog = changePassTvAuthDialog;
    this.loginEtAuthDialog = loginEtAuthDialog;
    this.passEtAuthDialog = passEtAuthDialog;
    this.progressBarAuthDialog = progressBarAuthDialog;
    this.rootAuthDialog = rootAuthDialog;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogAuthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogAuthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_auth, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogAuthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.changePassTvAuthDialog;
      TextView changePassTvAuthDialog = ViewBindings.findChildViewById(rootView, id);
      if (changePassTvAuthDialog == null) {
        break missingId;
      }

      id = R.id.loginEtAuthDialog;
      EditText loginEtAuthDialog = ViewBindings.findChildViewById(rootView, id);
      if (loginEtAuthDialog == null) {
        break missingId;
      }

      id = R.id.passEtAuthDialog;
      EditText passEtAuthDialog = ViewBindings.findChildViewById(rootView, id);
      if (passEtAuthDialog == null) {
        break missingId;
      }

      id = R.id.progressBarAuthDialog;
      ProgressBar progressBarAuthDialog = ViewBindings.findChildViewById(rootView, id);
      if (progressBarAuthDialog == null) {
        break missingId;
      }

      ConstraintLayout rootAuthDialog = (ConstraintLayout) rootView;

      return new DialogAuthBinding((ConstraintLayout) rootView, changePassTvAuthDialog,
          loginEtAuthDialog, passEtAuthDialog, progressBarAuthDialog, rootAuthDialog);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
