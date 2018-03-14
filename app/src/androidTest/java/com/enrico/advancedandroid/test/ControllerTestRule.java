package com.enrico.advancedandroid.test;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

import com.enrico.advancedandroid.base.TestApplication;
import com.enrico.advancedandroid.data.RepoRepository;
import com.enrico.advancedandroid.data.TestRepoService;
import com.enrico.advancedandroid.ui.TestScreenNavigator;

/**
 * Created by enrico on 3/13/18.
 */

public class ControllerTestRule<T extends Activity> extends ActivityTestRule<T> {

    public final TestScreenNavigator screenNavigator;
    public final TestRepoService repoService;
    public final RepoRepository repoRepository;

    public ControllerTestRule(Class<T> activityClass) {
        super(activityClass, true, false);
        screenNavigator = TestApplication.getComponent().screenNavigator();
        repoService = TestApplication.getComponent().repoService();
        repoRepository = TestApplication.getComponent().repoRepository();
    }

    public void clearState() {
        repoRepository.clearCache();
    }
}
