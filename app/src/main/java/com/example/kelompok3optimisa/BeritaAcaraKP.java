package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BeritaAcaraKP extends AppCompatActivity {

    ImageButton BtnBack, BtnHome, BtnProfil, BtnListLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_acara_kp);

        BtnBack = findViewById(R.id.btn_back);
        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnListLogbook = findViewById(R.id.btn_logbook);

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(BeritaAcaraKP.this, DetailSeminar.class);
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
                Intent listlogbook = new Intent(BeritaAcaraKP.this, ListLogbook.class);
                startActivity(listlogbook);
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