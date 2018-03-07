package com.enrico.advancedandroid.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.enrico.advancedandroid.di.Injector;

/**
 * Created by enrico on 3/6/18.
 */

public abstract class BaseController extends Controller {

    private boolean mInjected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        if (!mInjected) {
            Injector.inject(this);
            mInjected = true;
        }
        super.onContextAvailable(context);
    }
}
