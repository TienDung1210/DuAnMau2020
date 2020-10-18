package com.example.duanmau2020.Nguoidung;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserSQL extends SQLiteOpenHelper {
    public UserSQL(@Nullable Context context) {
        super(context, "mydata.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String user_table ="CREATE TABLE USER(username text primary key,password text, phone text, fullname text)";
        db.execSQL(user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
