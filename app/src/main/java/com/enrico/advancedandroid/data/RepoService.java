package com.enrico.advancedandroid.data;

import com.enrico.advancedandroid.model.Repo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by enrico on 3/6/18.
 */

public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();

    @GET("repos/{owner}/{name}")
    Single<Repo> getRepo(@Path("owner") String repoOwner, @Path("name") String repoName);
}
