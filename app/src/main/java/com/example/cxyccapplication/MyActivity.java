package com.example.cxyccapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MyActivity extends AppCompatActivity implements InputNumberView.OnNumbetChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        InputNumberView inputNumberView = this.findViewById(R.id.inputnumber);
        inputNumberView.setOnNumbetChangeListener(this);

    }

    @Override
    public void OnNumberChange(int value) {

    }
}