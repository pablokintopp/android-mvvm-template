package com.kintopp.pablo.androidmvvmtemplate.ui.repolist;

import com.kintopp.pablo.androidmvvmtemplate.data.GithubApiService;
import com.kintopp.pablo.androidmvvmtemplate.data.GithubRepoDao;
import com.kintopp.pablo.androidmvvmtemplate.data.GithubRepoRepository;
import com.kintopp.pablo.androidmvvmtemplate.data.Resource;
import com.kintopp.pablo.androidmvvmtemplate.data.model.GithubRepo;
import com.kintopp.pablo.androidmvvmtemplate.ui.base.BaseViewModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class RepoListViewModel extends BaseViewModel {

    private GithubRepoRepository githubRepoRepository;

    private MutableLiveData<Resource<List<GithubRepo>>> results = new MutableLiveData<>();

    public RepoListViewModel(GithubRepoDao repoDao, GithubApiService apiService) {
        this.githubRepoRepository = new GithubRepoRepository(repoDao, apiService);
    }

    public void loadMoreRepositories(Long currentPage) {
        githubRepoRepository.loadPopularRepositories(currentPage)
                .doOnSubscribe(disposable -> addToDisposable(disposable))
                .subscribe(listResource -> getResults().postValue(listResource));
    }


    public MutableLiveData<Resource<List<GithubRepo>>> getResults() {
        return results;
    }
}
