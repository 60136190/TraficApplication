package com.example.traficapplication.activities.api;

import com.example.traficapplication.activities.models.ResponseInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("product")
    Call<ResponseInfo> getAllData();
}
