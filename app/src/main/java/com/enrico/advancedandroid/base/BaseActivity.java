package com.enrico.advancedandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;
import com.enrico.advancedandroid.R;
import com.enrico.advancedandroid.di.Injector;
import com.enrico.advancedandroid.di.ScreenInjector;
import com.enrico.advancedandroid.ui.ActivityViewInterceptor;
import com.enrico.advancedandroid.ui.ScreenNavigator;

import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by enrico on 3/6/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static String INSTANCE_ID_KEY = "instance_id";

    @Inject
    ScreenInjector mScreenInjector;

    @Inject
    ScreenNavigator mScreenNavigator;

    @Inject
    ActivityViewInterceptor activityViewInterceptor;

    private String mInstanceId;
    private Router mRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mInstanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            mInstanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        activityViewInterceptor.setContentView(this, layoutRes());

        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }

        mRouter = Conductor.attachRouter(this, screenContainer, savedInstanceState);
        mScreenNavigator.initWithRouter(mRouter, initialScreen());
        monitorBackStack();

        super.onCreate(savedInstanceState);
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract Controller initialScreen();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, mInstanceId);
    }

    @Override
    public void onBackPressed() {
        if (!mScreenNavigator.pop()) {
            super.onBackPressed();
        }
    }

    public String getInstanceId() {
        return mInstanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScreenNavigator.clear();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
        activityViewInterceptor.clear();
    }

    public ScreenInjector getScreenInjector() {
        return mScreenInjector;
    }

    public void monitorBackStack() {
        mRouter.addChangeListener(new ControllerChangeHandler.ControllerChangeListener() {
            @Override
            public void onChangeStarted(
                    @Nullable Controller to,
                    @Nullable Controller from,
                    boolean isPush,
                    @NonNull ViewGroup container,
                    @NonNull ControllerChangeHandler handler) {

            }

            @Override
            public void onChangeCompleted(
                    @Nullable Controller to,
                    @Nullable Controller from,
                    boolean isPush,
                    @NonNull ViewGroup container,
                    @NonNull ControllerChangeHandler handler) {
                if (!isPush && from != null) {
                    Injector.clearComponent(from);
                }
            }
        });
    }
}
