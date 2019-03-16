package com.kintopp.pablo.androidmvvmtemplate.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kintopp.pablo.androidmvvmtemplate.data.converter.UserTypeConverter;
import com.kintopp.pablo.androidmvvmtemplate.data.model.User;

import org.parceler.Parcel;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.TypeConverters;

@Parcel
@Entity(primaryKeys = ("id"))
public class GithubRepo {
    @Expose
    @SerializedName("id")
    public int id;
    @Expose
    @SerializedName("name")
    public String name;
    @Expose
    @SerializedName("url")
    public String url;
    @Expose
    @SerializedName("owner")
    @TypeConverters(UserTypeConverter.class)
    public User owner;
    @Expose
    @SerializedName("description")
    public String description;
    @Expose
    @SerializedName("stargazers_count")
    public int stars;
    @Expose
    public Long page;

    @Override
    public int hashCode() {
        return (int) id * name.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return ((GithubRepo)o).id == this.id;
    }
}
