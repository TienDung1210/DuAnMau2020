package com.example.duanmau2020.Bill;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau2020.Book.Book;
import com.example.duanmau2020.Book.BookAdapter;
import com.example.duanmau2020.Book.BookDAO;
import com.example.duanmau2020.Book.BookSQL;
import com.example.duanmau2020.Book.LoaiSachSpinnerAdapter;
import com.example.duanmau2020.R;
import com.example.duanmau2020.TheLoai.TheLoai;
import com.example.duanmau2020.TheLoai.TheLoaiDAO;
import com.example.duanmau2020.TheLoai.TheLoaiSQL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddBillActivity extends AppCompatActivity {

    Book book = null;
    static List<Book> billList = new ArrayList<>();
    static TextView tvMoneyBill;
    Calendar calendar;
    EditText SoLuong;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat simpleDateFormat;
    String Tensach;

    BookSQL bookSQL = new BookSQL(this);
    ListView lvthemhoadon;
    Spinner spinnerbilbook;
    private double GiaTien;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        tvMoneyBill = findViewById(R.id.tvthanhtien);
        final Spinner spinneraddbook = findViewById(R.id.spnbook);
        final EditText edtdate = findViewById(R.id.tvdate);

        final Calendar calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        edtdate.setText(simpleDateFormat.format(calendar.getTime()));

        lvthemhoadon = findViewById(R.id.lvthemhadon);


        final List<Book> bookList = new
                BookDAO(new BookSQL(this)).getAllBook();

        Book vuiLongChon =
                new Book("-1", "--Vui long chon--", "-1", "",1, "", "");
        bookList.add(0, vuiLongChon);


        BookSpinner sachSpinnerAdapter =
                new BookSpinner(bookList);

        spinneraddbook.setAdapter(sachSpinnerAdapter);

        spinneraddbook.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)

                    Tensach = bookList.get(spinneraddbook.getSelectedItemPosition()).tensach;

                else {
                    book = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Ban chua chon Sach", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Datepicker(View view) {
        final EditText edtdate = findViewById(R.id.tvdate);
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int thang = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edtdate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

            }
        }, day, thang, year);
        datePickerDialog.show();

    }

    public static void SetTongTien() {
      double SoLuong =0 ;
        double TongTien = 0;
        for (int i = 0; i < billList.size(); i++) {

            // Tong Tien = Tong Tien + (Gia Tien tai vi tri thu i * SL do người đùng nhập vào)
            TongTien += billList.get(i).giabia * SoLuong;
        }
        tvMoneyBill.setText(TongTien + " " + "VNĐ");
    }

    public void Addhoadon(View view) throws ParseException {







            bookSQL = new BookSQL(this);
            BookDAO bookDAO = new BookDAO(bookSQL);
            List<Book> bookList = bookDAO.getAllBook();
            BookBillAdapter bookAdapter = new BookBillAdapter(bookList);
            lvthemhoadon.setAdapter(bookAdapter);
            SetTongTien();


        }
    }
