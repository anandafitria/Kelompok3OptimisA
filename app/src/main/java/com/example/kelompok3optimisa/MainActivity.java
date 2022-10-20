package com.example.kelompok3optimisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AdapterDashboard.DashboardClickListener{

    private RecyclerView rvDashboard;
    private ArrayList<ModelDashboard> data3 = new ArrayList<>();
    ImageButton BtnListLogbook, BtnListSeminar, BtnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDashboard = findViewById(R.id.rv_dashboard);
        rvDashboard.setHasFixedSize(true);

        AdapterDashboard adapterDashboard = new AdapterDashboard(getDashboard());
        adapterDashboard.setListener(this);
        LinearLayoutManager layoutManagerDashboard = new LinearLayoutManager(this);

        rvDashboard.setLayoutManager(layoutManagerDashboard);
        rvDashboard.setAdapter(adapterDashboard);

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

    public ArrayList<ModelDashboard> getDashboard() {
        ArrayList<ModelDashboard> dataDashboard = new ArrayList<>();

        dataDashboard.add(new ModelDashboard(
                null,
                "Ananda Fitria",
                "2011522014",
                "Padang, 13 Desember 2001",
                "Jalan Situjuh 2 No.10",
                "PT Semen Padang"
        ));

        dataDashboard.add(new ModelDashboard(
                null,
                "Siti Nur Aisah",
                "2011521018",
                "Padang, 16 Oktober 2002",
                "Jalan Irigasi Pasar Baru",
                "PT Gojek Indonesia"
        ));

        dataDashboard.add(new ModelDashboard(
                null,
                "Daeng Febrino",
                "2011521019",
                "Lubuk Sikaping,8 Maret 2002",
                "Jalan Bandes Kampung Dalam",
                "PT Shopee Indonesia"
        ));

        return dataDashboard;
    }

    @Override
    public void onDashboardClick(ModelDashboard dashboard) {
       Intent detailDashboard = new Intent(this, DetailDashboard.class);
       detailDashboard.putExtra("Nama", dashboard.getNamaMain());
       detailDashboard.putExtra("NIM", dashboard.getNimMain());
       detailDashboard.putExtra("TTL", dashboard.getTtlMain());
       detailDashboard.putExtra("Alamat", dashboard.getAlamatMain());
       detailDashboard.putExtra("Lokasi KP", dashboard.getLokasiKPMain());
       startActivity(detailDashboard);
    }
}