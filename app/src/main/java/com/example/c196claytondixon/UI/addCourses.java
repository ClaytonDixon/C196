package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.CourseEntity;

import com.example.c196claytondixon.R;

public class addCourses extends AppCompatActivity {

    EditText termIDField;
    EditText courseTitle;
    EditText courseStart;
    EditText courseEnd;
    EditText courseStatus;
    EditText courseNotes;
    EditText courseInstructorName;
    EditText courseInstructorPhoneNumber;
    EditText courseInstructorEmail;
    Integer termID;
    String title;
    String start;
    String end;
    String status;
    String notes;
    String instructorName;
    Long instructorPhoneNumber;
    String instructorEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_courses);
        termIDField = findViewById(R.id.termIDField);
        courseTitle = findViewById(R.id.courseTitle);
        courseStart = findViewById(R.id.courseStart);
        courseEnd = findViewById(R.id.courseEnd);
        courseStatus = findViewById(R.id.courseStatus);
        courseNotes = findViewById(R.id.courseNotes);
        courseInstructorName = findViewById(R.id.courseInstructorName);
        courseInstructorPhoneNumber = findViewById(R.id.courseInstructorPhoneNumber);
        courseInstructorEmail = findViewById(R.id.courseInstructorEmail);

    }

    public void add(View view){
        Repository repo = new Repository(getApplication());

        if(courseTitle.getText().toString().isEmpty()||courseStart.getText().toString().isEmpty()||
                courseEnd.getText().toString().isEmpty() || courseNotes.getText().toString().isEmpty() ||
                courseStatus.getText().toString().isEmpty() || termIDField.getText().toString().isEmpty() ||
                courseInstructorName.getText().toString().isEmpty() || courseInstructorPhoneNumber.getText().toString().isEmpty()
                || courseInstructorEmail.getText().toString().isEmpty()){
            Toast errorToast = Toast.makeText(addCourses.this, "Please fill in all fields", Toast.LENGTH_SHORT);
            errorToast.show();
        } else {
            termID = Integer.valueOf(termIDField.getText().toString());
            title = courseTitle.getText().toString();
            start = courseStart.getText().toString();
            end = courseEnd.getText().toString();
            status = courseStatus.getText().toString();
            notes = courseNotes.getText().toString();
            instructorName = courseInstructorName.getText().toString();
            instructorPhoneNumber = Long.parseLong(courseInstructorPhoneNumber.getText().toString());
            instructorEmail = courseInstructorEmail.getText().toString();
            CourseEntity courseEntity = new CourseEntity((repo.getCourseCount() + 1), title, start, end, status, notes, termID, instructorName,
                    instructorPhoneNumber, instructorEmail);
            repo.insertCourse(courseEntity);
            Intent intent = new Intent(addCourses.this, Courses.class);
            startActivity(intent);
        }
    }
}