package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dataupdate extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataupdate);
        et1 = findViewById(R.id.etp);
        et2 = findViewById(R.id.etp2);
        et3 = findViewById(R.id.etp3);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
    }
    public void update(View v){
        Data_base d = new Data_base(this);

        String name = et1.getText().toString().trim();
        String mail = et2.getText().toString().trim();
        String pass = et3.getText().toString().trim();
        d.update(name,mail,pass);
        System.out.println("send");
    }
    public void delete(View v){
        Data_base d = new Data_base(this);

        String name = et1.getText().toString().trim();
        d.delete(name);
    }
}