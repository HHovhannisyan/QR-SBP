// Generated by Dagger (https://dagger.dev).
package ru.mertech.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import okhttp3.Interceptor;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("ru.mertech.di.ApiModule.ApiKeyInterceptorOkHttpClient")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvidesApiKeyInterceptorFactory implements Factory<Interceptor> {
  @Override
  public Interceptor get() {
    return providesApiKeyInterceptor();
  }

  public static ApiModule_ProvidesApiKeyInterceptorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Interceptor providesApiKeyInterceptor() {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.providesApiKeyInterceptor());
  }

  private static final class InstanceHolder {
    private static final ApiModule_ProvidesApiKeyInterceptorFactory INSTANCE = new ApiModule_ProvidesApiKeyInterceptorFactory();
  }
}