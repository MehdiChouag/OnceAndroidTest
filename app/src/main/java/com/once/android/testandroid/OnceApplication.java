package com.once.android.testandroid;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import com.once.android.testandroid.di.component.ApplicationComponent;
import com.once.android.testandroid.di.component.DaggerApplicationComponent;
import com.once.android.testandroid.di.module.ApplicationModule;
import com.once.android.testandroid.di.module.NetModule;

/**
 * Created by mehdi on 18/05/2017.
 */
public class OnceApplication extends Application {

  private ApplicationComponent applicationComponent;

  public static OnceApplication get(@NonNull Context context) {
    return (OnceApplication) context;
  }

  @Override public void onCreate() {
    super.onCreate();
    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .netModule(new NetModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
