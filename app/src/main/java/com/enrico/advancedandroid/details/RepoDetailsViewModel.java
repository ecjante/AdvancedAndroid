package com.enrico.advancedandroid.details;

import com.enrico.advancedandroid.R;
import com.enrico.advancedandroid.di.ScreenScope;
import com.enrico.advancedandroid.model.Contributor;
import com.enrico.advancedandroid.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by enrico on 3/13/18.
 */

@ScreenScope
public class RepoDetailsViewModel {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    private final BehaviorRelay<RepoDetailsState> detailsStateRelay = BehaviorRelay.create();
    private final BehaviorRelay<ContributorState> contributorStateRelay = BehaviorRelay.create();

    @Inject
    RepoDetailsViewModel() {
        detailsStateRelay.accept(RepoDetailsState.builder().loading(true).build());
        contributorStateRelay.accept(ContributorState.builder().loading(true).build());
    }

    Observable<RepoDetailsState> details() {
        return detailsStateRelay;
    }

    Observable<ContributorState> contributors() {
        return contributorStateRelay;
    }

    Consumer<Repo> processRepo() {
        return repo -> detailsStateRelay.accept(
                RepoDetailsState.builder()
                        .loading(false)
                        .name(repo.name())
                        .description(repo.description())
                        .createdDate(repo.createDate().format(DATE_FORMATTER))
                        .updatedDate(repo.updatedDate().format(DATE_FORMATTER))
                        .build()
        );
    }

    Consumer<List<Contributor>> processContributors() {
        return contributors -> contributorStateRelay.accept(
                ContributorState.builder()
                        .loading(false)
                        .contributors(contributors)
                        .build()
        );
    }

    Consumer<Throwable> detailsError() {
        return throwable -> {
            Timber.e(throwable, "Error loading repo details");
            detailsStateRelay.accept(
                    RepoDetailsState.builder()
                            .loading(false)
                            .errorRes(R.string.api_error_single_repo)
                            .build()
            );
        };
    }

    Consumer<Throwable> contributorsError() {
        return throwable -> {
            Timber.e(throwable, "Error loading repo contributors");
            contributorStateRelay.accept(
                    ContributorState.builder()
                            .loading(false)
                            .errorRes(R.string.api_error_contributors)
                            .build()
            );
        };
    }
}
