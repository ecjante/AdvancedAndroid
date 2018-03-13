package com.enrico.advancedandroid.base;

import android.app.Activity;

import com.enrico.advancedandroid.home.MainActivity;
import com.enrico.advancedandroid.home.TestMainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by enrico on 3/13/18.
 */

@Module(subcomponents = {
        TestMainActivityComponent.class
})
public abstract class TestActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjector(TestMainActivityComponent.Builder builder);
}
