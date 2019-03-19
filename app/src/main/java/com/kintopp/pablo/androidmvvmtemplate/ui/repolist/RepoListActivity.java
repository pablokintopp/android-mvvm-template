package com.kintopp.pablo.androidmvvmtemplate.ui.repolist;

import androidx.databinding.DataBindingUtil;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.android.AndroidInjection;

import android.os.Bundle;
import android.util.Log;


import com.kintopp.pablo.androidmvvmtemplate.R;
import com.kintopp.pablo.androidmvvmtemplate.data.model.GithubRepo;
import com.kintopp.pablo.androidmvvmtemplate.databinding.RepoListActivityBinding;
import com.kintopp.pablo.androidmvvmtemplate.ui.base.BaseActivity;
import com.kintopp.pablo.androidmvvmtemplate.utils.Animation;
import com.kintopp.pablo.androidmvvmtemplate.utils.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class RepoListActivity extends BaseActivity {

//    @Inject
//    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    ViewModelFactory viewModelFactory;

    private RepoListActivityBinding binding;
    private RepoListViewModel viewModel;


    private RepoListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        initViewModel();
        initView();
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoListViewModel.class);
        viewModel.getResults().observe(this, listResource -> {
            if (listAdapter.getItemCount() == 0) {
                if (!listResource.data.isEmpty()) {
                    animateView(listResource.data);
                } else {
                    Log.d(getTag(), "List resources is not empty!! ");
                    //ToDo show empty container
                }
            } else if (!listResource.data.isEmpty()) {
                displayDataView(listResource.data);
            }
        });
    }

    private void animateView(List<GithubRepo> repositories) {

        Animation.slideView(binding.getRoot(), binding.reposList, listAdapter);
        displayDataView(repositories);
        binding.reposList.scheduleLayoutAnimation();
    }

    private void displayDataView(List<GithubRepo> repositories) {
//        binding.viewEmpty.emptyContainer.setVisibility(View.GONE);
        listAdapter.setItems(repositories);
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repo_list);
        binding.setViewmodel(viewModel);
        listAdapter = new RepoListAdapter();
        binding.reposList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.reposList.setAdapter(listAdapter);
        viewModel.loadMoreRepositories(1l);
//        if ( viewModel.getResults().getValue().data.isEmpty()) {
//            //ToDo Display loader indicator
//            viewModel.loadMoreRepositories(1L);
//        } else animateView(viewModel.getResults().getValue().data);
    }


}
