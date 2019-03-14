package com.kintopp.pablo.androidmvvmtemplate.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface GithubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertRepositories(List<Repository> repositories);

    @Query("SELECT * FROM `Repository`")
    List<Repository> getRepositoriesByPage();
}
