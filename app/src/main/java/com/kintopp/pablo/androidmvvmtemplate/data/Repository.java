package com.kintopp.pablo.androidmvvmtemplate.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kintopp.pablo.androidmvvmtemplate.data.converter.UserTypeConverter;

import org.parceler.Parcel;

import androidx.room.Entity;
import androidx.room.TypeConverters;

@Parcel
@Entity(primaryKeys = ("id"))
public class Repository {
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
}
