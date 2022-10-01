package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailDashboard extends AppCompatActivity {

    private TextView NamaMain, NimMain;
    private String yNamaMain, yNimMain;
    ImageButton BtnHome, BtnListLogbook, BtnListSeminar, BtnProfil, BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dashboard);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailDashboard.this, MainActivity.class);
            startActivity(home);
        });

        BtnListLogbook.setOnClickListener(view -> {
            Intent listlogbook = new Intent(DetailDashboard.this, ListLogbook.class);
            startActivity(listlogbook);
        });

        BtnListSeminar.setOnClickListener(view -> {
            Intent listseminar = new Intent(DetailDashboard.this, ListSeminar.class);
            startActivity(listseminar);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(DetailDashboard.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(DetailDashboard.this, MainActivity.class);
            startActivity(back);
        });

        initView();

        Intent terima = getIntent();
        yNamaMain = terima.getStringExtra("xNamaMain");
        yNimMain = terima.getStringExtra("xNimMain");

        NamaMain.setText(yNamaMain);
        NimMain.setText(yNimMain);
    }

    private void initView() {
        NamaMain = findViewById(R.id.tv_namamain);
        NimMain = findViewById(R.id.tv_nimmain);
    }
}