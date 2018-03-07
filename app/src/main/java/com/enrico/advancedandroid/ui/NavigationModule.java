package com.enrico.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by enrico on 3/6/18.
 */

@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
