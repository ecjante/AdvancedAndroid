package com.enrico.advancedandroid.settings;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by enrico on 3/14/18.
 */

@Singleton
public class DebugPreferences {

    private static final String MOCK_RESPONSES_KEY = "mock_response";

    private final SharedPreferences sharedPrefereneces;

    @Inject
    DebugPreferences(Context context) {
        sharedPrefereneces = context.getSharedPreferences("debug_settings", Context.MODE_PRIVATE);
    }

    public boolean useMockResponsesEnabled() {
        return sharedPrefereneces.getBoolean(MOCK_RESPONSES_KEY, false);
    }

    public void setUseMockResponses(boolean useMockResponses) {
        sharedPrefereneces.edit().putBoolean(MOCK_RESPONSES_KEY, useMockResponses).apply();
    }
}
