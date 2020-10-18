package com.example.duanmau2020.Nguoidung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duanmau2020.R;

import java.util.List;

public class AddUserActivity extends AppCompatActivity {


    UserSQL userSQL = new UserSQL(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);




    }

    public void Themnguoidung(View view) {
        EditText username = findViewById(R.id.edtNameLogin);
        EditText password = findViewById(R.id.edtPassword);
        EditText phone = findViewById(R.id.edtPhone);
        EditText fullname = findViewById(R.id.edtfullname);


        User user = new User();
            user.username = username.getText().toString().trim();
        user.password = password.getText().toString().trim();
        user.phone = phone.getText().toString().trim();
        user.fullname = fullname.getText().toString().trim();
            UserDAO userDAO = new UserDAO(userSQL);
            boolean ketQua = userDAO.addUser(user);
        if (ketQua) {
            Toast.makeText(this,
                    "THANH CONG!!!", Toast.LENGTH_SHORT).show();



        } else {
            Toast.makeText(this,
                    "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();
        }
    }
}