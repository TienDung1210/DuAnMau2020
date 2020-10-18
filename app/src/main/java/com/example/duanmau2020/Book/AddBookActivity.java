package com.example.duanmau2020.Book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duanmau2020.R;
import com.example.duanmau2020.TheLoai.AddTheLoaiActivity;
import com.example.duanmau2020.TheLoai.TheLoai;
import com.example.duanmau2020.TheLoai.TheLoaiDAO;
import com.example.duanmau2020.TheLoai.TheLoaiSQL;

import java.util.List;

public class AddBookActivity extends AppCompatActivity {

    TheLoai theLoai =null;
    BookSQL bookSQL = new BookSQL(AddBookActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Spinner spinner = findViewById(R.id.sptheloaisach);

        final List<TheLoai> theLoaiList = new
                TheLoaiDAO(new TheLoaiSQL(this)).getAllTheloai();

        TheLoai vuiLongChon =
                new TheLoai("-1", "--Vui long chon--", "-1");
        theLoaiList.add(0, vuiLongChon);


        LoaiSachSpinnerAdapter sachSpinnerAdapter =
                new LoaiSachSpinnerAdapter(theLoaiList);

        spinner.setAdapter(sachSpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    theLoai = theLoaiList.get(i);
                else {
                    theLoai = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void addbook(View view) {
        Spinner spinner = findViewById(R.id.sptheloaisach);

        EditText edttensach = findViewById(R.id.edttensach);
        EditText edttacgia= findViewById(R.id.edttacgia);
        EditText edtnhaxuatban = findViewById(R.id.edtnxb);
        EditText edtgiabia = findViewById(R.id.edtgiabia);
        EditText edtsoluong = findViewById(R.id.edtsoluong);


        Book book = new Book();

        book.tensach = edttensach.getText().toString().trim();
        book.tacgia = edttacgia.getText().toString().trim();
        book.nhaxuatban = edtnhaxuatban.getText().toString().trim();
        book.giabia = Double.parseDouble(edtgiabia.getText().toString().trim());
        book.soluong = edtsoluong.getText().toString().trim();



        BookDAO bookDAO = new BookDAO(bookSQL);

        boolean kq = bookDAO.addbook(book);
        if (kq) {
            Toast.makeText(this,
                    "THANH CONG ROI!!!", Toast.LENGTH_SHORT).show();



        } else {
            Toast.makeText(this,
                    "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();
        }


    }

    public void Spntheloai(View view) {

        Intent intent = new Intent(this, AddTheLoaiActivity.class);
        startActivity(intent);
    }
}