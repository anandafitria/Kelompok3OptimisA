package com.example.kelompok3optimisa.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "NIDN")
    public String NIDN;

    @ColumnInfo(name = "password")
    public String password;
}

