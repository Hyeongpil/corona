package com.example.coronavirus.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coronavirus.R;

import butterknife.ButterKnife;

public class CoronaInfo extends AppCompatActivity {
    final static String TAG = CoronaInfo.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_info);
        setTitle("감염병 정보");
        ButterKnife.bind(this);
    }

}
