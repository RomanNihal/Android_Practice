package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    EditText et1;
    TextView tv1;
    TextView tv2;
    int r1,t;
    int count = 0,flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1 = findViewById(R.id.editTextNumberDecimal);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView4);
        random();
    }
    public void random(){
        tv2.setText("Check");
        r1 = new Random().nextInt(99)+1;
    }
    public void Check(View view){

        if(flag==1){
            finish();
            startActivity(getIntent());
        }
        else if(TextUtils.isEmpty(et1.getText().toString())){
            tv1.setText("Enter a number first");
        }
        else{

            t = Integer.parseInt(et1.getText().toString());
            if((t-r1)==0){
                tv2.setText("Reset");
                count++;
                tv1.setText("Congrats you succeed in "+ count + "attempt");
                et1.setText(null);
                flag=1;
            }
            else if(t>100){
                tv1.setText("Enter number between 0-100");
                et1.setText(null);
            }
            else if(t<0){
                tv1.setText("Enter number between 0-100");
                et1.setText(null);
            }
            else if((t-r1)<=15 && (t-r1)>0){
                count++;
                tv1.setText("Close enough, enter little small");
                et1.setText(null);
            }
            else if((t-r1)>=-15 && (t-r1)<0){
                count++;
                tv1.setText("Close enough, enter little big");
                et1.setText(null);
            }
            else if((t-r1)<=40 && (t-r1)>15){
                count++;
                tv1.setText("enter small number");
                et1.setText(null);
            }
            else if((t-r1)>=-40 && (t-r1)<-15){
                count++;
                tv1.setText("enter big number");
                et1.setText(null);
            }
            else if((t-r1)>40){
                count++;
                tv1.setText("way too big");
                et1.setText(null);
            }
            else if((t-r1)<-40){
                count++;
                tv1.setText("way too small");
                et1.setText(null);
            }
        }
    }
}