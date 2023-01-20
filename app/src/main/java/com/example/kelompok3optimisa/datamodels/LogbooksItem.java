package com.example.kelompok3optimisa.datamodels;

import com.google.gson.annotations.SerializedName;

public class LogbooksItem{

    @SerializedName("date")
    private String date;

    @SerializedName("note")
    private Object note;

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

    @SerializedName("status")
    private int status;

    public String getDate(){
        return date;
    }

    public Object getNote(){
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

    public int getStatus(){
        return status;
    }
}