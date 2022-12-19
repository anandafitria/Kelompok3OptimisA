package com.example.kelompok3optimisa.API;

import android.widget.EditText;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded

    @POST("api/login/")
    Call<LoginResponse> login(@Field("NIDN") EditText username, @Field("Password") EditText pasword);

}
