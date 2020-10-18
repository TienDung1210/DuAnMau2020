package com.example.duanmau2020.TheLoai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau2020.Nguoidung.UserDAO;
import com.example.duanmau2020.Nguoidung.UserSQL;
import com.example.duanmau2020.R;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    List<TheLoai> theLoaiList;

    public TheLoaiAdapter(List<TheLoai> theLoaiList) {
        this.theLoaiList = theLoaiList;
    }

    @Override
    public int getCount() {
        return theLoaiList.size();
    }

    @Override
    public TheLoai getItem(int position) {
        return theLoaiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listtheloai,parent,false);
        TextView tvNameTL = view.findViewById(R.id.tvtentheloai);
        TextView tvViTri = view.findViewById(R.id.tvvitri);

        view.findViewById(R.id.imgxoatl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheLoaiDAO theLoaiDAO = new TheLoaiDAO(new TheLoaiSQL(parent.getContext()));
                String username = theLoaiList.get(position).nametheloai ;
                boolean ketqua = theLoaiDAO.delTheloai(username);
                if (ketqua) {
                    Toast.makeText(parent.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    theLoaiList.remove(position);
                    notifyDataSetChanged();

                } else {
                    Toast.makeText(parent.getContext(), "Xoa KHONG Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



        TheLoai theLoai = getItem(position);
        tvViTri.setText(theLoai.vitri);
        tvNameTL.setText(theLoai.nametheloai);
        return view;
    }
}
