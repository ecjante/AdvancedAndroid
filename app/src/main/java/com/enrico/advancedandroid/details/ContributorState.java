package com.enrico.advancedandroid.details;

import android.support.annotation.Nullable;

import com.enrico.advancedandroid.model.Contributor;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by enrico on 3/13/18.
 */

@AutoValue
public abstract class ContributorState {

    abstract boolean loading();

    @Nullable
    abstract List<Contributor> contributors();

    @Nullable
    abstract Integer errorRes();

    static Builder builder() {
        return new AutoValue_ContributorState.Builder();
    }

    boolean isSuccess() {
        return errorRes() == null;
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder loading(boolean loading);

        abstract Builder contributors(List<Contributor> contributors);

        abstract Builder errorRes(Integer errorRes);

        abstract ContributorState build();
    }
}
