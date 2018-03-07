package com.enrico.advancedandroid.model;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.threeten.bp.ZonedDateTime;

/**
 * Created by enrico on 3/6/18.
 */

@AutoValue
public abstract class Repo {

    public abstract long id();

    public abstract String name();

    public abstract String description();

    public abstract User owner();

    @Json(name = "stargazers_count")
    public abstract long stargazersCount();

    @Json(name = "forks_count")
    public abstract long forksCount();

    @Json(name = "contributors_url")
    public abstract String contributorsUrl();

    @Json(name = "created_at")
    public abstract ZonedDateTime createDate();

    @Json(name = "updated_at")
    public abstract ZonedDateTime updatedDate();

    public static JsonAdapter<Repo> jsonAdapter(Moshi moshi) {
        return new AutoValue_Repo.MoshiJsonAdapter(moshi);
    }
}
