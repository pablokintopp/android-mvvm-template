package com.kintopp.pablo.androidmvvmtemplate.data;

import com.kintopp.pablo.androidmvvmtemplate.data.model.SearchGithubRepoApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubApiService {

    @GET("search/repositories?q=stars:>0")
    Observable<SearchGithubRepoApiResponse> getPopularRepositories(@Query("page") Long page);

    @GET("search/repositories")
    Observable<SearchGithubRepoApiResponse> searchRepositories(@Query("q") String query);
}
