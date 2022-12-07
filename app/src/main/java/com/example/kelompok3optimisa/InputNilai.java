package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InputNilai extends AppCompatActivity {

    ImageButton BtnHome, BtnProfil, BtnBack, BtnListLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai);

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);


        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(InputNilai.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(InputNilai.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(InputNilai.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(InputNilai.this, MainActivity.class);
            startActivity(back);
        });

    }
}