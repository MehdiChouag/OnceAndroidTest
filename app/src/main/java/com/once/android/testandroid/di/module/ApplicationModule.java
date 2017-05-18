package com.once.android.testandroid.di.module;

import android.content.Context;
import com.once.android.testandroid.ListRepository;
import com.once.android.testandroid.ListRepositoryImpl;
import com.once.android.testandroid.OnceApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by mehdi on 18/05/2017.
 */

@Module public class ApplicationModule {
  private final OnceApplication application;

  public ApplicationModule(OnceApplication application) {
    this.application = application;
  }

  @Singleton @Provides public Context provideApplicationContext() {
    return application;
  }

  @Singleton @Provides
  public ListRepository provideListRepository(ListRepositoryImpl listRepository) {
    return listRepository;
  }
}
