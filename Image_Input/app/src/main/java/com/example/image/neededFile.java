package com.example.image;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class neededFile extends SQLiteOpenHelper {
    public neededFile(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void query(String sql){
        SQLiteDatabase d = getWritableDatabase();
        d.execSQL(sql);
    }
    public void insert(String name,byte[] image){
        SQLiteDatabase d = getWritableDatabase();
        String sql = "insert into product values (null, ?, ?)";

        SQLiteStatement statement = d.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindBlob(2,image);

        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase d = getReadableDatabase();
        return d.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
