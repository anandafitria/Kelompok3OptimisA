package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ProfilActivity extends AppCompatActivity {

    ImageButton BtnHome, BtnListLogbook, BtnListSeminar, BtnGantiPassword, BtnBack, BtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnGantiPassword = findViewById(R.id.btn_gantipassword);
        BtnBack = findViewById(R.id.btn_back);
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
    public void onClickSimpan(View view) {
        Toast.makeText(ProfilActivity.this, "Data Profil berhasil disimpan", Toast.LENGTH_SHORT).show();
        Intent simpan = new Intent(ProfilActivity.this, MainActivity.class);
        startActivity(simpan);
    }
}