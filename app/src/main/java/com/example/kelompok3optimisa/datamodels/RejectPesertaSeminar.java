package com.example.kelompok3optimisa.datamodels;

import com.google.gson.annotations.SerializedName;

public class RejectPesertaSeminar{

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public String getMessage(){
        return message;
    }

    public String getStatus(){
        return status;
    }
}