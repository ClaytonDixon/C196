package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.R;

public class addAssessments extends AppCompatActivity {

    EditText assessmentTitle;
    EditText assessmentStart;
    EditText assessmentEnd;
    EditText courseIDField;
    RadioButton objectiveRadio;
    RadioButton performanceRadio;
    RadioGroup radioGroup;
    String title;
    String start;
    String end;
    String type;
    Integer courseID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assessments);
        assessmentTitle = findViewById(R.id.assessmentTitle);
        assessmentStart = findViewById(R.id.assessmentStart);
        assessmentEnd = findViewById(R.id.assessmentEnd);
        courseIDField = findViewById(R.id.courseIDField);
        objectiveRadio = findViewById(R.id.objectiveRadio);
        performanceRadio = findViewById(R.id.performanceRadio);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void add(View view) {
        Repository repo = new Repository(getApplication());

        if(assessmentTitle.getText().toString().isEmpty()||assessmentStart.getText().toString().isEmpty()||
                assessmentEnd.getText().toString().isEmpty() || courseIDField.getText().toString().isEmpty() ||  (radioGroup.getCheckedRadioButtonId() == -1)) {
            Toast errorToast = Toast.makeText(addAssessments.this, "Please fill in all fields", Toast.LENGTH_SHORT);
            errorToast.show();
        } else {
            courseID = Integer.valueOf(courseIDField.getText().toString());
            title = assessmentTitle.getText().toString();
            start = assessmentStart.getText().toString();
            end = assessmentEnd.getText().toString();
            if(performanceRadio.isChecked()) {
                type = "Performance";
            }
            if(objectiveRadio.isChecked()) {
                type = "Objective";
            }
            AssessmentEntity assessmentEntity = new AssessmentEntity((repo.getAssessmentCount() + 1), title, start, end, type, courseID);
            repo.insertAssessment(assessmentEntity);
            Intent intent = new Intent(addAssessments.this, Assessments.class);
            startActivity(intent);
        }
    }
}