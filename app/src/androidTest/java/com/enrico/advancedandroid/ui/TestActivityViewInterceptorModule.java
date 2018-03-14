package com.enrico.advancedandroid.ui;

import dagger.Module;
import dagger.Provides;

/**
 * Created by enrico on 3/14/18.
 */

@Module
public class TestActivityViewInterceptorModule {

    @Provides
    static ActivityViewInterceptor provideActivityViewInterceptor() {
        return ActivityViewInterceptor.DEFAULT;
    }
}
