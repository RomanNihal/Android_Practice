package com.example.retrofitjson;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class Model {
//    @SerializedName("postId")
    int userId;
    Integer id;
//    @SerializedName("name")
    String title;
    String body;

    public Model(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
