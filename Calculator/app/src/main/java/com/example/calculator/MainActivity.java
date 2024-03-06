package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button equal;
    private Button plus;
    private Button minus;
    private Button multi;
    private Button divide;
    private TextView info;
    private TextView result;
    private final char Add = '+';
    private final char Sub = '-';
    private final char Mul = '*';
    private final char Div = '/';
    private final char Equal = '=';
    private double val1 = Double.NaN;
    private double val2;
    private char action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 0);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                info.setText(info.getText().toString() + 9);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculate();
                action = Add;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculate();
                action = Sub;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculate();
                action = Mul;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculate();
                action = Div;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculate();
                action = Equal;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);
                val1 = Double.NaN;
            }
        });
    }
    private void setUpViews(){
        zero = findViewById(R.id.button0);
        one = findViewById(R.id.button);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        equal = findViewById(R.id.button10);
        plus = findViewById(R.id.button11);
        minus = findViewById(R.id.button12);
        multi = findViewById(R.id.button13);
        divide = findViewById(R.id.button14);
        info = findViewById(R.id.textView);
        result = findViewById(R.id.textView2);
    }
    private void calculate(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());
            switch (action){
                case Add:
                    val1=val1+val2;
                    break;
                case Sub:
                    val1=val1-val2;
                    break;
                case Mul:
                    val1=val1*val2;
                    break;
                case Div:
                    val1=val1/val2;
                    break;
                case Equal:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}