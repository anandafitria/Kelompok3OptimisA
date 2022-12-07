package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ProfilActivity extends AppCompatActivity {

    ImageButton BtnHome, BtnGantiPassword, BtnBack, BtnListLogbook, BtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        BtnHome = findViewById(R.id.btn_home);
        BtnGantiPassword = findViewById(R.id.btn_gantipassword);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnLogout = findViewById(R.id.btn_logout);

        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(ProfilActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(ProfilActivity.this, MainActivity.class);
            startActivity(back);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(ProfilActivity.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnGantiPassword.setOnClickListener(view -> {
            Intent password = new Intent(ProfilActivity.this, GantiPassword.class);
            startActivity(password);
        });

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(ProfilActivity.this, MainActivity.class);
            startActivity(home);
        });
    }
    public void onClickSimpan(View view) {
        Toast.makeText(ProfilActivity.this, "Data Profil berhasil disimpan", Toast.LENGTH_SHORT).show();
        Intent simpan = new Intent(ProfilActivity.this, MainActivity.class);
        startActivity(simpan);
    }
}