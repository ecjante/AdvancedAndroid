package com.enrico.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.enrico.advancedandroid.details.RepoDetailsComponent;
import com.enrico.advancedandroid.details.RepoDetailsController;
import com.enrico.advancedandroid.di.ControllerKey;
import com.enrico.advancedandroid.trending.TrendingReposComponent;
import com.enrico.advancedandroid.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by enrico on 3/6/18.
 */

@Module(subcomponents = {
        TrendingReposComponent.class,
        RepoDetailsComponent.class
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(RepoDetailsComponent.Builder builder);
}
