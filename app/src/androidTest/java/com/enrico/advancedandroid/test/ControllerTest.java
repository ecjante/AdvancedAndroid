package com.enrico.advancedandroid.test;

import android.content.Intent;

import com.bluelinelabs.conductor.Controller;
import com.enrico.advancedandroid.data.RepoRepository;
import com.enrico.advancedandroid.data.TestRepoService;
import com.enrico.advancedandroid.home.MainActivity;
import com.enrico.advancedandroid.ui.TestScreenNavigator;

import org.junit.Rule;

/**
 * Created by enrico on 3/13/18.
 */

public abstract class ControllerTest {

    @Rule
    public ControllerTestRule<MainActivity> testRule = new ControllerTestRule<>(MainActivity.class);

    protected TestRepoService repoService = testRule.repoService;
    protected RepoRepository repoRepository = testRule.repoRepository;
    protected TestScreenNavigator screenNavigator = testRule.screenNavigator;

    public ControllerTest() {
        screenNavigator.overrideInitialController(controllerToLaunch());
    }

    protected abstract Controller controllerToLaunch();

    protected void launch() {
        launch(null);
    }

    protected void launch(Intent intent) {
        testRule.launchActivity(intent);
    }
}
