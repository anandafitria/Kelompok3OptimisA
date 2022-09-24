package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class DetailKP extends AppCompatActivity {

    ImageButton BtnBack, BtnHome, BtnListLogbook, BtnListSeminar, BtnProfil;
    Button BtnLogbook, BtnInputNilai, BtnSeminarKP,BtnPembatalanKP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kp);

        BtnBack = findViewById(R.id.btn_back);
        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnLogbook = findViewById(R.id.btn_logbookkp);
        BtnInputNilai = findViewById(R.id.btn_nilaikp);
        BtnSeminarKP = findViewById(R.id.btn_seminarkp);
        BtnPembatalanKP = findViewById(R.id.btn_pembatalankp);

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DetailKP.this, MainActivity.class);
                startActivity(back);
            }
        });

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(DetailKP.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list_logbook = new Intent(DetailKP.this, ListLogbook.class);
                startActivity(list_logbook);
            }
        });

        BtnListSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list_seminar = new Intent(DetailKP.this, ListSeminar.class);
                startActivity(list_seminar);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(DetailKP.this, ProfilActivity.class);
                startActivity(profil);
            }
        });

        BtnLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logbook = new Intent (DetailKP.this, LaporanKp.class);
                startActivity(logbook);
            }
        });

        BtnInputNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inputnilai = new Intent (DetailKP.this, InputNilai.class);
                startActivity(inputnilai);
            }
        });

        BtnSeminarKP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seminarkp = new Intent (DetailKP.this, DetailActivity.class);
                startActivity(seminarkp);
            }
        });

    }
}