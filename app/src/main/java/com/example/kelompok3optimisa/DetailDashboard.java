package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DetailDashboard extends AppCompatActivity {

    String NamaMain,NimMain, TtlMain, AlamatMain, LokasiKPMain;
    TextView tvNamaMain, tvNimMain, tvTtlMain, tvAlamatMain, tvLokasiKPMain;
    Integer FotoMain;
    ImageView ivFotoMain;
    ImageButton BtnHome, BtnListSeminar, BtnProfil, BtnBack, BtnListLogbook;
    Button BtnLogbookKP, BtnNilaiKP, BtnSeminarKP,BtnPembatalanKP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dashboard);

        Intent detailDashboard = getIntent();
        if(detailDashboard != null){

            FotoMain = detailDashboard.getIntExtra("Foto", 0);
            ivFotoMain = findViewById(R.id.iv_fotomain);
            ivFotoMain.setImageResource(FotoMain);

            NamaMain = detailDashboard.getStringExtra("Nama");
            tvNamaMain = findViewById(R.id.tv_namamain);
            tvNamaMain.setText(NamaMain);

            NimMain = detailDashboard.getStringExtra("NIM");
            tvNimMain = findViewById(R.id.tv_nimmain);
            tvNimMain.setText(NimMain);

            TtlMain = detailDashboard.getStringExtra("TTL");
            tvTtlMain = findViewById(R.id.tv_ttlmain);
            tvTtlMain.setText(TtlMain);

            AlamatMain = detailDashboard.getStringExtra("Alamat");
            tvAlamatMain = findViewById(R.id.tv_alamatmain);
            tvAlamatMain.setText(AlamatMain);

            LokasiKPMain = detailDashboard.getStringExtra("Lokasi KP");
            tvLokasiKPMain = findViewById(R.id.tv_lokasikpmain);
            tvLokasiKPMain.setText(LokasiKPMain);
        }

        BtnHome = findViewById(R.id.btn_home);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnNilaiKP = findViewById(R.id.btn_nilaikp);
        BtnSeminarKP = findViewById(R.id.btn_seminarkp);
        BtnPembatalanKP = findViewById(R.id.btn_pembatalankp);
        BtnLogbookKP = findViewById(R.id.btn_logbookkp);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailDashboard.this, MainActivity.class);
            startActivity(home);
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
            Intent back = new Intent(DetailDashboard.this, DetailLogbook.class);
            startActivity(back);
        });

        BtnListLogbook.setOnClickListener(view -> {
            Intent listlogbook = new Intent(DetailDashboard.this, ListLogbook.class);
            startActivity(listlogbook);
        });

        BtnNilaiKP.setOnClickListener(view -> {
            Intent nilaikp = new Intent(DetailDashboard.this, InputNilai.class);
            startActivity(nilaikp);
        });

        BtnSeminarKP.setOnClickListener(view -> {
            Intent detailseminar = new Intent(DetailDashboard.this, DetailActivity.class);
            startActivity(detailseminar);
        });

        BtnPembatalanKP.setOnClickListener(view -> {
            Toast.makeText(this, "Berhasil Dibatalkan", Toast.LENGTH_SHORT).show();
        });

    }
}