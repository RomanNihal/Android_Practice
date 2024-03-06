package com.example.to_do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHandler extends SQLiteOpenHelper  {

    public static final String databaseName = "ToDoDatabase.db";
    public static final String tableName = "ToDoTable";
    SQLiteDatabase sqLiteDatabase;

    public databaseHandler(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String s = "create table " + tableName + " (id integer primary key autoincrement, status integer, task text)";
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + tableName);
        onCreate(sqLiteDatabase);
    }

    public void openDatabase(){
        sqLiteDatabase = this.getWritableDatabase();
    }

    public boolean insert(String task){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("task",task);
        long result = sqLiteDatabase.insert(tableName,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName, null);
        return cursor;
    }

    public void updateStatus(int id, int status){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", status);
        sqLiteDatabase.update(tableName, contentValues, "id" + "=?", new String[] {String.valueOf(id)});
    }

    public void updateTask(int id, String task){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("task", task);
        sqLiteDatabase.update(tableName, contentValues, "id" + "=?", new String[] {String.valueOf(id)});
    }

    public void delete(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(tableName, "id" + "=?", new String[] {String.valueOf(id)});
    }
}
