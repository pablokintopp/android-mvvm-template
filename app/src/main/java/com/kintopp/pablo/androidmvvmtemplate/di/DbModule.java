package com.kintopp.pablo.androidmvvmtemplate.di;

import android.app.Application;

import com.kintopp.pablo.androidmvvmtemplate.data.AppDatabase;
import com.kintopp.pablo.androidmvvmtemplate.data.GithubRepoDao;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "GithubApp.db")
                .allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    GithubRepoDao provideRepoDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.repositoryDao();
    }
}
