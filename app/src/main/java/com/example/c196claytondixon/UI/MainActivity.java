package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repo = new Repository(getApplication());
        TermEntity termEntity = new TermEntity(1, "test", "now", "later");
        repo.insertTerm(termEntity);
        CourseEntity courseEntity = new CourseEntity(1, "testTitle", "courseStart"
                , "courseEnd", "courseStatus", "courseNotes", 1, "instructor name",
                5555555555L, "instructor email");
        repo.insertCourse(courseEntity);
        AssessmentEntity assessmentEntity = new AssessmentEntity(1, "title", "start",
                "end", "Performance", 1);
        repo.insertAssessment(assessmentEntity);
    }

    public void goTerms(View view) {
        Intent intent = new Intent(MainActivity.this, Terms.class);
        startActivity(intent);
    }

    public void goAssessments(View view) {
        Intent intent = new Intent(MainActivity.this, Assessments.class);
        startActivity(intent);
    }

    public void goCourses(View view) {
        Intent intent = new Intent(MainActivity.this, Courses.class);
        startActivity(intent);
    }

    public void goReports(View view) {
        Intent intent = new Intent(MainActivity.this, Reports.class);
        startActivity(intent);
    }
}