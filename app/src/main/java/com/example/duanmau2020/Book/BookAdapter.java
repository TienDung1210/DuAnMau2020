package com.example.duanmau2020.Book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau2020.R;
import com.example.duanmau2020.TheLoai.TheLoaiDAO;
import com.example.duanmau2020.TheLoai.TheLoaiSQL;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
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
    public View getView(final int position, View convertView, final ViewGroup parent) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listbook,parent,false);
        TextView tvtensach = view.findViewById(R.id.tvtensach);
        TextView tvtentagia = view.findViewById(R.id.tvtentacgia);



        view.findViewById(R.id.imgxoabook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDAO theLoaiDAO = new BookDAO(new BookSQL(parent.getContext()));
                String username = bookList.get(position).tensach ;
                boolean ketqua = theLoaiDAO.delTheloai(username);
                if (ketqua) {
                    Toast.makeText(parent.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    bookList.remove(position);
                    notifyDataSetChanged();

                } else {
                    Toast.makeText(parent.getContext(), "Xoa KHONG Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        Book book = getItem(position);




        tvtensach.setText(book.tensach);
        tvtentagia.setText(book.tacgia);


        return view;
    }
}
