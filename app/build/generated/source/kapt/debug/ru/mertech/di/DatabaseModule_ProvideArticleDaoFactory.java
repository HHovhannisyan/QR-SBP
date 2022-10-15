// Generated by Dagger (https://dagger.dev).
package ru.mertech.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import ru.mertech.sbpskb.db.room.PaymentDAO;
import ru.mertech.sbpskb.db.room.PaymentDB;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DatabaseModule_ProvideArticleDaoFactory implements Factory<PaymentDAO> {
  private final Provider<PaymentDB> dbProvider;

  public DatabaseModule_ProvideArticleDaoFactory(Provider<PaymentDB> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public PaymentDAO get() {
    return provideArticleDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideArticleDaoFactory create(Provider<PaymentDB> dbProvider) {
    return new DatabaseModule_ProvideArticleDaoFactory(dbProvider);
  }

  public static PaymentDAO provideArticleDao(PaymentDB db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideArticleDao(db));
  }
}