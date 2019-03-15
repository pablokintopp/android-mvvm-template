package com.kintopp.pablo.androidmvvmtemplate.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchGithubRepoApiResponse {
    @SerializedName("total_count")
    public Long totalCount;
    @SerializedName("incomplete_results")
    public boolean incompleteREsults;
    @SerializedName("items")
    public List<GithubRepo> items;

}
