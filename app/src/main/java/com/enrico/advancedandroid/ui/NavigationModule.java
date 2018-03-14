package com.enrico.advancedandroid.ui;

import com.enrico.advancedandroid.di.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * Created by enrico on 3/6/18.
 */

@Module
public abstract class NavigationModule {

    @Binds
    @ActivityScope
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
