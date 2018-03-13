package com.enrico.advancedandroid.base;

/**
 * Created by enrico on 3/13/18.
 */

public class TestApplication extends MyApplication {

    @Override
    protected ApplicationComponent initComponent() {
        return DaggerTestApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
