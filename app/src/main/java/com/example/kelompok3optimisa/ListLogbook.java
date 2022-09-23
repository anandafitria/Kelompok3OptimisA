package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ListLogbook extends AppCompatActivity {

    ImageButton BtnHome, BtnListSeminar, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        BtnHome = findViewById(R.id.btn_home);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListLogbook.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listseminar = new Intent(ListLogbook.this, ListSeminar.class);
                startActivity(listseminar);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(ListLogbook.this, ProfilActivity.class);
                startActivity(profil);
            }
        });
    }
}