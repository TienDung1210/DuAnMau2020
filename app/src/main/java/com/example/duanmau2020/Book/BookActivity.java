package com.example.duanmau2020.Book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.duanmau2020.R;
import com.example.duanmau2020.TheLoai.AddTheLoaiActivity;
import com.example.duanmau2020.TheLoai.TheLoai;
import com.example.duanmau2020.TheLoai.TheLoaiAdapter;
import com.example.duanmau2020.TheLoai.TheLoaiDAO;
import com.example.duanmau2020.TheLoai.TheLoaiSQL;

import java.util.List;

public class BookActivity extends AppCompatActivity {

    ListView lvbook;
    private BookSQL bookSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        lvbook = findViewById(R.id.lvbook);

        bookSQL = new BookSQL(this);
        BookDAO bookDAO = new BookDAO(bookSQL);
        List<Book> bookList =bookDAO.getAllBook();
        BookAdapter bookAdapter = new BookAdapter(bookList);
        lvbook.setAdapter(bookAdapter);





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bookmenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itthembook:
                Intent intent = new Intent(this, AddBookActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}