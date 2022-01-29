package com.example.day_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText input;
    Button submit;
    TextView show;
    int ans = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        submit = findViewById(R.id.submit);
        show = findViewById(R.id.show);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                StringBuffer praveen = new StringBuffer();
                int res;
                String s = input.getText().toString();
                int n = Integer.parseInt( s);
                for(int i =1; i<11;i++){
                    ans = n*i;
                    praveen.append(n+" X "+i+" = "+ans+"\n\n");
                }
                show.setText(praveen);
                break;
        }

    }
}