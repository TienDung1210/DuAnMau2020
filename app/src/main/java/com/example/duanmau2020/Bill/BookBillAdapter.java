package com.example.duanmau2020.Bill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duanmau2020.Book.Book;
import com.example.duanmau2020.R;

import java.util.List;

public class BookBillAdapter extends BaseAdapter {

    List<Book> bookList;

    public BookBillAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Book getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listbookbill,parent,false);
        TextView tvtensach = view.findViewById(R.id.tvtensach);
        TextView tvsoluong = view.findViewById(R.id.tvsoluong);
        TextView tvgiatien = view.findViewById(R.id.tvgiatien);

        Book book = getItem(position);

        tvtensach.setText(book.tensach);
        tvsoluong.setText(book.soluong);
        tvgiatien.setText(book.tacgia);


        return view;
    }
}
