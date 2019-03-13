package com.kintopp.pablo.androidmvvmtemplate.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepositoryApiResponse {
    @SerializedName("total_count")
    public Long totalCount;
    @SerializedName("incomplete_results")
    public boolean incompleteREsults;
    @SerializedName("items")
    public List<Repository> items;

}
