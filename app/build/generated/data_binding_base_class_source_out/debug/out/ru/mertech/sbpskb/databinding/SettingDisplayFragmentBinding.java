// Generated by view binder compiler. Do not edit!
package ru.mertech.sbpskb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.mertech.sbpskb.R;

public final class SettingDisplayFragmentBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout connectedDevice;

  @NonNull
  public final TextView connectedDeviceName;

  @NonNull
  public final ImageView disconnectDevice;

  @NonNull
  public final RecyclerView scanResultsRecyclerView;

  private SettingDisplayFragmentBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout connectedDevice, @NonNull TextView connectedDeviceName,
      @NonNull ImageView disconnectDevice, @NonNull RecyclerView scanResultsRecyclerView) {
    this.rootView = rootView;
    this.connectedDevice = connectedDevice;
    this.connectedDeviceName = connectedDeviceName;
    this.disconnectDevice = disconnectDevice;
    this.scanResultsRecyclerView = scanResultsRecyclerView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SettingDisplayFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SettingDisplayFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.setting_display_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SettingDisplayFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.connected_device;
      LinearLayout connectedDevice = ViewBindings.findChildViewById(rootView, id);
      if (connectedDevice == null) {
        break missingId;
      }

      id = R.id.connected_device_name;
      TextView connectedDeviceName = ViewBindings.findChildViewById(rootView, id);
      if (connectedDeviceName == null) {
        break missingId;
      }

      id = R.id.disconnect_device;
      ImageView disconnectDevice = ViewBindings.findChildViewById(rootView, id);
      if (disconnectDevice == null) {
        break missingId;
      }

      id = R.id.scan_results_recycler_view;
      RecyclerView scanResultsRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (scanResultsRecyclerView == null) {
        break missingId;
      }

      return new SettingDisplayFragmentBinding((LinearLayout) rootView, connectedDevice,
          connectedDeviceName, disconnectDevice, scanResultsRecyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}