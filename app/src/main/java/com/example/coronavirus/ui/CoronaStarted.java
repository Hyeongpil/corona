package com.example.coronavirus.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coronavirus.R;

import butterknife.ButterKnife;

public class CoronaStarted extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_started);
        setTitle("코로나 발원지");
        ButterKnife.bind(this);
    }
}
