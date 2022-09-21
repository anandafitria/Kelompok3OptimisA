package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListSeminar extends AppCompatActivity {
    private ListView lvListMahasiswa;
    private ListMahasiswaAdapter adapter;

    private TypedArray dataFoto;
    private String[] dataNama;
    private String[] dataNIM;
    private String[] dataHariTanggal;
    private String[] dataJam;
    private String[] dataPenguji;

    private ArrayList<ListMahasiswa> listmhs;

    public ListSeminar() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);

        lvListMahasiswa = findViewById(R.id.listmahasiswa);
        adapter = new ListMahasiswaAdapter( this);
        lvListMahasiswa.setAdapter(adapter);

        tampungData();
        tambahData();
    }

    private void tampungData() {
        dataFoto = getResources().obtainTypedArray(R.array.fotomhs);
        dataNama = getResources().getStringArray(R.array.namamhs);
        dataNIM = getResources().getStringArray(R.array.nimmhs);
        dataHariTanggal = getResources().getStringArray(R.array.hariseminar);
        dataJam = getResources().getStringArray(R.array.jamseminar);
        dataPenguji = getResources().getStringArray(R.array.pengujiseminar);
    }

    private void tambahData() {
        listmhs = new ArrayList<>();

        for (int i = 0; i < dataNama.length; i++) {
            ListMahasiswa listmhs = new ListMahasiswa();

            listmhs.setFoto(dataFoto.getResourceId(i, -1));
            listmhs.setNama(dataNama[i]);
            listmhs.setNIM(dataNIM[i]);
            listmhs.setHariTanggal(dataHariTanggal[i]);
            listmhs.setJam(dataJam[i]);
            listmhs.setPenguji((dataPenguji[i]));

            listmhs.add(listmhs);
        }

        adapter.setListmhs(listmhs);
    }
}