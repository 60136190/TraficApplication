package com.example.traficapplication.activities.api;

import com.example.traficapplication.activities.models.InfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("product")
    Call<InfoResponse> getAllData();

    @GET("product/{id_sp}")
    Call<InfoResponse> getSpData(@Path("id_sp") String id);

}
