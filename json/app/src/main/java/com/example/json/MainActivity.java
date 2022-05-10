package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.json.adapter.StudentAdapter;
import com.example.json.model.StudentModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private   RecyclerView studentRecyclerView;
  private StudentAdapter studentAdapter;
    ProgressDialog progressDialog;
    private  ArrayList<StudentModel> studentStudentModelList;
  private String json_url = "https://script.google.com/macros/s/AKfycbwR23CN3czxx7tK0dzwHYOiGK6T9D71r7yzmJHZ9qGKRnd0cnVg4XrCDnHBbw8fMHci/exec";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading....");
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();
        studentRecyclerView = findViewById(R.id.recyclerView);
        studentStudentModelList = new ArrayList<>();
        getData();



        studentRecyclerView.setHasFixedSize(true);
        studentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter=new StudentAdapter(studentStudentModelList,this);

    }
    private void getData() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, json_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("user");
                    for (int i=0; i<array.length(); i++){
                        JSONObject ob=array.getJSONObject(i);
                       StudentModel student = new StudentModel(

                               ob.getString("Roll_No"),ob.getString("Name")
                               ,ob.getString("Total-absent"
                       ),ob.getString("Total-present"),ob.getString("percentage"));
                        studentStudentModelList.add(student);
                        progressDialog.dismiss();




                    }
                    studentRecyclerView.setAdapter(studentAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.student_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
       SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                studentAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;

    }

}