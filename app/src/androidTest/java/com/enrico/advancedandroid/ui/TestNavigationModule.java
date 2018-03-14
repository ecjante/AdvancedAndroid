package com.enrico.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by enrico on 3/13/18.
 */

@Module
public abstract class TestNavigationModule {

    @Binds
    abstract ScreenNavigator bindScreenNavigator(TestScreenNavigator screenNavigator);
}
