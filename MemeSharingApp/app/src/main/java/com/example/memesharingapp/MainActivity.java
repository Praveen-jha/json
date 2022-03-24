package com.example.memesharingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String url="";


    ImageView imageView;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        progress = findViewById(R.id.progress);



//        ProgressBar pb = (ProgressBar) findViewById(R.id.pbLoading);
// run a background job and once complete

    }

    private void load(){

        progress.setVisibility(ProgressBar.VISIBLE);

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://meme-api.herokuapp.com/gimme", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Log.d("myApp","the url is "+ response.getString("url"));
                    url = response.getString("url");

                    Glide.with(getApplicationContext()).load(url).into(imageView);

                    progress.setVisibility(ProgressBar.INVISIBLE);


                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("myApp","not working");

            }
        });
        requestQueue.add(JsonObjectRequest);



    }


    public void next(View view) {
        load();
    }

    public void share(View view) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey see this amazing meme. "+url);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}