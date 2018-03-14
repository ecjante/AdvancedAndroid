package com.enrico.advancedandroid.details;

import com.enrico.advancedandroid.data.RepoRepository;
import com.enrico.advancedandroid.di.ScreenScope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by enrico on 3/13/18.
 */

@ScreenScope
public class RepoDetailsPresenter {

    @Inject
    RepoDetailsPresenter(
            @Named("repo_owner") String repoOwner,
            @Named("repo_name") String repoName,
            RepoRepository repoRepository,
            RepoDetailsViewModel viewModel) {
        repoRepository.getRepo(repoOwner, repoName)
                .doOnSuccess(viewModel.processRepo())
                .doOnError(viewModel.detailsError())
                .flatMap(repo -> repoRepository.getContributors(repo.contributorsUrl()))
                    .doOnError(viewModel.contributorsError())
                .subscribe(viewModel.processContributors(), throwable -> {
                    // Handled logging in view model
                });
    }
}
