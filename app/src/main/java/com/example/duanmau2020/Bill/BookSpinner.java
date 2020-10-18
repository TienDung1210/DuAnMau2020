package com.example.duanmau2020.Bill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.duanmau2020.Book.Book;
import com.example.duanmau2020.R;

import java.util.List;

public class BookSpinner extends BaseAdapter {

    private List<Book> bookList;


    public BookSpinner(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_spinnerbook_row, parent, false);

        TextView tvspinerbook = view.findViewById(R.id.spnaddbook);

        Book book =bookList.get(position);

        tvspinerbook.setText(book.tensach);

        return view;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
