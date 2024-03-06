package com.example.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        //Serialization
//        Student student = new Student("Roman","roman@gmail.com","22");
//        String json = gson.toJson(student);

        //Deserialization
//        String data = "{\"age\":\"22\",\"mail\":\"roman@gmail.com\",\"name\":\"Roman\"}";
//        Student student = gson.fromJson(data,Student.class);
//        Log.d(TAG, student.toString());

//        Course course = new Course("java", 399);
//        Student student = new Student("Roman", "roman@gmail.com", 22, course);
//        String json = gson.toJson(student);

//        String data = "{\"Age\":22,\"course\":{\"Course_Fees\":399,\"Course_Name\":\"java\"},\"Email\":\"roman@gmail.com\",\"Name\":\"Roman\"}";
//        Student student = gson.fromJson(data, Student.class);
//        Log.d("Test", student.toString());

//        List<Course> courseList = new ArrayList<>();
//        courseList.add(new Course("java",299));
//        courseList.add(new Course("kotlin",399));
//        courseList.add(new Course("android",599));
//
//        Student student = new Student("elon", "elon@gmail.com", 22, courseList);
//        String json = gson.toJson(student);

        String data = "{\"Age\":22,\"courseList\":[{\"Course_Fees\":299,\"Course_Name\":\"java\"},{\"Course_Fees\":399,\"Course_Name\":\"kotlin\"},{\"Course_Fees\":599,\"Course_Name\":\"android\"}],\"Email\":\"elon@gmail.com\",\"Name\":\"elon\"}";
        Student student = gson.fromJson(data,Student.class);
        Log.d(TAG, student.toString());

    }
}