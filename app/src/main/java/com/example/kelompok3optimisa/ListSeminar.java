package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ListSeminar extends AppCompatActivity {

    private RecyclerView rvMahasiswa;
    private ArrayList<ModelMahasiswa> data = new ArrayList<>();
    ImageButton BtnHome, BtnListLogbook, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);

        rvMahasiswa = findViewById(R.id.rv_mahasiswa);
        rvMahasiswa.setHasFixedSize(true);

        data.addAll(DataMahasiswa.ambilDataMahasiswa());
        tampilDataCard();

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

    private void tampilDataCard() {
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard colokanCard = new AdapterCard(data);
        rvMahasiswa.setAdapter(colokanCard);

        colokanCard.setOnItemClickCallBack(new AdapterCard.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelMahasiswa data) {
                Intent pindah = new Intent(ListSeminar.this, DetailActivity.class);
                pindah.putExtra("xNama", data.getNamamhs());
                pindah.putExtra("xNIM", data.getNimmhs());
                pindah.putExtra("xHari", data.getHaritanggal());
                pindah.putExtra("xPukul", data.getPukul());
                pindah.putExtra("xRuang",data.getRuang());
                startActivity(pindah);
            }
        });
    }
}