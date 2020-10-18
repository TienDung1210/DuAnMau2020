package com.example.duanmau2020.Book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BookSQL extends SQLiteOpenHelper {
    public BookSQL(@Nullable Context context) {
        super(context, "mydata ",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String book_table = "CREATE TABLE BOOK(masach text primary key,tensach text, tacgia text,nhaxuatban text,giabia text,soluong text, tentlsach text)";
        db.execSQL(book_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
