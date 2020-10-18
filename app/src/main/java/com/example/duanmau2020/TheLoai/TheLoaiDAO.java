package com.example.duanmau2020.TheLoai;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    private  TheLoaiSQL theLoaiSQL;

    public TheLoaiDAO(TheLoaiSQL theLoaiSQL) {
        this.theLoaiSQL = theLoaiSQL;
    }

    public boolean addTheloai(TheLoai theLoai){
        SQLiteDatabase sqLiteDatabase = theLoaiSQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nametheloai",theLoai.nametheloai);
        contentValues.put("vitri",theLoai.vitri);
        contentValues.put("mota", theLoai.mota);

        long kq = sqLiteDatabase.insert("THELOAI", null,contentValues);
        if (kq>0){
            return true;

        }else {
            return  false;
        }

    }
    public boolean delTheloai(String  nametheloai) {
        SQLiteDatabase sqLiteDatabase = theLoaiSQL.getWritableDatabase();


        long kq = sqLiteDatabase.delete("THELOAI", "nametheloai=?", new String[]{nametheloai});
        if (kq > 0) {
            return true;

        } else {
            return false;
        }
    }
    public List<TheLoai> getAllTheloai(){
        List<TheLoai> theLoaiList = new ArrayList<>();
        String sql = "SELECT * FROM THELOAI ";
        Cursor cursor = theLoaiSQL.getReadableDatabase().rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String nametheloai = cursor.getString(0);
                String vitri = cursor.getString(1);
                String mota = cursor.getString(2);


                TheLoai theLoai = new TheLoai();
                theLoai.nametheloai=nametheloai;
                theLoai.vitri=vitri;
                theLoai.mota =mota;

                theLoaiList.add(theLoai);
                cursor.moveToNext();


            }

        }
        return theLoaiList ;
    }
}
