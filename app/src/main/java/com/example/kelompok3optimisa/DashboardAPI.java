package com.example.kelompok3optimisa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelompok3optimisa.datamodels.GetProfilResponse;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;


public class DashboardAPI extends AppCompatActivity implements AdapterDashboardAPI.DashboardAPIClickListener{

    private  boolean isLoogedIn = false;

    private RecyclerView rvDashboardAPI;
    private ArrayList<ModelDashboardAPI> dataDashboardAPI = new ArrayList<>();
    ImageButton BtnListLogbook, BtnListSeminar, BtnProfil, BtnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN","");
        Log.d("ListMahasiswa-Debug", token);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("TOKEN", token);
        editor.apply();

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen client = retrofit.create(InterfaceDosen.class);

        Call<GetProfilResponse> login = client.getProfile("Bearer " + token);
        login.enqueue(new Callback<GetProfilResponse>() {
            @Override
            public void onResponse(Call<GetProfilResponse> call, Response<GetProfilResponse> response) {
                Log.d("ProfileAct-Debug", response.toString());
                GetProfilResponse getProfileResponse = response.body();
                if(getProfileResponse != null){
                    String nip = getProfileResponse.getUsername();
                    String name = getProfileResponse.getName();
                    String email = getProfileResponse.getEmail();

                    Log.d("ProfileAct-Debug", nip + " : " + name + " : " + email);

                }
            }

            @Override
            public void onFailure(Call<GetProfilResponse> call, Throwable t) {

            }
        });


        rvDashboardAPI = findViewById(R.id.rv_dashboard);
        rvDashboardAPI.setHasFixedSize(true);

        AdapterDashboardAPI adapterDashboardAPI = new AdapterDashboardAPI(getDashboardAPI());
        adapterDashboardAPI.setListener(this);
        LinearLayoutManager layoutManagerDashboardAPI = new LinearLayoutManager(this);

        rvDashboardAPI.setLayoutManager(layoutManagerDashboardAPI);
        rvDashboardAPI.setAdapter(adapterDashboardAPI);

        BtnProfil = findViewById(R.id.btn_profil);
        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(DashboardAPI.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(DashboardAPI.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(DashboardAPI.this, ProfilActivity.class);
                startActivity(profil);
            }
        });
    }

    public ArrayList<ModelDashboardAPI> getDashboardAPI() {
        ArrayList<ModelDashboardAPI> dataDashboardAPI = new ArrayList<>();

        dataDashboardAPI.add(new ModelDashboardAPI(
                R.drawable.nanda,
                "Ananda Fitria",
                "2011522014",
                "Padang, 13 Desember 2001",
                "Jalan Situjuh 2 No.10",
                "PT Semen Padang"
        ));

        dataDashboardAPI.add(new ModelDashboardAPI(
                R.drawable.aii,
                "Siti Nur Aisah",
                "2011521018",
                "Padang, 16 Oktober 2002",
                "Jalan Irigasi Pasar Baru",
                "PT Gojek Indonesia"
        ));

        dataDashboardAPI.add(new ModelDashboardAPI(
                R.drawable.daeng,
                "Daeng Febrino",
                "2011521019",
                "Lubuk Sikaping,8 Maret 2002",
                "Jalan Bandes Kampung Dalam",
                "PT Shopee Indonesia"
        ));

        return dataDashboardAPI;
    }

    @Override
    public void onDashboardAPIClick(ModelDashboardAPI dashboardAPI) {
        Intent detailDashboardAPI = new Intent(this, DetailDashboard.class);
        detailDashboardAPI.putExtra("Foto", dashboardAPI.getFotoDashboard());
        detailDashboardAPI.putExtra("Nama", dashboardAPI.getNamaDashboard());
        detailDashboardAPI.putExtra("NIM", dashboardAPI.getNimDashboard());
        detailDashboardAPI.putExtra("TTL", dashboardAPI.getTtlDashboard());
        detailDashboardAPI.putExtra("Alamat", dashboardAPI.getAlamatDashboard());
        detailDashboardAPI.putExtra("Lokasi KP", dashboardAPI.getLokasiKPDashboard());
        startActivity(detailDashboardAPI);
    }
}