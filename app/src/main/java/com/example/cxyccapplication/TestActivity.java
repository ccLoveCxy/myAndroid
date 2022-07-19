package com.example.cxyccapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    private String android = "2021-10-13:10:00cccxycx至2021.10.13.9.49";
    private TextView text;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        text = findViewById(R.id.tv_text);
        //字符串截取
//        s = android.substring(0,android.indexOf("至"));
        //字符串转Int
        String mtext = "123";
        String max = "500";
        int a = 200;
        int anInt = Integer.parseInt(mtext);
        if (a > (Integer.parseInt(mtext)) && a < (Integer.parseInt(max))){
            Log.d("ccc","a的值是："+a);
            text.setText(a+"");
        }

//        text.setText(anInt+"");
//        Log.d("ccc",s);

    }
}