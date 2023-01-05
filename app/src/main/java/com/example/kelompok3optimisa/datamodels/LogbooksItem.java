package com.example.kelompok3optimisa.datamodels;

import com.google.gson.annotations.SerializedName;

public class LogbooksItem{

    @SerializedName("date")
    private String date;

    @SerializedName("note")
    private String note;

    @SerializedName("internship_id")
    private int internshipId;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("activities")
    private String activities;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("agenda")
    private String agenda;

    @SerializedName("tanggal")
    private String tanggal;

    public String getDate(){
        return date;
    }

    public String getNote(){
        return note;
    }

    public int getInternshipId(){
        return internshipId;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getActivities(){
        return activities;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public int getId(){
        return id;
    }

    public String getAgenda(){
        return agenda;
    }

    public String getTanggal(){
        return tanggal;
    }
}