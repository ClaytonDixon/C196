package com.example.c196claytondixon.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196claytondixon.Entity.TermEntity;

import java.util.List;

@Dao
public interface TermDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTerm(TermEntity termEntity);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllTerms(List<TermEntity> terms);

    @Update
    void updateTerm(TermEntity termEntity);

    @Delete
    void deleteTerm(TermEntity termEntity);

    @Query("SELECT * FROM terms WHERE termID = :termID")
    TermEntity getTermByID(int termID);

    @Query("SELECT * FROM terms ORDER BY termStart ASC")
    List<TermEntity> getAllTerms();

    @Query("DELETE FROM terms")
    int deleteAllTerms();

    @Query("SELECT COUNT(*) FROM terms")
    int getTermCount();
}
