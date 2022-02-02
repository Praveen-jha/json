package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        show = findViewById(R.id.show);

        Intent intent = getIntent();
        String name =   intent.getStringExtra(MainActivity.EXTRA_NAME);
      show.setText(" Your name is "+name);

    }
}