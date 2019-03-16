package com.kintopp.pablo.androidmvvmtemplate.di;

import com.kintopp.pablo.androidmvvmtemplate.ui.repolist.RepoListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract RepoListFragment contributeRepoListFragment();
}
