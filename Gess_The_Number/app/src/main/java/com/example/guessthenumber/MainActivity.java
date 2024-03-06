package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button(View view){
        Intent send = new Intent(this,MainActivity2.class);
        startActivity(send);
    }
    public void button2(View view){
        Intent send = new Intent(this,MainActivity3.class);
        startActivity(send);
    }
    public void button3(View view){
        Intent send = new Intent(this,MainActivity4.class);
        startActivity(send);
    }
}