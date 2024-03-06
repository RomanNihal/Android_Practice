package com.example.to_do;

public class Model {
    int id;
    int status;
    String taskText;

    public Model(int id, int status, String taskText) {
        this.id = id;
        this.status = status;
        this.taskText = taskText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }
}
