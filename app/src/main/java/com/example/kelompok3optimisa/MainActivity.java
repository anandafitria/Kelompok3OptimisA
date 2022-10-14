package com.example.kelompok3optimisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDashboard;
    private ArrayList<ModelDashboard> data3 = new ArrayList<>();
    ImageButton BtnListLogbook, BtnListSeminar, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDashboard = findViewById(R.id.rv_dashboard);
        rvDashboard.setHasFixedSize(true);

        data3.addAll(DataDashboard.ambilDataDashboard());
        tampilDataDashboard();

        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnListSeminar = findViewById(R.id.btn_seminar);
        BtnProfil = findViewById(R.id.btn_profil);

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(MainActivity.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnListSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listseminar = new Intent(MainActivity. this, ListSeminar.class);
                startActivity(listseminar);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(profil);
            }
        });
    }

    private void tampilDataDashboard() {
        rvDashboard.setLayoutManager(new LinearLayoutManager(this));
        AdapterDashboard colokanDashboard = new AdapterDashboard(data3);
        rvDashboard.setAdapter(colokanDashboard);

        colokanDashboard.setOnItemClickCallBack(new AdapterDashboard.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelDashboard data3) {
                Intent pindah = new Intent(MainActivity.this, DetailDashboard.class);
                pindah.putExtra("xNamaMain", data3.getNamaMain());
                pindah.putExtra("xNimMain", data3.getNimMain());
                pindah.putExtra("xTtlMain", data3.getTtlMain());
                pindah.putExtra("xAlamatMain", data3.getAlamatMain());
                pindah.putExtra("xLokasiKPMain", data3.getLokasiKPMain());
                startActivity(pindah);
            }
        });
    }
}