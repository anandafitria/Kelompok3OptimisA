package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

public class DetailLogbook extends AppCompatActivity {

    private TextView NamaLogbook, NIMLogbook;
    private String yNamaLogbook, yNIMLogbook;
    ImageButton BtnHome, BtnListLogbook, BtnListSeminar, BtnProfil, BtnBack;
    Button BtnResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnResponse = findViewById(R.id.btn_response);

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

        BtnResponse.setOnClickListener(view -> {
            Intent response = new Intent(DetailLogbook.this, ResponKp.class);
            startActivity(response);
        });


        initView();

        Intent terima = getIntent();
        yNamaLogbook = terima.getStringExtra("xNamaLogbook");
        yNIMLogbook = terima.getStringExtra("xNIMLogbook");

        NamaLogbook.setText(yNamaLogbook);
        NIMLogbook.setText(yNIMLogbook);
    }

    private void initView() {
        NamaLogbook = findViewById(R.id.tv_namalogbook);
        NIMLogbook = findViewById(R.id.tv_nimlogbook);
    }
}