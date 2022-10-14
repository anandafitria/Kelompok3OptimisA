package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class DetailDashboard extends AppCompatActivity {

    private TextView NamaMain, NimMain, TtlMain, AlamatMain, LokasiKPMain;
    private String yNamaMain, yNimMain, yTtlMain, yAlamatMain, yLokasiKPMain;
    ImageButton BtnHome, BtnListLogbook, BtnListSeminar, BtnProfil, BtnBack;
    Button BtnLogbookKP, BtnNilaiKP, BtnSeminarKP, BtnPembatalanKP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dashboard);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnLogbookKP = findViewById(R.id.btn_logbookkp);
        BtnNilaiKP = findViewById(R.id.btn_nilaikp);
        BtnSeminarKP = findViewById(R.id.btn_seminarkp);
        BtnPembatalanKP = findViewById(R.id.btn_pembatalankp);

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

        BtnLogbookKP.setOnClickListener(view -> {
            Intent detaillogbook = new Intent(DetailDashboard.this, DetailLogbook.class);
            startActivity(detaillogbook);
        });

        BtnNilaiKP.setOnClickListener(view ->  {
            Intent nilaikp = new Intent(DetailDashboard.this, InputNilai.class);
            startActivity(nilaikp);
        });

        BtnSeminarKP.setOnClickListener(view -> {
            Intent detailseminar = new Intent(DetailDashboard.this, DetailActivity.class);
            startActivity(detailseminar);
        });

        initView();

        Intent terima = getIntent();
        yNamaMain = terima.getStringExtra("xNamaMain");
        yNimMain = terima.getStringExtra("xNimMain");
        yTtlMain = terima.getStringExtra("xTtlMain");
        yAlamatMain = terima.getStringExtra("xAlamatMain");
        yLokasiKPMain = terima.getStringExtra("xLokasiKPMain");

        NamaMain.setText(yNamaMain);
        NimMain.setText(yNimMain);
        TtlMain.setText(yTtlMain);
        AlamatMain.setText(yAlamatMain);
        LokasiKPMain.setText(yLokasiKPMain);
    }

    private void initView() {
        NamaMain = findViewById(R.id.tv_namamain);
        NimMain = findViewById(R.id.tv_nimmain);
        TtlMain = findViewById(R.id.tv_ttlmain);
        AlamatMain = findViewById(R.id.tv_alamatmain);
        LokasiKPMain = findViewById(R.id.tv_lokasikpmain);
    }
}