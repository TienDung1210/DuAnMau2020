package com.example.duanmau2020.TheLoai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau2020.R;

public class AddTheLoaiActivity extends AppCompatActivity {
            TheLoaiSQL theLoaiSQL = new TheLoaiSQL( AddTheLoaiActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_the_loai);
    }

    public void Themtl(View view) {

        EditText edtnametheloai = findViewById(R.id.edttentheloai);
        EditText vitri = findViewById(R.id.edtvitri);
        EditText mota = findViewById(R.id.edtmota);


        TheLoai theLoai = new TheLoai();

        theLoai.nametheloai = edtnametheloai.getText().toString().trim();
        theLoai.vitri = vitri.getText().toString().trim();
        theLoai.mota = mota.getText().toString().trim();
        TheLoaiDAO  theLoaiDAO = new TheLoaiDAO(theLoaiSQL);
        boolean kq = theLoaiDAO.addTheloai(theLoai);
        if (kq) {
            Toast.makeText(this,
                    "THANH CONG ROI!!!", Toast.LENGTH_SHORT).show();



        } else {
            Toast.makeText(this,
                    "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();
        }

    }
}