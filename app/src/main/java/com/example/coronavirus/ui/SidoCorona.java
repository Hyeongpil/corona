package com.example.coronavirus.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirus.R;
import com.example.coronavirus.restclient.CoronaClient;
import com.example.coronavirus.restclient.dto.sido.Sido;
import com.example.coronavirus.ui.adapter.SidoAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SidoCorona extends AppCompatActivity {
    final static String TAG = SidoCorona.class.getSimpleName();

    @BindView(R.id.rv_sido)
    RecyclerView rvSido;

    private SidoAdapter sidoAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sido_corona);
        ButterKnife.bind(this);
        setTitle("시도별 코로나 확진자 수");

        init();

        getSidoData();
    }

    void init(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvSido.setLayoutManager(linearLayoutManager);

        sidoAdapter = new SidoAdapter();
        rvSido.setAdapter(sidoAdapter);
    }

    void getSidoData(){
        SimpleDateFormat todayFormat = new SimpleDateFormat("yyyyMMdd");
        CoronaClient.getCoronaService().sidoCorona(
                getString(R.string.api_key),
                1,
                10,
                todayFormat.format(new Date()),
                todayFormat.format(new Date())).enqueue(new Callback<Sido>() {
            @Override
            public void onResponse(Call<Sido> call, Response<Sido> response) {
                if(response.isSuccessful()){
                    sidoAdapter.setData(response.body().getBody().getItems());
                }else{
                    Toast.makeText(SidoCorona.this, "서버 통신 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Sido> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
