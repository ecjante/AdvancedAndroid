package com.enrico.advancedandroid.data;

import com.enrico.advancedandroid.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by enrico on 3/6/18.
 */

public class RepoRequester {

    private final RepoService mService;

    @Inject
    RepoRequester(RepoService service) {
        mService = service;
    }

    public Single<List<Repo>> getTrendingRepos() {
        return mService.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}
