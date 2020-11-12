package com.example.coronavirus;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.example.coronavirus.restclient.CoronaClient;
import com.example.coronavirus.restclient.dto.corona.Corona;
import com.example.coronavirus.util.GlobalApplication;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    final static String TAG = MainActivity.class.getSimpleName();

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_behavior)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        getCorona();
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
                }else{
                    Toast.makeText(MainActivity.this, "코로나 서버 요청 실패", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<Corona> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
//
//    @OnClick(R.id.nav_behavior)
//    void onBehaviorClickListener(){
//        Log.e(TAG, "onBehaviorClickListener: " );
//    }


}