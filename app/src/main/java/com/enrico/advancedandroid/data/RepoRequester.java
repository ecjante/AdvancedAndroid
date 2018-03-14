package com.enrico.advancedandroid.data;

import com.enrico.advancedandroid.model.Contributor;
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

    Single<List<Repo>> getTrendingRepos() {
        return mService.getTrendingRepos()
                .map(TrendingReposResponse::repos);
    }

    Single<Repo> getRepo(String repoOwner, String repoName) {
        return mService.getRepo(repoOwner, repoName);
    }

    Single<List<Contributor>> getContributors(String url) {
        return mService.getContributors(url);
    }
}
