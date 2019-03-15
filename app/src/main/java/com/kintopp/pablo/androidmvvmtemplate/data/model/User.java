package com.kintopp.pablo.androidmvvmtemplate.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import androidx.room.Entity;

@Parcel
public class User {
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("login")
    @Expose
    public String username;
    @SerializedName("avatar_url")
    @Expose
    public String profilePicture;
    @SerializedName("html_url")
    @Expose
    public String url;
}
