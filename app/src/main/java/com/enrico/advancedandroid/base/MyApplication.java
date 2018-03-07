package com.enrico.advancedandroid.base;

import android.app.Application;

import com.enrico.advancedandroid.di.ActivityInjector;

import javax.inject.Inject;

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
    }


    public ActivityInjector getActivityInjector() {
        return mActivityInjector;
    }
}
