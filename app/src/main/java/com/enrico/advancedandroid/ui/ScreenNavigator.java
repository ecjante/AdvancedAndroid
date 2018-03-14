package com.enrico.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by enrico on 3/6/18.
 */

public interface ScreenNavigator {

    void initWithRouter(Router router, Controller rootScreen);

    boolean pop();

    void goToRepoDetails(String repoOwner, String repoName);

    void clear();
}
