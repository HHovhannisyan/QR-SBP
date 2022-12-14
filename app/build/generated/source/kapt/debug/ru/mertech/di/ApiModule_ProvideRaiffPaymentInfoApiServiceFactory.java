// Generated by Dagger (https://dagger.dev).
package ru.mertech.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;
import ru.mertech.sbpskb.api.RaiffPaymentApi;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideRaiffPaymentInfoApiServiceFactory implements Factory<RaiffPaymentApi> {
  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideRaiffPaymentInfoApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public RaiffPaymentApi get() {
    return provideRaiffPaymentInfoApiService(retrofitProvider.get());
  }

  public static ApiModule_ProvideRaiffPaymentInfoApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideRaiffPaymentInfoApiServiceFactory(retrofitProvider);
  }

  public static RaiffPaymentApi provideRaiffPaymentInfoApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.provideRaiffPaymentInfoApiService(retrofit));
  }
}
