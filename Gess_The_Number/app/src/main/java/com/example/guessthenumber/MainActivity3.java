package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView t1;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        String s = "HOW TO PLAY";
        String s1 = "Guess the number from 1 to 100. Everytime the app will auto pick a number and it will give you hints.";
        t1.setText(s);
        t2.setText(s1);
    }
}