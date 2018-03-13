package com.enrico.advancedandroid.data;

import com.enrico.advancedandroid.model.Repo;
import com.enrico.advancedandroid.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by enrico on 3/13/18.
 */
public class RepoRepositoryTest {

    @Mock Provider<RepoRequester> repoRequesterProvider;
    @Mock RepoRequester repoRequester;

    private RepoRepository repository;
    private TrendingReposResponse trendingReposReponse;
    private Repo rxJavaRepo;
    private Repo otherRepo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(repoRequesterProvider.get()).thenReturn(repoRequester);

        trendingReposReponse = TestUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(trendingReposReponse.repos()));

        rxJavaRepo = trendingReposReponse.repos().get(0);
        otherRepo = trendingReposReponse.repos().get(1);
        repository = new RepoRepository(repoRequesterProvider);
    }

    @Test
    public void getTrendingRepos() throws Exception {
        repository.getTrendingRepos().test().assertValue(trendingReposReponse.repos());

        List<Repo> modifiedList = new ArrayList<>(trendingReposReponse.repos());
        modifiedList.remove(0);
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(modifiedList));

        repository.getTrendingRepos().test().assertValue(trendingReposReponse.repos());
    }

    @Test
    public void getRepo() throws Exception {
        repository.getTrendingRepos().subscribe();

        when(repoRequester.getRepo(anyString(), anyString())).thenReturn(Single.just(otherRepo));

        repository.getRepo("ReactiveX", "RxJava").test().assertValue(rxJavaRepo);

        repository.getRepo("NotInCache", "NotInCache").test().assertValue(otherRepo);
    }

}