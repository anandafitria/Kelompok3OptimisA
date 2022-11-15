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
    ImageButton BtnHome, BtnListSeminar, BtnProfil, BtnListLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        Intent detailSeminar = getIntent();
        if(detailSeminar != null){

            FotoSeminar = detailSeminar.getIntExtra("Foto", 0);
            ivFotoSeminar = findViewById(R.id.iv_fotoseminar);
            ivFotoSeminar.setImageResource(FotoSeminar);

            NamaSeminar = detailSeminar.getStringExtra("Nama");
            tvNamaSeminar = findViewById(R.id.tv_namaseminar);
            tvNamaSeminar.setText(NamaSeminar);

            NimSeminar = detailSeminar.getStringExtra("NIM");
            tvNimSeminar = findViewById(R.id.tv_nimseminar);
            tvNimSeminar.setText(NimSeminar);

            HariSeminar = detailSeminar.getStringExtra("Hari");
            tvHariSeminar = findViewById(R.id.tv_hariseminar);
            tvHariSeminar.setText(HariSeminar);

            JamSeminar = detailSeminar.getStringExtra("Jam");
            tvJamSeminar = findViewById(R.id.tv_jamseminar);
            tvJamSeminar.setText(JamSeminar);

            RuangSeminar = detailSeminar.getStringExtra("Ruangan");
            tvRuangSeminar = findViewById(R.id.tv_ruangseminar);
            tvRuangSeminar.setText(RuangSeminar);
        }

        BtnHome = findViewById(R.id.btn_home);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnBerita = findViewById(R.id.btn_beritaacara);
        BtnPesertaSeminar = findViewById(R.id.btn_pesertaseminar);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailSeminar.this, MainActivity.class);
            startActivity(home);
        });

        BtnListSeminar.setOnClickListener(view -> {
            Intent listseminar = new Intent(DetailSeminar.this, ListSeminar.class);
            startActivity(listseminar);
        });

        BtnListLogbook.setOnClickListener(view -> {
            Intent listlogbook = new Intent(DetailSeminar.this, ListLogbook.class);
            startActivity(listlogbook);
        });


        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(DetailSeminar.this, ProfilActivity.class);
            startActivity(profil);
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