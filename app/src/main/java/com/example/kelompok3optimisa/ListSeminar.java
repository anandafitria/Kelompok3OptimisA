package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ListSeminar extends AppCompatActivity implements AdapterSeminar.SeminarClickListener {

    private RecyclerView rvSeminar;
    private ArrayList<ModelSeminar> dataSeminar = new ArrayList<>();
    ImageButton BtnHome, BtnListLogbook, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);

        rvSeminar = findViewById(R.id.rv_seminar);
        rvSeminar.setHasFixedSize(true);

        AdapterSeminar adapterSeminar = new AdapterSeminar(getSeminar());
        adapterSeminar.setListener(this);
        LinearLayoutManager layoutManagerSeminar = new LinearLayoutManager(this);

        rvSeminar.setLayoutManager(layoutManagerSeminar);
        rvSeminar.setAdapter(adapterSeminar);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnProfil = findViewById(R.id.btn_profil);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListSeminar.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(ListSeminar.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(ListSeminar.this, ProfilActivity.class);
                startActivity(profil);
            }
        });
    }

    public ArrayList<ModelSeminar> getSeminar() {
        ArrayList<ModelSeminar> dataSeminar = new ArrayList<>();

        dataSeminar.add(new ModelSeminar(
                R.drawable.nanda,
                "Ananda Fitria",
                "2011522014",
                "Selasa/17 Mei 2021" ,
                "11.00 - 13.00",
                "Ruang Sidang Jurusan SI"
        ));

        dataSeminar.add(new ModelSeminar(
                R.drawable.aii,
                "Ananda Fitria",
                "2011521018",
                "Rabu/18 Mei 2021" ,
                "08.00 - 11.00",
                "Ruang Sidang Jurusan SI"
        ));

        dataSeminar.add(new ModelSeminar(
                R.drawable.daeng,
                "Daeng Febrino",
                "2011521019",
                "Jumat/20 Mei 2021" ,
                "14.00 - 16.00",
                "Ruang Sidang Jurusan SI"
        ));

        return dataSeminar;
    }

    @Override
    public void onSeminarClick(ModelSeminar seminar) {
        Intent detailSeminar = new Intent(this, DetailSeminar.class);
        detailSeminar.putExtra("Foto", seminar.getFotoSeminar());
        detailSeminar.putExtra("Nama", seminar.getNamaSeminar());
        detailSeminar.putExtra("NIM", seminar.getNimSeminar());
        detailSeminar.putExtra("Hari", seminar.getHariSeminar());
        detailSeminar.putExtra("Jam", seminar.getJamSeminar());
        detailSeminar.putExtra("Ruangan", seminar.getRuangSeminar());
        startActivity(detailSeminar);
    }
}