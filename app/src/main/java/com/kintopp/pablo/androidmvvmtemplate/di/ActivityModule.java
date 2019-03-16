package com.kintopp.pablo.androidmvvmtemplate.di;

import com.kintopp.pablo.androidmvvmtemplate.ui.repolist.RepoListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract RepoListActivity contributeRepoListActivity();

}
