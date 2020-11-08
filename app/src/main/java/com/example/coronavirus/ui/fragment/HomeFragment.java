package com.example.coronavirus.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.coronavirus.R;
import com.example.coronavirus.restclient.CoronaClient;
import com.example.coronavirus.restclient.dto.Corona;
import com.example.coronavirus.restclient.dto.Item;
import com.example.coronavirus.ui.CoronaInfo;
import com.example.coronavirus.ui.CoronaStarted;
import com.example.coronavirus.ui.FirstActivity;
import com.example.coronavirus.util.GlobalApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    final static String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.tv_inspection)
    TextView tvInspection;

    @BindView(R.id.tv_cancellation)
    TextView tvCancellation;

    @BindView(R.id.tv_dead)
    TextView tvDead;

    @BindView(R.id.tv_confirmed_person)
    TextView tvConfirmed;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);

        getCorona();
        return root;
    }

    private void init(){
        Item item = GlobalApplication.getInstance().getCorona().getBody().getItems().get(0);
        tvConfirmed.setText(item.getDecideCnt());
        tvCancellation.setText(item.getClearCnt());
        tvInspection.setText(item.getExamCnt());
        tvDead.setText(item.getDeathCnt());
    }

    void getCorona() {
        SimpleDateFormat todayFormat = new SimpleDateFormat("yyyyMMdd");
        CoronaClient.getCoronaService().todayCorona(
                getString(R.string.api_key),
                1,
                5,
                todayFormat.format(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * -1))),
                todayFormat.format(new Date())
        ).enqueue(new Callback<Corona>() {
            @Override
            public void onResponse(Call<Corona> call, Response<Corona> response) {
                if (response.isSuccessful()){
                    GlobalApplication.getInstance().setCorona(response.body());
                    init();
                }else{
                    Toast.makeText(getActivity(), "코로나 서버 요청 실패", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Corona> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @OnClick(R.id.btn_home_disease)
    void diseaseCliCkListener() {
        Log.e(TAG, "diseaseCliCkListener: ");
    }

    @OnClick(R.id.btn_home_first)
    void firstClickListener() {
        Intent intent = new Intent(getActivity(), FirstActivity.class);
        intent.putExtra("name", "형필");
        getActivity().startActivity(intent);
    }

    @OnClick(R.id.btn_home_virus)
    void virusClickListener() {
        startActivity(new Intent(getActivity(), CoronaInfo.class));
    }

    @OnClick(R.id.btn_home_started)
    void startedClickListener() {
        startActivity(new Intent(getActivity(), CoronaStarted.class));
    }

    @OnClick(R.id.btn_home_screening_center)
    void screeningCenterClickListener() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mohw.go.kr/react/popup_200128_3.html")));
    }

}