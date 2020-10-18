package com.example.duanmau2020.Nguoidung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duanmau2020.R;

import java.util.List;

public class UserActivity extends AppCompatActivity {
    ListView lvuser;
    UserSQL userSQL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        lvuser = findViewById(R.id.lvuser);





        userSQL = new UserSQL(this);
        UserDAO userDAO = new UserDAO(userSQL);
        List<User> userList = userDAO.getAllUsers();
        UserAdapter userAdapter = new UserAdapter(userList);
        lvuser.setAdapter(userAdapter);









    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itthem:
                Intent intent = new Intent(this, AddUserActivity.class);
                startActivity(intent);
                break;
            case R.id.itdoimk:

                break;
            case R.id.itdangxuat:
                System.exit(0);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}