package com.example.kelompok3optimisa.room;

import androidx.room.Dao;
import androidx.room.Insert;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);
}

