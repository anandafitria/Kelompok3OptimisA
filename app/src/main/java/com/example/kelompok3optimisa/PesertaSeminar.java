package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PesertaSeminar extends AppCompatActivity {

    private RecyclerView rvPesertaSeminar;
    ImageButton BtnBack, BtnHome, BtnListLogbook, BtnListSeminar, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peserta_seminar);

        rvPesertaSeminar = findViewById(R.id.rv_peserta);
        rvPesertaSeminar.setHasFixedSize(true);

        BtnBack = findViewById(R.id.btn_back);
        BtnBack = findViewById(R.id.btn_back);
        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(PesertaSeminar.this, MainActivity.class);
                startActivity(back);
            }
        });

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(PesertaSeminar.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detaillogbook = new Intent(PesertaSeminar.this, DetailLogbook.class);
                startActivity(detaillogbook);
            }
        });

        BtnListSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list_seminar = new Intent(PesertaSeminar.this, ListSeminar.class);
                startActivity(list_seminar);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(PesertaSeminar.this, ProfilActivity.class);
                startActivity(profil);
            }
        });
    }
}