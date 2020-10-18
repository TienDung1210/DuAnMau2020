package com.example.duanmau2020.TheLoai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.duanmau2020.Nguoidung.AddUserActivity;
import com.example.duanmau2020.Nguoidung.User;
import com.example.duanmau2020.Nguoidung.UserAdapter;
import com.example.duanmau2020.Nguoidung.UserDAO;
import com.example.duanmau2020.Nguoidung.UserSQL;
import com.example.duanmau2020.R;

import java.util.List;

public class TheLoaiActivity extends AppCompatActivity {
    ListView lvthloai;
    TheLoaiSQL theLoaiSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        lvthloai = findViewById(R.id.lvtheloai);




        theLoaiSQL = new TheLoaiSQL(this);
        TheLoaiDAO theLoaiDAO = new TheLoaiDAO(theLoaiSQL);
        List<TheLoai> theLoaiList =theLoaiDAO.getAllTheloai();
        TheLoaiAdapter theLoaiAdapter = new TheLoaiAdapter(theLoaiList);
        lvthloai.setAdapter(theLoaiAdapter);






    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theloaimenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itthemtheloai:
                Intent intent = new Intent(this, AddTheLoaiActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}