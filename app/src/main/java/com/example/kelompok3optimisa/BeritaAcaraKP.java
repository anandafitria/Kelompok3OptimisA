package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BeritaAcaraKP extends AppCompatActivity {

    ImageButton BtnBack, BtnHome, BtnListLogbook, BtnListSeminar, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_acara_kp);

        BtnBack = findViewById(R.id.btn_back);
        BtnBack = findViewById(R.id.btn_back);
        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(BeritaAcaraKP.this, ListSeminar.class);
                startActivity(back);
            }
        });

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(BeritaAcaraKP.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detaillogbook = new Intent(BeritaAcaraKP.this, DetailLogbook.class);
                startActivity(detaillogbook);
            }
        });

        BtnListSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list_seminar = new Intent(BeritaAcaraKP.this, ListSeminar.class);
                startActivity(list_seminar);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(BeritaAcaraKP.this, ProfilActivity.class);
                startActivity(profil);
            }
        });
    }
}