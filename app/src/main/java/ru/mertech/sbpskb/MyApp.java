package ru.mertech.sbpskb;

import android.app.Application;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public final class MyApp extends Application {

  public void onCreate() {
    super.onCreate();

    String apiKey = "c7df0fc3-9806-44c7-8ad0-3ceb25530b29";
    YandexMetricaConfig yandexMetricaConfig = YandexMetricaConfig.newConfigBuilder(apiKey).build();
    YandexMetrica.activate(getApplicationContext(), yandexMetricaConfig);
    YandexMetrica.enableActivityAutoTracking(this);

  }
}
