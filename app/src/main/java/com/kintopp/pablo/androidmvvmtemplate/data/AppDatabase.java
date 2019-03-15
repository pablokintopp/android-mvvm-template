package com.kintopp.pablo.androidmvvmtemplate.data;


import com.kintopp.pablo.androidmvvmtemplate.data.converter.UserTypeConverter;
import com.kintopp.pablo.androidmvvmtemplate.data.model.GithubRepo;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {GithubRepo.class}, version = 1, exportSchema = false)
@TypeConverters({UserTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract GithubRepoDao repositoryDao();


}
