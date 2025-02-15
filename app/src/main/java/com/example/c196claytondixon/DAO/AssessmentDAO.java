package com.example.c196claytondixon.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196claytondixon.Entity.AssessmentEntity;

import java.util.List;

@Dao
public interface AssessmentDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAssessment(AssessmentEntity assessmentEntity);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllAssessments(List<AssessmentEntity> assessments);

    @Update
    void updateAssessment(AssessmentEntity assessmentEntity);

    @Delete
    void deleteAssessment(AssessmentEntity assessmentEntity);

    @Query("SELECT * FROM assessments WHERE assessmentID = :assessmentID")
    AssessmentEntity getAssessmentByID(int assessmentID);

    @Query("SELECT * FROM assessments WHERE courseID = :courseID")
    List<AssessmentEntity> getAssessmentByCourse(int courseID);

    @Query("SELECT * FROM assessments ORDER BY assessmentStart ASC")
    List<AssessmentEntity> getAllAssessments();

    @Query("DELETE FROM assessments")
    int deleteAllAssessments();

    @Query("SELECT COUNT(*) FROM assessments")
    int getAssessmentCount();

    @Query("SELECT COUNT(*) FROM assessments WHERE courseID = :courseID")
    int getAssessmentCountByCourse(int courseID);

    @Query("SELECT COUNT(*) FROM assessments WHERE courseID IS NOT NULL")
    int getAssessmentCountByAnyCourse();
}
