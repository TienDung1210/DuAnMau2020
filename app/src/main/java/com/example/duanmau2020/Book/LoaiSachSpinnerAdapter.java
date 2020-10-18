package com.example.duanmau2020.Book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duanmau2020.R;
import com.example.duanmau2020.TheLoai.TheLoai;

import java.util.List;



public class LoaiSachSpinnerAdapter extends BaseAdapter {

    public LoaiSachSpinnerAdapter(List<TheLoai> theLoaiSaches) {
        this.theLoaiSaches = theLoaiSaches;
    }

    private List<TheLoai> theLoaiSaches;


    @Override
    public int getCount() {
        return theLoaiSaches.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_spinner_row, viewGroup, false);

        TextView tvContent = view.findViewById(R.id.textView);

       TheLoai theLoaiSach  = theLoaiSaches.get(i);
        tvContent.setText(theLoaiSach.nametheloai);
        return view;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
