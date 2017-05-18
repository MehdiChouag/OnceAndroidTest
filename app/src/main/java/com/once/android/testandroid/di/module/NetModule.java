package com.once.android.testandroid.di.module;

import android.content.Context;
import com.once.android.testandroid.ListService;
import com.once.android.testandroid.OnceApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by mehdi on 18/05/2017.
 */
@Module public class NetModule {

  private final OnceApplication application;

  public NetModule(OnceApplication application) {
    this.application = application;
  }

  @Singleton @Provides public OkHttpClient provideOkHttpClient(Context context) {
    int cacheSize = 10 * 1024 * 1024;
    final Cache cache = new Cache(context.getCacheDir(), cacheSize);
    return new OkHttpClient.Builder().cache(cache).build();
  }

  @Singleton @Provides public Retrofit provideRetrofit(OkHttpClient client) {
    return new Retrofit.Builder().baseUrl("https://api.myjson.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(JacksonConverterFactory.create())
        .build();
  }

  @Singleton @Provides public ListService provideListService(Retrofit retrofit) {
    return retrofit.create(ListService.class);
  }
}
