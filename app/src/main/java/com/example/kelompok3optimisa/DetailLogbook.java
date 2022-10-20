package com.example.kelompok3optimisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailLogbook extends AppCompatActivity {

    String NamaLogbook, NimLogbook, LokasiKPLogbook;
    TextView tvNamaLogbook, tvNimLogbook, tvLokasiKPLogbook;
    Integer FotoLogbook;
    ImageView ivFotoLogbook;
    ImageButton BtnHome, BtnListLogbook, BtnListSeminar, BtnProfil, BtnBack;
    Button BtnResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);
        BtnResponse = findViewById(R.id.btn_response);
        Intent detailLogbook = getIntent();
        if(detailLogbook != null){

            FotoLogbook = detailLogbook.getIntExtra("Foto", 0);
            ivFotoLogbook = findViewById(R.id.iv_fotologbook);
            ivFotoLogbook.setImageResource(FotoLogbook);

            NamaLogbook = detailLogbook.getStringExtra("Nama");
            tvNamaLogbook = findViewById(R.id.tv_namalogbook);
            tvNamaLogbook.setText(NamaLogbook);

            NimLogbook = detailLogbook.getStringExtra("NIM");
            tvNimLogbook = findViewById(R.id.tv_nimlogbook);
            tvNimLogbook.setText(NimLogbook);

            LokasiKPLogbook = detailLogbook.getStringExtra("Lokasi KP");
            tvLokasiKPLogbook = findViewById(R.id.tv_lokasikplogbook);
            tvLokasiKPLogbook.setText(LokasiKPLogbook);
        }

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailLogbook.this, MainActivity.class);
            startActivity(home);
        });

        BtnListLogbook.setOnClickListener(view -> {
            Intent listlogbook = new Intent(DetailLogbook.this, ListLogbook.class);
            startActivity(listlogbook);
        });

        BtnListSeminar.setOnClickListener(view -> {
            Intent listseminar = new Intent(DetailLogbook.this, ListSeminar.class);
            startActivity(listseminar);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(DetailLogbook.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(DetailLogbook.this, DetailDashboard.class);
            startActivity(back);
        });

        BtnResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent response = new Intent(DetailLogbook.this, ResponKp.class);
                startActivity(response);
            }
        });
    }
}