package com.enrico.advancedandroid.data;

import dagger.Binds;
import dagger.Module;

/**
 * Created by enrico on 3/13/18.
 */

@Module
public abstract class TestRepoServiceModule {

    @Binds
    abstract RepoService bindRepoService(TestRepoService repoService);
}
