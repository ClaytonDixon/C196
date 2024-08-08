package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;

import java.util.List;

public class Courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Repository repo = new Repository(getApplication());
        List<CourseEntity> courses = repo.getAllCourses();
        final CourseAdapter adapter = new CourseAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setCourseEntities(courses);
        recyclerView.setAdapter(adapter);
    }

    public void addCourses(View view) {
        Intent intent = new Intent(Courses.this, addCourses.class);
        startActivity(intent);
    }
}