package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Read_Data extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        t1 = findViewById(R.id.textView);
        Data_base d = new Data_base(this);
//        SQLiteDatabase s = d.getReadableDatabase();
        Cursor cursor = d.print();
        if(cursor.getCount()==0){
            t1.setText("No data found");
        }
        StringBuffer sb = new StringBuffer();
        while(cursor.moveToNext()){
            sb.append("Name: "+cursor.getString(0)+"\n");
            sb.append("Email: "+cursor.getString(1)+"\n");
            sb.append("Password: "+cursor.getString(2)+"\n\n");
        }
        t1.setText(sb);
    }
}