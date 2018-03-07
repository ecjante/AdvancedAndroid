package com.enrico.advancedandroid.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by enrico on 3/6/18.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Context provideApplicationContext() {
        return mApplication;
    }
}
