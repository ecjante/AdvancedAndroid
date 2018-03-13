package com.enrico.advancedandroid.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by enrico on 3/13/18.
 */

@Singleton
public class TestRepoService implements RepoService {

    @Inject
    TestRepoService() {

    }

    @Override
    public Single<TrendingReposResponse> getTrendingRepos() {
        return null;
    }
}
