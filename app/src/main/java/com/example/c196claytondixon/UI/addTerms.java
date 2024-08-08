package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;

public class addTerms extends AppCompatActivity {


    EditText termName;
    EditText termStart;
    EditText termEnd;
    String name;
    String start;
    String end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_terms);
        termName = findViewById(R.id.termName);
        termStart = findViewById(R.id.termStart);
        termEnd = findViewById(R.id.termEnd);
    }

    public void add(View view){
        Repository repo = new Repository(getApplication());

        if(termName.getText().toString().isEmpty()||termStart.getText().toString().isEmpty()||termEnd.getText().toString().isEmpty()) {
            Toast errorToast = Toast.makeText(addTerms.this, "Please fill in all fields", Toast.LENGTH_SHORT);
            errorToast.show();
        } else {
            name = termName.getText().toString();
            start = termStart.getText().toString();
            end = termEnd.getText().toString();
            TermEntity termEntity = new TermEntity((repo.getTermCount() + 1), name, start, end);
            repo.insertTerm(termEntity);
            Intent intent = new Intent(addTerms.this, Terms.class);
            startActivity(intent);
        }
    }
}