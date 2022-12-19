package com.example.kelompok3optimisa.API;

import com.example.kelompok3optimisa.room.User;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("hhttp://ptb-api.husnilkamil.my.id/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static UserService getService(){
        UserService userService = getRetrofit().create(UserService.class);

        return userService;

    }
}
