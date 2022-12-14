// Generated by Dagger (https://dagger.dev).
package ru.mertech.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;
import ru.mertech.sbpskb.api.TinkoffPaymentApi;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideTinkoffPaymentInfoApiServiceFactory implements Factory<TinkoffPaymentApi> {
  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideTinkoffPaymentInfoApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public TinkoffPaymentApi get() {
    return provideTinkoffPaymentInfoApiService(retrofitProvider.get());
  }

  public static ApiModule_ProvideTinkoffPaymentInfoApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideTinkoffPaymentInfoApiServiceFactory(retrofitProvider);
  }

  public static TinkoffPaymentApi provideTinkoffPaymentInfoApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.provideTinkoffPaymentInfoApiService(retrofit));
  }
}
