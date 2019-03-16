package com.kintopp.pablo.androidmvvmtemplate.di;

import com.kintopp.pablo.androidmvvmtemplate.ui.repolist.RepoListViewModel;
import com.kintopp.pablo.androidmvvmtemplate.utils.ViewModelFactory;
import com.kintopp.pablo.androidmvvmtemplate.utils.ViewModelKey;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel.class)
    protected abstract ViewModel githubRepoListviewModel(RepoListViewModel repoListViewModel);


}
