package com.example.kelompok3optimisa.API;

import android.media.MediaSession2;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("LoginResult")
    private  LoginResult loginResult;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private static String message;

    public LoginResult getLoginResult() {return  loginResult;}

    public boolean isError() {
        return error;
    }

    public static String getMessage() {
        return message;
    }
}
