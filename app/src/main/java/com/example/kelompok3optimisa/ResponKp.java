package com.example.kelompok3optimisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResponKp extends AppCompatActivity {

    ImageButton BtnHome, BtnProfil, BtnListLogbook, BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respon_kp);

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(ResponKp.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(ResponKp.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(ResponKp.this, MainActivity.class);
            startActivity(back);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(ResponKp.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });
    }

    public void updateOnClick(View view) {
        Toast.makeText(ResponKp.this, "Berhasil Diupdate", Toast.LENGTH_SHORT).show();
    }

    public void editOnClick(View view) {
        Toast.makeText(ResponKp.this, "Berhasil Diedit", Toast.LENGTH_SHORT).show();
    }
}