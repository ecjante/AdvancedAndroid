package com.enrico.advancedandroid.trending;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.enrico.advancedandroid.R;
import com.enrico.advancedandroid.base.BaseController;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by enrico on 3/6/18.
 */

public class TrendingReposController extends BaseController {

    @Inject
    TrendingReposPresenter presenter;
    @Inject
    TrendingReposViewModel viewModel;

    @BindView(R.id.repo_list)
    RecyclerView repoList;
    @BindView(R.id.loading_indicator)
    ProgressBar loadingIndicator;
    @BindView(R.id.tv_error)
    TextView errorText;

    @Override
    protected void onViewBound(View view) {
        repoList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        repoList.setAdapter(new RepoAdapter(presenter));
    }

    @Override
    protected Disposable[] subscriptions() {
        return new Disposable[] {
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(loading -> {
                            loadingIndicator.setVisibility(loading ? View.VISIBLE : View.GONE);
                            repoList.setVisibility(loading ? View.GONE : View.VISIBLE);
                            errorText.setVisibility(loading ? View.GONE : errorText.getVisibility());
                }),
                viewModel.repos()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(((RepoAdapter) repoList.getAdapter())::setData),
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(errorRes -> {
                            if (errorRes == -1) {
                                errorText.setText(null);
                                errorText.setVisibility(View.GONE);
                            } else {
                                errorText.setVisibility(View.VISIBLE);
                                repoList.setVisibility(View.GONE);
                                errorText.setText(errorRes);
                            }
                })
        };
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_trending_repos;
    }
}
