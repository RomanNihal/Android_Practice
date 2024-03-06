package com.example.recyclerwithdialouge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    recyclerAdapter adapter;
    FloatingActionButton f1;
    SQLiteDatabase db;
    personsData pD;
    List<bindData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1 = findViewById(R.id.floatingActionButton);
        pD = new personsData(this);
        db = pD.getReadableDatabase();

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.additem);
                dialog.setTitle("Add");

                EditText et1 = dialog.findViewById(R.id.imageUrl);
                EditText et2 = dialog.findViewById(R.id.etname);
                EditText et3 = dialog.findViewById(R.id.etid);
                Button b1 = dialog.findViewById(R.id.addbutton);

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s1 = et1.getText().toString();
                        String s2 = et2.getText().toString();
                        String s3 = et3.getText().toString();
                        bindData b1 = new bindData(s1,s2,s3);
                        boolean b = pD.insert(b1);
                        if(b){
                            dialog.dismiss();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "name already added", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                int width = (int)(MainActivity.this.getResources().getDisplayMetrics().widthPixels * 0.95);
                int height = (int)(MainActivity.this.getResources().getDisplayMetrics().heightPixels * 0.7);
                dialog.getWindow().setLayout(width,height);
                dialog.show();
            }
        });
        setRecycler();

    }
    public void setRecycler(){
        list = new ArrayList<>();
        Cursor c = pD.getData();
        if(c.getCount()==0){
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }
        else{
            while (c.moveToNext()){
                list.add(new bindData(c.getString(0),c.getString(1),c.getString(2)));
            }
        }
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new recyclerAdapter(list,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}