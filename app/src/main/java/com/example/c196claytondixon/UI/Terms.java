package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;

import java.util.List;

public class Terms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Repository repo = new Repository(getApplication());
        List<TermEntity> terms = repo.getAllTerms();
        final TermAdapter adapter = new TermAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setTermEntities(terms);
        recyclerView.setAdapter(adapter);
    }


    public void addTerms(View view) {
        Intent intent = new Intent(Terms.this, addTerms.class);
        startActivity(intent);
    }
}