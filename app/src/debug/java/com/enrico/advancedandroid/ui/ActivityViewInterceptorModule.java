package com.enrico.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by enrico on 3/14/18.
 */

@Module
public abstract class ActivityViewInterceptorModule {

    @Binds
    abstract ActivityViewInterceptor bindDebugActivityViewInterceptor(DebugActivityViewInterceptor activityViewInterceptor);
}
