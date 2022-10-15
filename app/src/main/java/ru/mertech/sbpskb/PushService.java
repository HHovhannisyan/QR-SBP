package ru.mertech.sbpskb;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.preference.PreferenceManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public final class PushService extends FirebaseMessagingService {
  private final String channelId = "sbp_push";

  private final String channelName = "sbp_push";

  public void onMessageReceived(RemoteMessage paramRemoteMessage) {
    RemoteMessage.Notification notification = paramRemoteMessage.getNotification();
    if (notification != null) {
      NotificationManager notificationManager =   (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      if (notificationManager != null) {
        if (Build.VERSION.SDK_INT >= 26) {
          NotificationChannel notificationChannel = new NotificationChannel(this.channelId, this.channelName, NotificationManager.IMPORTANCE_DEFAULT);
          notificationChannel.setDescription("Sbp notifications");
          notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, this.channelId);
        notificationManager.notify(337412494, builder.setContentTitle(notification.getTitle()).setContentText(notification.getBody()).setSmallIcon(R.drawable.ic_qr).setAutoCancel(true).build());
      }
    } 
  }
  
  public void onNewToken(@NonNull String paramString) {
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString(getString(R.string.key_pref_firebase_token), paramString).apply();
  }
}

