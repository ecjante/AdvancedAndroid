package com.enrico.advancedandroid.base;

import android.app.Application;

import com.enrico.advancedandroid.BuildConfig;
import com.enrico.advancedandroid.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by enrico on 3/6/18.
 */

public class MyApplication extends Application {

    @Inject
    ActivityInjector mActivityInjector;
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mComponent.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }


    public ActivityInjector getActivityInjector() {
        return mActivityInjector;
    }
}
