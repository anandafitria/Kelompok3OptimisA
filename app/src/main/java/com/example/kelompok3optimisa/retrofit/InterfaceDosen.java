package com.example.kelompok3optimisa.retrofit;

import com.example.kelompok3optimisa.datamodels.ApprovePesertaSeminar;
import com.example.kelompok3optimisa.datamodels.GetProfilResponse;
import com.example.kelompok3optimisa.datamodels.LoginResponse;
import com.example.kelompok3optimisa.datamodels.LogoutResponse;
import com.example.kelompok3optimisa.datamodels.RejectPesertaSeminar;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface InterfaceDosen {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login (@Field("username") String username, @Field("password") String password);

    @GET("api/me")
    Call<GetProfilResponse> getProfile(@Header("Authorization") String token);

    @POST("api/logout/")
    Call<LogoutResponse> logout(@Header("token")String token);

    @PATCH("api/internship-students/1/approve-audiences")
    Call<ApprovePesertaSeminar> approvePesertaSeminar();

    @PATCH("api/internship-students/1/reject-audiences")
    Call<RejectPesertaSeminar> rejectPesertaSeminar();
}
