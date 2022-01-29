package com.example.jietapp;






import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showMore,readMore1,readMore2,readMore3,readMore4,jietweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMore =  findViewById(R.id.viewMore);
        readMore1 = findViewById(R.id.readMore1);
        readMore2 = findViewById(R.id.readMore2);
        readMore3 = findViewById(R.id.readMore3);
        readMore4 = findViewById(R.id.readMore4);
        jietweb = findViewById(R.id.jietweb);


        String url = "https://www.google.com/search?q=jiet&sxsrf=APq-WBsHfGKx95HyLjAqWSLvQOePc5thVg:1643379759438&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiz0KrW0tT1AhUjSWwGHdeYCaAQ_AUoAnoECAEQBA&biw=1852&bih=948&dpr=1";
        String url1 = "https://en.wikipedia.org/wiki/Computer_science_and_engineering";
        String url2 = "https://en.wikipedia.org/wiki/Electrical_engineering";
        String url3 = "https://en.wikipedia.org/wiki/Civil_engineering";
        String url4 = "https://en.wikipedia.org/wiki/Electronic_engineering#:~:text=Electronic%20engineering%20(also%20called%20electronics,devices%2C%20integrated%20circuits%20and%20their";
        String url5 = "https://www.jietjodhpur.ac.in/";


        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Showing more Pictures",Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        readMore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Reading more about CSE ",Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse(url1);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        readMore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Reading more about EEE",Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse(url2);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        readMore3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Reading more about Civil",Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse(url3);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        readMore4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Reading more about ECE",Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse(url4);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        jietweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Welcome To JIET Official Website",Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse(url5);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}