package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

public class Course {
    @SerializedName("Course_Name")
    private String courseName;

    @SerializedName("Course_Fees")
    private int courseFees;

    public Course(String courseName, int courseFees) {
        this.courseName = courseName;
        this.courseFees = courseFees;
    }
}
