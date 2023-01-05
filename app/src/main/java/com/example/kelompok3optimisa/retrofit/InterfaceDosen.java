package com.example.kelompok3optimisa.retrofit;

import com.example.kelompok3optimisa.datamodels.GetDetailLogbookResponse;
import com.example.kelompok3optimisa.datamodels.GetListLogbookResponse;
import com.example.kelompok3optimisa.datamodels.GetProfilResponse;
import com.example.kelompok3optimisa.datamodels.LoginResponse;
import com.example.kelompok3optimisa.datamodels.LogoutResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InterfaceDosen {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login (@Field("username") String username, @Field("password") String password);

    @GET("api/my-internship/2/logbook")
    Call<GetListLogbookResponse> getlistlogbook(@Header("Authorization") String token);

    @GET("api/my-internship/2/logbook/1")
    Call<GetDetailLogbookResponse> getDetailLogbook(@Header("Authorization") String token);

    @GET("api/me")
    Call<GetProfilResponse> getProfile(@Header("Authorization") String token);

    @POST("api/logout/")
    Call<LogoutResponse> logout(@Header("token")String token);

}

