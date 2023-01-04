package com.example.kelompok3optimisa.retrofit;

import com.example.kelompok3optimisa.datamodels.ApprovePesertaSeminar;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://ptb-api.husnilkamil.my.id/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}

