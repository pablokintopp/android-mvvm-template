package com.kintopp.pablo.androidmvvmtemplate.data;

import com.kintopp.pablo.androidmvvmtemplate.data.model.GithubRepo;
import com.kintopp.pablo.androidmvvmtemplate.data.model.SearchGithubRepoApiResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.Observable;

@Singleton
public class GithubRepoRepository {

    private GithubRepoDao githubRepoDao;
    private GithubApiService githubApiService;

    public GithubRepoRepository(GithubRepoDao githubRepoDao, GithubApiService githubApiService) {
        this.githubRepoDao = githubRepoDao;
        this.githubApiService = githubApiService;
    }

    public Observable<Resource<List<GithubRepo>>> loadPopularRepositories(Long page) {
        return new NetworkBoundResource<List<GithubRepo>, SearchGithubRepoApiResponse>() {

            @Override
            protected void saveCallResult(@NonNull SearchGithubRepoApiResponse item) {
                githubRepoDao.insertRepositories(item.items);
            }

            @Override
            protected boolean shouldFetch() {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<List<GithubRepo>> loadFromDb() {

                List<GithubRepo> results = githubRepoDao.getRepositoriesByPage(page);
                if (results == null || results.isEmpty()) {
                    return Flowable.empty();
                }
                return Flowable.just(results);
            }

            @NonNull
            @Override
            protected Observable<Resource<SearchGithubRepoApiResponse>> createCall() {
                return githubApiService.getPopularRepositories(page)
                        .flatMap(searchGithubRepoApiResponse -> Observable.just(
                                searchGithubRepoApiResponse == null
                                        ? Resource.error("", new SearchGithubRepoApiResponse())
                                        : Resource.success(searchGithubRepoApiResponse)));

            }
        }.getAsObservable();
    }

}
