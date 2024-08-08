package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;

import java.util.ArrayList;
import java.util.List;

public class editTerm extends AppCompatActivity {

    TextView termID;
    EditText termName;
    EditText termStart;
    EditText termEnd;
    EditText textView20;
    EditText textView21;
    EditText textView22;
    EditText textView23;
    EditText textView24;
    EditText textView25;
    EditText textView26;
    EditText textView27;
    EditText textView28;
    EditText textView29;
    EditText textView30;
    EditText textView31;
    Integer id;
    String name;
    String start;
    String end;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_term);
        termID = findViewById(R.id.termID);
        termName = findViewById(R.id.termName);
        termStart = findViewById(R.id.termStart);
        termEnd = findViewById(R.id.termEnd);
        id = getIntent().getIntExtra("id", 0);
        name = getIntent().getStringExtra("name");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        termID.setText(id.toString());
        termName.setText(name);
        termStart.setText(start);
        termEnd.setText(end);
        repo = new Repository(getApplication());

        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
//        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView30 = findViewById(R.id.textView30);
//        textView31 = findViewById(R.id.textView31);

        List<CourseEntity> courseList = repo.getCoursesByTerm(id);
        ArrayList<String> courseNames = new ArrayList<>();

        for(int count = 0; courseList.size() > count; count++) {
            courseNames.add(count, courseList.get(count).getCourseTitle());
        }

//        Toast errorToast4 = Toast.makeText(editTerm.this, "courseList list size = " + courseList.size(), Toast.LENGTH_LONG);
//        errorToast4.show();

        if(courseNames.size() > 0) {
            textView20.setText(courseNames.get(0));
            if(courseNames.size() > 1) textView21.setText(courseNames.get(1));
            if(courseNames.size() > 2) textView22.setText(courseNames.get(2));
            if(courseNames.size() > 3) textView23.setText(courseNames.get(3));
            if(courseNames.size() > 4) textView24.setText(courseNames.get(4));
            if(courseNames.size() > 5) textView26.setText(courseNames.get(5));
            if(courseNames.size() > 6) textView27.setText(courseNames.get(6));
            if(courseNames.size() > 7) textView28.setText(courseNames.get(7));
            if(courseNames.size() > 8) textView29.setText(courseNames.get(8));
            if(courseNames.size() > 9) textView30.setText(courseNames.get(9));
        }
    }

    public void save(View view) {
        TermEntity termEntity;
        termEntity = new TermEntity(id, termName.getText().toString(), termStart.getText().toString(), termEnd.getText().toString());
        repo.updateTerm(termEntity);
        Intent intent = new Intent(editTerm.this, Terms.class);
        startActivity(intent);
    }

    public void delete(View view) {
        if(textView20.getText().toString().isEmpty()) {
            TermEntity termEntity;
            termEntity = new TermEntity(id, termName.getText().toString(), termStart.getText().toString(), termEnd.getText().toString());
            repo.deleteTerm(termEntity);
            Intent intent = new Intent(editTerm.this, Terms.class);
            startActivity(intent);
        } else {
            Toast errorToast = Toast.makeText(editTerm.this, "Delete all courses belonging to this term before deleting this term"
                    , Toast.LENGTH_LONG);
            errorToast.show();
        }
    }
}