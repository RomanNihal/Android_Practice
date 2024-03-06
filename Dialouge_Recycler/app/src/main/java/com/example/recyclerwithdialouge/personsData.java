package com.example.recyclerwithdialouge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class personsData extends SQLiteOpenHelper {
    public static final String databaseName = "personsDetailsDataBase";
    public personsData(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table personsData(imageUrl text, name text primary key, id text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public boolean insert(bindData b1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put("imageUrl",b1.s1);
        cV.put("name",b1.s2);
        cV.put("id",b1.s3);
        long result = db.insert("personsData",null,cV);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public boolean update(String url, String name, String id) {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("imageUrl",url);
        contentValues.put("name",name);
        contentValues.put("id",id);
        Cursor cursor= sqLiteDatabase.rawQuery("select * from personsData where name = ?",new String[]{name});
        sqLiteDatabase.update("personsData",contentValues,"name = ?",new String[]{name});
        if(cursor.getCount()==0){
            return false;
        }
        return true;
    }


    public Cursor getData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("select * from personsData",null);
        return c;
    }
}
