package com.example.coronavirus.util;

import android.app.Activity;
import android.app.Application;

import com.example.coronavirus.restclient.dto.corona.Corona;

public class GlobalApplication extends Application {
    final static String TAG = GlobalApplication.class.getSimpleName();
    private static volatile GlobalApplication instance = null;
    private static volatile Activity currentActivity = null;

    private Corona corona;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Activity getCurrentActivity(){
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity){
        GlobalApplication.currentActivity = currentActivity;
    }
    /**
     * singleton 애플리케이션 객체를 얻는다.
     *
     * @return singleton 애플리케이션 객체
     */
    public static GlobalApplication getInstance() {
        if (instance == null)
            throw new IllegalStateException("this application does not inherit GlobalApplication");
        return instance;
    }



    /**
     * 애플리케이션 종료시 singleton 어플리케이션 객체 초기화한다.
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    public Corona getCorona() {
        return corona;
    }

    public void setCorona(Corona corona) {
        this.corona = corona;
    }
}
