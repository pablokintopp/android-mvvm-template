package com.kintopp.pablo.androidmvvmtemplate.data;

import com.kintopp.pablo.androidmvvmtemplate.data.model.GithubRepo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface GithubRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertRepositories(List<GithubRepo> repositories);

    @Query("SELECT * FROM GithubRepo where page = :page")
    List<GithubRepo> getRepositoriesByPage(Long page);

    @Query("SELECT * FROM GithubRepo where id = :id")
    GithubRepo getRepositoryById(int id);
}
