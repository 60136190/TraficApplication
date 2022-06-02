package com.example.traficapplication.activities.api;

import com.example.traficapplication.activities.models.LoginResponse;
import com.example.traficapplication.activities.models.PasswordUpdate;
import com.example.traficapplication.activities.models.ProfileResponse;
import com.example.traficapplication.activities.models.ResponseDTO;
import com.example.traficapplication.activities.models.UserLogin;
import com.example.traficapplication.activities.models.UserRegister;
import com.example.traficapplication.activities.models.UserUpdate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {
    @POST("user/login")
    Call<LoginResponse> Login(@Body UserLogin userLogin);
    @GET("user/getProfile/{id}")
    Call<ProfileResponse> Profile(@Path("id") String id);
    @POST("user/register")
    Call<LoginResponse> Register(@Body UserRegister userRegister);
    @PATCH("user/updateUser/{id}")
    Call<ResponseDTO> UpdateUser(@Body UserUpdate userUpdate, @Path("id") String id);
    @PATCH("user/changePassword/{id}")
    Call<ResponseDTO> UpdatePass(@Body PasswordUpdate passwordUpdate, @Path("id") String id);




}
