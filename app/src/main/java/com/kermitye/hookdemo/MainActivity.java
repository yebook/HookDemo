package com.kermitye.hookdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

// Created by kermitye on 2019/7/16 16:09
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.mTvText);
        tv.setText(getInfoText());
    }

    public String getInfoText() {
        return "未破解的哟";
    }
}
