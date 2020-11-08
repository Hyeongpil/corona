package com.example.coronavirus.restclient;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CoronaClient {

    public static CoronaService getCoronaService(){
        return getInstance().create(CoronaService.class);
    }

    private static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl("http://openapi.data.go.kr/openapi/service/rest/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }
}
