package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {
    @SerializedName("Name")
    private String name;

    @SerializedName("Email")
    private String mail;

    @SerializedName("Age")
    public int age;

    List<Course> courseList;

    public Student(String name, String mail, int age, List<Course> courseList) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.courseList = courseList;
    }
}
