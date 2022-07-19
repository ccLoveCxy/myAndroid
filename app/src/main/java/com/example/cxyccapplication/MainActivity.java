package com.example.cxyccapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button commit;
    RecyclerView list;
    private MlistAdapter mlistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.rv_list);
        commit = findViewById(R.id.btn_commit1);
        commit.setOnClickListener(this);
        mlistAdapter = new MlistAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(layoutManager);
        list.setAdapter(mlistAdapter);
       mlistAdapter.setListener(new MlistAdapter.OnMyItemClickListener() {
           @Override
           public void myClick(String text, int position) {
               Log.d("ccc","点击的值是:"+text);
           }
       });



    }


    @Override
    public void onClick(View v) {


    }


}