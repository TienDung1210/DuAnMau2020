package com.example.duanmau2020.Nguoidung;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duanmau2020.R;

import java.util.List;

public class UserAdapter extends BaseAdapter {
   private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_nguoi_dung,
                parent, false);

        TextView tvName = view.findViewById(R.id.tvname);
        TextView tvNumberplate = view.findViewById(R.id.tvnumberphone);


        final User user = getItem(position);

        tvName.setText(user.fullname);
        tvNumberplate.setText(user.phone);

        view.findViewById(R.id.imgxoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO userDAO = new UserDAO(new UserSQL(parent.getContext()));
                String username = userList.get(position).username ;
                boolean ketqua = userDAO.delete(username);
                if (ketqua) {
                    Toast.makeText(parent.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    userList.remove(position);
                    notifyDataSetChanged();

                } else {
                    Toast.makeText(parent.getContext(), "Xoa KHONG Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });






        return view;
    }
}
