package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSeminar extends AppCompatActivity {

    String NamaSeminar, NimSeminar, HariSeminar, JamSeminar, RuangSeminar;
    TextView tvNamaSeminar, tvNimSeminar, tvHariSeminar, tvJamSeminar, tvRuangSeminar;
    Integer FotoSeminar;
    ImageView ivFotoSeminar;
    Button BtnBerita, BtnPesertaSeminar;
    ImageButton BtnHome, BtnProfil, BtnListLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnBerita = findViewById(R.id.btn_beritaacara);
        BtnPesertaSeminar = findViewById(R.id.btn_pesertaseminar);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailSeminar.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(DetailSeminar.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnListLogbook.setOnClickListener(view -> {
            Intent listlogbook = new Intent(DetailSeminar.this, ListLogbook.class);
            startActivity(listlogbook);
        });

        BtnBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent berita = new Intent(DetailSeminar.this, BeritaAcaraKP.class);
                startActivity(berita);
            }
        });

        BtnPesertaSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent berita = new Intent(DetailSeminar.this, PesertaSeminar.class);
                startActivity(berita);
            }
        });
    }

}