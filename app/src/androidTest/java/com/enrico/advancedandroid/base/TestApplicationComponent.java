package com.enrico.advancedandroid.base;

import com.enrico.advancedandroid.data.RepoRepository;
import com.enrico.advancedandroid.data.TestRepoService;
import com.enrico.advancedandroid.data.TestRepoServiceModule;
import com.enrico.advancedandroid.networking.ServiceModule;
import com.enrico.advancedandroid.trending.TrendingReposControllerTest;
import com.enrico.advancedandroid.ui.TestNavigationModule;
import com.enrico.advancedandroid.ui.TestScreenNavigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by enrico on 3/13/18.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        TestNavigationModule.class
})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TrendingReposControllerTest trendingReposControllerTest);

    TestScreenNavigator screenNavigator();

    TestRepoService repoService();

    RepoRepository repoRepository();
}
