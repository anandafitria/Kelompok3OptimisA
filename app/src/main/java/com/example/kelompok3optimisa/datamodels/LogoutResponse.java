package com.example.kelompok3optimisa.datamodels;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse{

    @SerializedName("message")
    private String message;

    public String getMessage(){
        return message;
    }
}