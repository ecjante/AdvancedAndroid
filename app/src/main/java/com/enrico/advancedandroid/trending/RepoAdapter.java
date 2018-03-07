package com.enrico.advancedandroid.trending;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enrico.advancedandroid.R;
import com.enrico.advancedandroid.model.Repo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by enrico on 3/6/18.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private final RepoClickedListener listener;
    private final List<Repo> data = new ArrayList<>();

    RepoAdapter(RepoClickedListener listener) {
        this.listener = listener;
        setHasStableIds(true);
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_repo_list_item, parent, false);
        return new RepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).id();
    }

    void setData(List<Repo> repos) {
        if (repos != null) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new RepoDiffCallback(data, repos));
            data.clear();
            data.addAll(repos);
            diffResult.dispatchUpdatesTo(this);
        } else {
            data.clear();
            notifyDataSetChanged();
        }
    }

    final class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_repo_name)
        TextView repoNameText;
        @BindView(R.id.tv_repo_description)
        TextView repoDescriptionText;
        @BindView(R.id.tv_fork_count)
        TextView forkCountText;
        @BindView(R.id.tv_star_count)
        TextView starCountText;

        private Repo repo;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (repo != null) {
                    listener.onRepoClicked(repo);
                }
            });
        }

        void bind(Repo repo) {
            this.repo = repo;
            repoNameText.setText(repo.name());
            repoDescriptionText.setText(repo.description());
            forkCountText.setText(NumberFormat.getInstance().format(repo.forksCount()));
            starCountText.setText(NumberFormat.getInstance().format(repo.stargazersCount()));
        }
    }

    interface RepoClickedListener {
        void onRepoClicked(Repo repo);
    }
}
