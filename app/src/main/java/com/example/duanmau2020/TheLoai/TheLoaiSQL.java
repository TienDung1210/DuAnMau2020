package com.example.duanmau2020.TheLoai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TheLoaiSQL extends SQLiteOpenHelper {
    public TheLoaiSQL(@Nullable Context context) {
        super(context, "mydata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String theloa_table = "CREATE TABLE THELOAI(nametheloai text primary key,vitri text, mota text)";
        db.execSQL(theloa_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
