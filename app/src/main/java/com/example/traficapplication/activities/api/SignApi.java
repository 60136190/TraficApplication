package com.example.traficapplication.activities.api;

import com.example.traficapplication.activities.models.InfoResponse;
import com.example.traficapplication.activities.models.SignResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SignApi {
    @GET("product")
    Call<InfoResponse> getAllData();

    @GET("product/{id_sp}")
    Call<InfoResponse> getSpData(@Path("id_sp") String id);

    @GET("trafficSign/getAll")
    Call<SignResponse> getSign();
    @GET("trafficSign/getTrafficSignFollowIdCategory/628201977b71473bad5e2816")
    Call<SignResponse> getAuxiliarySign();
     @GET("trafficSign/getTrafficSignFollowIdCategory/628200c77b71473bad5e2814")
    Call<SignResponse> getProhibitSign();

     @GET("trafficSign/getDetail/{id}")
    Call<SignResponse> getDetail(@Path("id") String id);



//    @GET("trafficSign/getTrafficSignFollowIdCategory/628201977b71473bad5e2816")
//    Call<SignResponse> getAuxiliarySign();
//    @GET("trafficSign/getTrafficSignFollowIdCategory/628201977b71473bad5e2816")
//    Call<SignResponse> getAuxiliarySign();
}
