package com.enrico.advancedandroid.data;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by enrico on 3/6/18.
 */

public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();
}
