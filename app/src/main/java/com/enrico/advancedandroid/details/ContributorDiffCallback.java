package com.enrico.advancedandroid.details;

import android.support.v7.util.DiffUtil;

import com.enrico.advancedandroid.model.Contributor;

import java.util.List;

/**
 * Created by enrico on 3/13/18.
 */

public class ContributorDiffCallback extends DiffUtil.Callback {

    private final List<Contributor> oldList;
    private final List<Contributor> newList;

    ContributorDiffCallback(List<Contributor> oldList, List<Contributor> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).id() == newList.get(newItemPosition).id();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
