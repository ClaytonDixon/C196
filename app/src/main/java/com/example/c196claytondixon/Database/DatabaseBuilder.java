package com.example.c196claytondixon.Database;

import  android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.c196claytondixon.DAO.AssessmentDAO;
import com.example.c196claytondixon.DAO.CourseDAO;
import com.example.c196claytondixon.DAO.TermDAO;
import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.Entity.TermEntity;

@Database(entities = {TermEntity.class, CourseEntity.class, AssessmentEntity.class},version = 9, exportSchema = false )
public abstract class DatabaseBuilder extends RoomDatabase {

    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract AssessmentDAO assessmentDAO();

    private static volatile DatabaseBuilder INSTANCE;

    static DatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseBuilder.class
                            , "myDatabase.db").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
