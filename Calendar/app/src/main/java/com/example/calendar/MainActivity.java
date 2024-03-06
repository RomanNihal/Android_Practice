package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.DatePicker);
        textView = findViewById(R.id.Date);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(showDate());
            }
        });


    }
    StringBuffer showDate(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(datePicker.getDayOfMonth() + "/");
        stringBuffer.append(datePicker.getMonth()+1 + "/");
        stringBuffer.append(datePicker.getYear());
        return stringBuffer;
    }
}