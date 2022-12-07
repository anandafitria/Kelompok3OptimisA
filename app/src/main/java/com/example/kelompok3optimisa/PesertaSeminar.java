package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class PesertaSeminar extends AppCompatActivity {

    private RecyclerView rvPesertaSeminar;
    private ArrayList<ModelPesertaSeminar> dataPesertaSeminar = new ArrayList<>();
    ImageButton BtnHome, BtnProfil, BtnListLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peserta_seminar);

        rvPesertaSeminar = findViewById(R.id.rv_peserta);
        rvPesertaSeminar.setHasFixedSize(true);

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnListLogbook = findViewById(R.id.btn_logbook);

        AdapterPesertaSeminar adapterPesertaSeminar = new AdapterPesertaSeminar(getPesertaSeminar());
        LinearLayoutManager layoutManagerPesertaSeminar = new LinearLayoutManager(this);

        rvPesertaSeminar.setLayoutManager(layoutManagerPesertaSeminar);
        rvPesertaSeminar.setAdapter(adapterPesertaSeminar);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(PesertaSeminar.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(PesertaSeminar.this, ProfilActivity.class);
                startActivity(profil);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(PesertaSeminar.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

    }

    public ArrayList<ModelPesertaSeminar> getPesertaSeminar() {
        ArrayList<ModelPesertaSeminar> dataPesertaSeminar = new ArrayList<>();

        dataPesertaSeminar.add(new ModelPesertaSeminar(
                "Udin",
                "2011522456"
        ));

        dataPesertaSeminar.add(new ModelPesertaSeminar(
                "Ali",
                "2011522567"
        ));

        dataPesertaSeminar.add(new ModelPesertaSeminar(
                "Mayang",
                "2011522000"
        ));

        dataPesertaSeminar.add(new ModelPesertaSeminar(
                "Syamsudin",
                "2011522333"
        ));

        dataPesertaSeminar.add(new ModelPesertaSeminar(
                "Elon",
                "2011522067"
        ));

        return dataPesertaSeminar;
    }

}