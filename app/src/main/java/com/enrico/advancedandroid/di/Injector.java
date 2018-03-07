package com.enrico.advancedandroid.di;

import android.app.Activity;

import com.enrico.advancedandroid.base.BaseActivity;

/**
 * Created by enrico on 3/6/18.
 */

public class Injector {

    private Injector() {}

    public static void inject(Activity activity) {
        ActivityInjector.get(activity).inject(activity);
    }


    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }
}
