package com.example.coronavirus.restclient;

import com.example.coronavirus.restclient.dto.corona.Corona;
import com.example.coronavirus.restclient.dto.sido.Sido;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoronaService {

    @GET("Covid19/getCovid19InfStateJson")
    Call<Corona> todayCorona(@Query(value = "ServiceKey", encoded = true) String ServiceKey,
                             @Query("pageNo") int pageNo,
                             @Query("numOfRows") int numOfRows,
                             @Query("startCreateDt") String startCreateDt,
                             @Query("endCreateDt") String endCreateDt);

    @GET("Covid19/getCovid19SidoInfStateJson")
    Call<Sido> sidoCorona(@Query(value = "ServiceKey", encoded = true) String ServiceKey,
                          @Query("pageNo") int pageNo,
                          @Query("numOfRows") int numOfRows,
                          @Query("startCreateDt") String startCreateDt,
                          @Query("endCreateDt") String endCreateDt);
}
