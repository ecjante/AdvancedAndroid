package com.enrico.advancedandroid.home;

import com.enrico.advancedandroid.di.ActivityScope;
import com.enrico.advancedandroid.ui.ActivityViewInterceptorModule;
import com.enrico.advancedandroid.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by enrico on 3/6/18.
 */

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
        ActivityViewInterceptorModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjectorBuilder {

    }
}
