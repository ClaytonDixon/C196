package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.R;

import java.util.List;

public class Assessments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessments);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Repository repo = new Repository(getApplication());
        List<AssessmentEntity> assessments = repo.getAllAssessments();
        final AssessmentAdapter adapter = new AssessmentAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAssessmentEntities(assessments);
        recyclerView.setAdapter(adapter);
    }

    public void addAssessments(View view) {
        Intent intent = new Intent(Assessments.this, addAssessments.class);
        startActivity(intent);
    }
}