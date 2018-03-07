package com.enrico.advancedandroid.base;

import com.enrico.advancedandroid.data.RepoServiceModule;
import com.enrico.advancedandroid.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by enrico on 3/6/18.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
