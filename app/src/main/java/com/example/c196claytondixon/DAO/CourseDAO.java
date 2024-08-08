package com.example.c196claytondixon.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196claytondixon.Entity.CourseEntity;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourse(CourseEntity courseEntity);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllCourses(List<CourseEntity> courses);

    @Update
    void updateCourse(CourseEntity courseEntity);

    @Delete
    void deleteCourse(CourseEntity courseEntity);

    @Query("SELECT * FROM courses WHERE courseID = :courseID")
    CourseEntity getCourseByID(int courseID);

    @Query("SELECT * FROM courses WHERE termID = :termID")
    List<CourseEntity> getCoursesByTerm(int termID);

    @Query("SELECT * FROM courses ORDER BY courseStart ASC")
    List<CourseEntity> getAllCourses();

    @Query("DELETE FROM courses")
    int deleteAllCourses();

    @Query("SELECT COUNT(*) FROM courses")
    int getCourseCount();

    @Query("SELECT COUNT(*) FROM courses WHERE termID = :termID")
    int getCountByTerm(int termID);
}
