package com.enrico.advancedandroid.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by enrico on 3/6/18.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
