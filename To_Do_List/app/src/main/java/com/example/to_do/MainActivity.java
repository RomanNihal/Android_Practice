package com.example.to_do;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogClose {
    List<Model> list;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SQLiteDatabase sqLiteDatabase;
    Connector connector;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingButton);

        setRecyclerView();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
    }
    public void setRecyclerView(){
        list=new ArrayList<>();
        sqLiteDatabase = SplashActivity.handler.getReadableDatabase();

        Cursor cursor= SplashActivity.handler.getData();

        if(cursor.getCount()==0){
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                list.add(new Model(cursor.getInt(0),cursor.getInt(1),cursor.getString(2)));
            }
        }
        recyclerView=findViewById(R.id.taskRecyclerView);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        connector=new Connector(list,this);
        recyclerView.setAdapter(connector);
        connector.notifyDataSetChanged();
    }

    public void handleDialogClose(DialogInterface dialog){
        list = (List<Model>) SplashActivity.handler.getData();
        connector=new Connector(list,this);
        connector.notifyDataSetChanged();
    }
}