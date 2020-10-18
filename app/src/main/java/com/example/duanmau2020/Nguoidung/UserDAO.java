package com.example.duanmau2020.Nguoidung;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private UserSQL userSQL;

    public UserDAO(UserSQL userSQL) {
        this.userSQL = userSQL;
    }


    public boolean addUser(User user){

        SQLiteDatabase sqLiteDatabase = userSQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user.username);
        contentValues.put("password",user.password);
        contentValues.put("phone",user.phone);
        contentValues.put("fullname",user.fullname);

        long kq = sqLiteDatabase.insert("USER",null,contentValues);


        if (kq >0){
            return true;
        }else {
            return false;
        }

    }

    public boolean updateUser(User user){

        SQLiteDatabase sqLiteDatabase = userSQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user.username);
        contentValues.put("password",user.password);
        contentValues.put("phone",user.phone);
        contentValues.put("fullname",user.fullname);

        long kq = sqLiteDatabase.update("USER",contentValues,"username=?",new String[]{user.username});


        if (kq >0){
            return true;
        }else {
            return false;
        }

    }

    public boolean delete(String username){

        SQLiteDatabase sqLiteDatabase = userSQL.getWritableDatabase();


        long kq = sqLiteDatabase.delete("USER","username=?",new String[]{username});


        if (kq >0){
            return true;
        }else {
            return false;
        }

    }


    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM USER ";
        Cursor cursor = userSQL.getReadableDatabase().rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String username = cursor.getString(0);
                String password = cursor.getString(1);
                String phone = cursor.getString(2);
                String fullname = cursor.getString(3);

                User user = new User();
                user.username =username;
                user.password =password;
                user.phone = phone;
                user.fullname = fullname;

                userList.add(user);
                cursor.moveToNext();


            }

        }
        return userList;
    }

}
