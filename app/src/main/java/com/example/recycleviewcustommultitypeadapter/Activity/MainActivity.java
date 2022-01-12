package com.example.recycleviewcustommultitypeadapter.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recycleviewcustommultitypeadapter.Adapter.CustomAdapter;
import com.example.recycleviewcustommultitypeadapter.Model.User;
import com.example.recycleviewcustommultitypeadapter.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }



    private void initView() {
        context = this;
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        refreshAdapter(getUserList());
    }

    private void refreshAdapter(List<User> userList) {
        CustomAdapter adapter = new CustomAdapter(context,userList);
        recyclerView.setAdapter(adapter);
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i==0||i==7||i==27){
                userList.add(new User("Bekhruzbek"+i,"Botirov"+i,true));
            }else{
                userList.add((new User("Uchqun","Azimboyev",false)));
            }
        }
        return userList;
    }
}