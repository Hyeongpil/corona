package com.example.coronavirus.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coronavirus.R;

import butterknife.ButterKnife;

public class CoronaNews extends AppCompatActivity {
    final static String TAG = CoronaNews.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_news);
        setTitle("코로나 뉴스");
        ButterKnife.bind(this);
    }

}
