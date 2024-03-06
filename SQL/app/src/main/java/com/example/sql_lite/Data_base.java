package com.example.sql_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Data_base extends SQLiteOpenHelper {
    private static final String s = "Account";
    public Data_base(Context context) {
        super(context, s, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table User_details(Name TEXT primary key, Email TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists User_info");
    }
    public boolean insert(String name, String mail, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("Name",name);
        c.put("Email",mail);
        c.put("Password",pass);
        long result = db.insert("User_details",null,c);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean update(String name, String mail, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("Email",mail);
        c.put("Password",pass);
        Cursor cursor = db.rawQuery("select * from User_details where Name = ?",new String[]{name});
        if(cursor.getCount()>0){
            long result = db.update("User_details",c,"Name=?",new String[]{name});
            if(result==-1){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    public boolean delete(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from User_details where Name = ?",new String[]{name});
        System.out.println("found");
        if(cursor.getCount()>0){
            long result = db.delete("User_details","Name=?",new String[]{name});
            if(result==-1){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    public Cursor print(){
        SQLiteDatabase s = this.getReadableDatabase();
        Cursor cursor = s.rawQuery("select * from User_details",null);
        return cursor;
    }
}
