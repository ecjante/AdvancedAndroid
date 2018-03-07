package com.enrico.advancedandroid.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by enrico on 3/6/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScreenScope {
}
