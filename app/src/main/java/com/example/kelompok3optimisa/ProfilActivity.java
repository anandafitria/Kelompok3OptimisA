package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class ProfilActivity extends AppCompatActivity {

    ImageButton BtnHome, BtnListLogbook, BtnListSeminar, BtnGantiPassword, BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnGantiPassword = findViewById(R.id.btn_gantipassword);
        BtnBack = findViewById(R.id.btn_back);

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(ProfilActivity.this, MainActivity.class);
            startActivity(back);
        });

        BtnGantiPassword.setOnClickListener(view -> {
            Intent password = new Intent(ProfilActivity.this, GantiPassword.class);
            startActivity(password);
        });

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(ProfilActivity.this, MainActivity.class);
            startActivity(home);
        });

        BtnListLogbook.setOnClickListener(view -> {
            Intent listlogbook = new Intent(ProfilActivity.this, ListLogbook.class);
            startActivity(listlogbook);
        });

        BtnListSeminar.setOnClickListener(view -> {
            Intent listseminar = new Intent(ProfilActivity.this, ListSeminar.class);
            startActivity(listseminar);
        });
    }
}