package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.kelompok3optimisa.datamodels.GetListLogbookResponse;
import com.example.kelompok3optimisa.datamodels.LogbooksItem;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListLogbook extends AppCompatActivity implements AdapterLogbook.ItemLogbookClickListener {

    private RecyclerView rvLogbook;
    private ArrayList<ModelLogbook> getLogbook = new ArrayList<>();
    private AdapterLogbook adapter;
    ImageButton BtnHome, BtnListLogbook, BtnProfil;
    InterfaceDosen interfaceDosen;
    SharedPreferences sharedPref;
    String gettoken, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("token","");
        Log.d("Listlogbook-Debug", token);

        rvLogbook = findViewById(R.id.rv_logbook);

        AdapterLogbook adapter = new AdapterLogbook(getLogbook());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);

        //Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

        Call<GetListLogbookResponse> call = dosen.getlistlogbook("Bearer " + token);
        call.enqueue(new Callback<GetListLogbookResponse>() {
            @Override
            public void onResponse(Call<GetListLogbookResponse> call, Response<GetListLogbookResponse> response) {

                Log.d("ListLogbook-Debug", response.toString());
                GetListLogbookResponse getListLogbookResponse = response.body();
                if(getListLogbookResponse != null) {
                    List<LogbooksItem> logbooks = getListLogbookResponse.getLogbooks();
                    Log.d("ListLogbook-Debug", String.valueOf(logbooks.size()));
                    adapter.setItemList(logbooks);
                }
            }

            @Override
            public void onFailure(Call<GetListLogbookResponse> call, Throwable t) {
            }

        });

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnListLogbook = findViewById(R.id.btn_logbook);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListLogbook.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(ListLogbook.this, ProfilActivity.class);
                startActivity(profil);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(ListLogbook.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

    }

    //SharedPreferences.Editor editor = sharedPref.edit();
    //editor.putString("TOKEN", token);
    //editor.apply();


    public ArrayList<ModelLogbook> getLogbook() {
        ArrayList<ModelLogbook> dataLogbook = new ArrayList<>();
        dataLogbook.add(new ModelLogbook(
                "Menentukan Jobdesc",
                "Jumat, 06 Oktober 2022"
        ));
        dataLogbook.add(new ModelLogbook(
                "Membuat kerangka masalah",
                "Senin, 09 Januari 2023"
        ));
        return dataLogbook;
    }

    //dataLogbook.add(new ModelLogbook(
    //R.drawable.aii,
    //"Senin/12 Desember 2022",
    //"Siti Nur Aisah",
    //"2011521018",
    //"PT Gojek Indonesia"
    //));

    //dataLogbook.add(new ModelLogbook(
    //R.drawable.daeng,
    //"Selasa/13 Desember 2022",
    //"Daeng Febrino",
    //"2011521019",
    //"PT Shopee Indonesia"
    //));

    //dataLogbook.add(new ModelLogbook(
    //R.drawable.aii,
    //"Selasa/13 Desember 2022",
    //"Siti Nur Aisah",
    //"2011521018",
    //"PT Gojek Indonesia"
    //));

    //dataLogbook.add(new ModelLogbook(
    //R.drawable.nanda,
    //"Rabu/14 Desember 2022",
    //"Ananda Fitria",
    //"2011522014",
    //"PT Semen Padang"
    //));

    //dataLogbook.add(new ModelLogbook(
    //R.drawable.daeng,
    //"Rabu/14 Desember 2022",
    //"Daeng Febrino",
    //"2011521019",
    //"PT Shopee Indonesia"
    //));


    //return dataLogbook;
    //}

    @Override
    public void onItemLogbookClick(LogbooksItem logbooksItem)
    {
        Intent detailLogbook = new Intent(this, DetailLogbook.class);
        detailLogbook.putExtra("Agenda", logbooksItem.getAgenda());
        detailLogbook.putExtra("Tanggal", logbooksItem.getTanggal());
        //detailLogbook.putExtra("Nama", logbook.getNamaLogbook());
        //detailLogbook.putExtra("NIM", logbook.getNimLogbook());
        //detailLogbook.putExtra("Lokasi KP", logbook.getLokasiKPLogbook());
        startActivity(detailLogbook);
    }

    @Override
    public void onBackPressed()
    {
        Intent DetailLogbooklogbook = new Intent(this, DetailLogbook.class);

        DetailLogbooklogbook.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(DetailLogbooklogbook);
        finish();
    }
}
