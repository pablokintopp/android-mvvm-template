package com.kintopp.pablo.androidmvvmtemplate.ui.repolist;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import android.os.Bundle;

import com.kintopp.pablo.androidmvvmtemplate.R;
import com.kintopp.pablo.androidmvvmtemplate.ui.base.BaseActivity;

import javax.inject.Inject;

public class RepoListActivity extends BaseActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
