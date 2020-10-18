package com.example.duanmau2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duanmau2020.Bill.BillActivity;
import com.example.duanmau2020.Book.BookActivity;
import com.example.duanmau2020.Nguoidung.UserActivity;
import com.example.duanmau2020.TheLoai.TheLoaiActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void User(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    public void Theloai(View view) {
        Intent intent = new Intent(this, TheLoaiActivity.class);
        startActivity(intent);
    }

    public void Book(View view) {
        Intent intent = new Intent(this, BookActivity.class);
        startActivity(intent);

    }

    public void HoaDon(View view) {
        Intent intent = new Intent(this, BillActivity.class);
        startActivity(intent);
    }
}