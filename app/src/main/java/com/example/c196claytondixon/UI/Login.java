package com.example.c196claytondixon.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196claytondixon.R;

public class Login extends AppCompatActivity {

    Button login;
    EditText usernameField;
    EditText passwordField;
    String username;
    String password;
    final String actualUser = "username";
    final String actualPass = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
    }

    public void signIn(View view) {
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
//        if(!username.equals(actualUser) || !password.equals(actualPass)){
//            Toast errorToast = Toast.makeText(Login.this, "Username or Password is incorrect", Toast.LENGTH_SHORT);
//            errorToast.show();
//        } else {
//            Intent intent = new Intent(Login.this, MainActivity.class);
//            startActivity(intent);
//        }
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }
}