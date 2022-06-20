package com.example.traficapplication.activities.api;

import com.example.traficapplication.activities.models.History;
import com.example.traficapplication.activities.models.ResponseDTO;
import com.example.traficapplication.activities.models.TestHistory;
import com.example.traficapplication.activities.models.TestHistoryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HistoryApi {

    @GET("history/getAll")
    Call<TestHistoryResponse> getHistory();

    @POST("history/add")
    Call<ResponseDTO> saveHistory(@Body History history);
}
