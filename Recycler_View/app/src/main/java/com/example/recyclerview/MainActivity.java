package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<toDoList> userList;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    toDoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();
        setRecycle();

    }

    private void setRecycle() {
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new toDoAdapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void setData() {
        userList = new ArrayList<>();
        userList.add(new toDoList(1, "ttttt"));
        userList.add(new toDoList(2, "ttttt"));
        userList.add(new toDoList(3, "ttttt"));
        userList.add(new toDoList(4, "xxx"));
        userList.add(new toDoList(5, "ttttt"));
        userList.add(new toDoList(6, "ttttt"));
        userList.add(new toDoList(6, "tvvv"));
        userList.add(new toDoList(6, "tzzz"));
        userList.add(new toDoList(6, "ttttt"));
        userList.add(new toDoList(6, "ttttt"));
        userList.add(new toDoList(6, "ttttt"));
        userList.add(new toDoList(6, "ttttt"));
        userList.add(new toDoList(6, "ttttt"));
        userList.add(new toDoList(6, "ttttt"));

    }
}