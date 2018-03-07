package com.enrico.advancedandroid.home;

import dagger.android.AndroidInjector;

/**
 * Created by enrico on 3/6/18.
 */

public abstract class AndroidInjectorBuilder extends AndroidInjector.Builder<MainActivity> {

    @Override
    public void seedInstance(MainActivity instance) {

    }
}
