package com.enrico.advancedandroid.home;

import com.enrico.advancedandroid.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by enrico on 3/6/18.
 */

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
