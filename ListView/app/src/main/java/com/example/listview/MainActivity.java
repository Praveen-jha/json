package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String arr[] = {"Java","Kotlin","Android","HTML","CSS","JavaScript","Node js","SQL","Mongo Db",
    "Django","Python"," Machine Learning","Data Science","Swift","C++","Data Structure and Algorithm","Roadmap"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListView);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,arr);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "You Clicked on "+arr[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}