package com.enrico.advancedandroid.home;

import com.enrico.advancedandroid.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by enrico on 3/13/18.
 */

@ActivityScope
@Subcomponent(modules = {
        TestScreenBindingModule.class
})
public interface TestMainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
