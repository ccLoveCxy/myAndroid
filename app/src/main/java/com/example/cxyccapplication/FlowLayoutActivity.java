package com.example.cxyccapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FlowLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
        FlowLayout flowLayout = this.findViewById(R.id.flow_layout);
        List<String> data = new ArrayList<>();
        data.add("电脑手机笔记本1");
        data.add("电脑手机笔记本2");
        data.add("电脑手机笔记本3");
        data.add("电脑手机笔记本4");
        data.add("电脑手机笔记本5");
        data.add("电脑手机笔记本6");
        data.add("7电脑手机笔记本");
        data.add("8电脑手机笔记本");
        data.add("9电脑手机笔记本");
        data.add("电脑手机笔记本10");
        data.add("1电脑手机笔记本1");
        data.add("1电脑手机笔记本2");
        data.add("电脑手机笔记本13");
        data.add("电脑手机笔记本14");
        flowLayout.setTextList(data);
    }
}