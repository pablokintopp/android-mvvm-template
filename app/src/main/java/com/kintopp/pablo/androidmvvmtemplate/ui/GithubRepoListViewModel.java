package com.kintopp.pablo.androidmvvmtemplate.ui;

import com.kintopp.pablo.androidmvvmtemplate.data.GithubApiService;
import com.kintopp.pablo.androidmvvmtemplate.data.GithubRepoDao;
import com.kintopp.pablo.androidmvvmtemplate.data.GithubRepoRepository;
import com.kintopp.pablo.androidmvvmtemplate.data.Resource;
import com.kintopp.pablo.androidmvvmtemplate.data.model.GithubRepo;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class GithubRepoListViewModel extends BaseViewModel {

    private GithubRepoRepository githubRepoRepository;

    private MutableLiveData<Resource<List<GithubRepo>>> results = new MutableLiveData<>();

    public GithubRepoListViewModel(GithubRepoDao repoDao, GithubApiService apiService) {
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
