package com.once.android.testandroid.di.component;

import com.once.android.testandroid.MainActivity;
import com.once.android.testandroid.di.module.ApplicationModule;
import com.once.android.testandroid.di.module.NetModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by mehdi on 18/05/2017.
 */
@Component(modules = { ApplicationModule.class, NetModule.class }) @Singleton
public interface ApplicationComponent {
  void inject(MainActivity activity);
}
