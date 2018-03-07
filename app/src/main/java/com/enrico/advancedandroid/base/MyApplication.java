package com.enrico.advancedandroid.base;

import android.app.Application;

/**
 * Created by enrico on 3/6/18.
 */

public class MyApplication extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }
}
