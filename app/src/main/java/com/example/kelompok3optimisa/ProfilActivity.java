package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ProfilActivity extends AppCompatActivity {

    ImageButton BtnHome, BtnListLogbook, BtnListSeminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(ProfilActivity.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnListSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listseminar = new Intent(ProfilActivity.this, ListSeminar.class);
                startActivity(listseminar);
            }
        });
    }
}