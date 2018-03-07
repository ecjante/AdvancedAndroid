package com.enrico.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.enrico.advancedandroid.R;
import com.enrico.advancedandroid.base.BaseActivity;
import com.enrico.advancedandroid.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
