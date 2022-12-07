package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ListLogbook extends AppCompatActivity implements AdapterLogbook.LogbookClickListener {

    private RecyclerView rvLogbook;
    private ArrayList<ModelLogbook> dataLogbook = new ArrayList<>();
    ImageButton BtnHome, BtnListLogbook, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        rvLogbook = findViewById(R.id.rv_logbook);
        rvLogbook.setHasFixedSize(true);

        AdapterLogbook adapterLogbook = new AdapterLogbook(getLogbook());
        adapterLogbook.setListener(this);
        LinearLayoutManager layoutManagerLogbook = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManagerLogbook);
        rvLogbook.setAdapter(adapterLogbook);

        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnProfil = findViewById(R.id.btn_profil);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListLogbook.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(ListLogbook.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(ListLogbook.this, ProfilActivity.class);
                startActivity(profil);
            }
        });
    }

    public ArrayList<ModelLogbook> getLogbook() {
        ArrayList<ModelLogbook> dataLogbook = new ArrayList<>();

        dataLogbook.add(new ModelLogbook(
                R.drawable.nanda,
                "Senin/12 Desember 2022",
                "Ananda Fitria",
                "2011522014",
                "PT Semen Padang"
        ));

        dataLogbook.add(new ModelLogbook(
                R.drawable.aii,
                "Senin/12 Desember 2022",
                "Siti Nur Aisah",
                "2011521018",
                "PT Gojek Indonesia"
        ));

        dataLogbook.add(new ModelLogbook(
                R.drawable.daeng,
                "Selasa/13 Desember 2022",
                "Daeng Febrino",
                "2011521019",
                "PT Shopee Indonesia"
        ));

        dataLogbook.add(new ModelLogbook(
                R.drawable.aii,
                "Selasa/13 Desember 2022",
                "Siti Nur Aisah",
                "2011521018",
                "PT Gojek Indonesia"
        ));

        dataLogbook.add(new ModelLogbook(
                R.drawable.nanda,
                "Rabu/14 Desember 2022",
                "Ananda Fitria",
                "2011522014",
                "PT Semen Padang"
        ));

        dataLogbook.add(new ModelLogbook(
                R.drawable.daeng,
                "Rabu/14 Desember 2022",
                "Daeng Febrino",
                "2011521019",
                "PT Shopee Indonesia"
        ));


        return dataLogbook;
    }

    @Override
    public void onLogbookClick(ModelLogbook logbook) {
        Intent detailLogbook = new Intent(this, DetailLogbook.class);
        detailLogbook.putExtra("Foto", logbook.getFotoLogbook());
        detailLogbook.putExtra("Hari", logbook.getHariTglLogbook());
        detailLogbook.putExtra("Nama", logbook.getNamaLogbook());
        detailLogbook.putExtra("NIM", logbook.getNimLogbook());
        detailLogbook.putExtra("Lokasi KP", logbook.getLokasiKPLogbook());
        startActivity(detailLogbook);
    }
}
