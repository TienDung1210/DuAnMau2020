package com.example.duanmau2020.Book;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
   private BookSQL bookSQL;

    public BookDAO(BookSQL bookSQL) {
        this.bookSQL = bookSQL;
    }


    public boolean addbook(Book book){
        SQLiteDatabase sqLiteDatabase = bookSQL.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("masach",book.masach);
        contentValues.put("tensach",book.tensach);
        contentValues.put("tacgia",book.tacgia);
        contentValues.put("nhaxuatban",book.nhaxuatban);
        contentValues.put("giabia",book.giabia);
        contentValues.put("soluong",book.soluong);
        contentValues.put("tentlsach",book.tentlsach);

        long kq = sqLiteDatabase.insert("BOOK",null,contentValues);
        if (kq>0){
            return true;

        }else {
            return false;
        }
    }
    public boolean delTheloai(String  tensach) {
        SQLiteDatabase sqLiteDatabase = bookSQL.getWritableDatabase();


        long kq = sqLiteDatabase.delete("BOOK", "tensach=?", new String[]{tensach});
        if (kq > 0) {
            return true;

        } else {
            return false;
        }
    }

    public List<Book> getAllBook(){
        List<Book> booksList = new ArrayList<>();
        String sql = "SELECT * FROM BOOK ";
        Cursor cursor = bookSQL.getReadableDatabase().rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String masach = cursor.getString(0);
                String tensach = cursor.getString(1);
                String tacgia = cursor.getString(2);
                String nhaxuatban = cursor.getString(3);
                String giabia = cursor.getString(4);
              String soluong = cursor.getString(5);
                String tentlsach = cursor.getString(6);


                Book book =new Book();

                book.masach =masach;
                book.tensach =tensach;
                book.tacgia =tacgia;
                book.nhaxuatban=nhaxuatban;
                book.tacgia=giabia;
                book.soluong = soluong;
                book.tentlsach =tentlsach;




                booksList.add(book);
                cursor.moveToNext();


            }

        }
        return booksList ;
    }
}
