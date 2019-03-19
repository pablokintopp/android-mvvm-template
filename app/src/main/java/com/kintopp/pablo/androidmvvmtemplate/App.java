package com.kintopp.pablo.androidmvvmtemplate;

import android.app.Activity;
import android.app.Application;

import com.kintopp.pablo.androidmvvmtemplate.di.ApiModule;
import com.kintopp.pablo.androidmvvmtemplate.di.DaggerAppComponent;
import com.kintopp.pablo.androidmvvmtemplate.di.DbModule;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .apiModule(new ApiModule())
                .dbModule(new DbModule())
                .build()
                .inject(this);
    }
}
