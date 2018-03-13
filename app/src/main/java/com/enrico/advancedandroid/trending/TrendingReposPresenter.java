package com.enrico.advancedandroid.trending;

import com.enrico.advancedandroid.data.RepoRepository;
import com.enrico.advancedandroid.di.ScreenScope;
import com.enrico.advancedandroid.model.Repo;

import javax.inject.Inject;

/**
 * Created by enrico on 3/6/18.
 */

@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRepository repoRepository;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository repoRepository) {
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        loadRepos();
    }

    private void loadRepos() {
        repoRepository.getTrendingRepos()
        .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
        .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
        .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
