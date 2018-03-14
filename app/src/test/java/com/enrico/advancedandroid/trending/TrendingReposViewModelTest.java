package com.enrico.advancedandroid.trending;

import com.enrico.advancedandroid.R;
import com.enrico.advancedandroid.data.TrendingReposResponse;
import com.enrico.advancedandroid.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

/**
 * Created by enrico on 3/7/18.
 */
public class TrendingReposViewModelTest {
    private TrendingReposViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new TrendingReposViewModel();
    }

    @Test
    public void loading() throws Exception {
        TestObserver<Boolean> loadingObserver = viewModel.loading().test();
        viewModel.loadingUpdated().accept(true);
        viewModel.loadingUpdated().accept(false);

        loadingObserver.assertValues(true, false);
    }

    @Test
    public void repos() throws Exception {
        TrendingReposResponse response = TestUtils.loadJson("mock/search/get_trending_repos.json", TrendingReposResponse.class);
        viewModel.reposUpdated().accept(response.repos());

        viewModel.repos().test().assertValue(response.repos());
    }

    @Test
    public void error() throws Exception {
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.reposUpdated().accept(Collections.emptyList());

        errorObserver.assertValues(R.string.api_error_repos, -1);
    }

}