package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText input;
    public static final String EXTRA_NAME = "com.example.birthdayapp.extra.NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openActivity(View v){

        Intent intent = new Intent(this,MainActivity2.class);

        input = findViewById(R.id.input);
        String name = input.getText().toString();
        intent.putExtra(EXTRA_NAME,name);

        Toast.makeText(this, "Your Wishes is Being Ready..", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

}