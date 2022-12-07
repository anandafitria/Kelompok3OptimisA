package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class GantiPassword extends AppCompatActivity {

    ImageButton BtnHome, BtnListLogbook, BtnProfil, BtnBack, BtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_password);

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_editprofil);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnLogout = findViewById(R.id.btn_logout);

        BtnLogout.setOnClickListener(view ->{
            Intent logout = new Intent(GantiPassword.this,LoginActivity.class);
            startActivity(logout);
        });
        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(GantiPassword.this, MainActivity.class);
            startActivity(back);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(GantiPassword.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(GantiPassword.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnHome.setOnClickListener(view ->

            {
                Intent home = new Intent(GantiPassword.this, MainActivity.class);
                startActivity(home);
            });

        }

        public void onClickSimpan(View view) {
        Toast.makeText(GantiPassword.this, "Password berhasil diubah", Toast.LENGTH_SHORT).show();
        Intent simpan = new Intent(GantiPassword.this, ProfilActivity.class);
        startActivity(simpan);
    }
}