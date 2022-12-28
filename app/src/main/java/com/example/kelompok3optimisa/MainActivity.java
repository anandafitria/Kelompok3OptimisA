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


public class MainActivity extends AppCompatActivity implements AdapterDashboard.DashboardClickListener{

    private  boolean isLoogedIn = false;

    private RecyclerView rvDashboard;
    private ArrayList<ModelDashboard> dataDashboard = new ArrayList<>();
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


        rvDashboard = findViewById(R.id.rv_dashboard);
        rvDashboard.setHasFixedSize(true);

        AdapterDashboard adapterDashboard = new AdapterDashboard(getDashboard());
        adapterDashboard.setListener(this);
        LinearLayoutManager layoutManagerDashboard = new LinearLayoutManager(this);

        rvDashboard.setLayoutManager(layoutManagerDashboard);
        rvDashboard.setAdapter(adapterDashboard);

        BtnProfil = findViewById(R.id.btn_profil);
        BtnHome = findViewById(R.id.btn_home);
        BtnListLogbook = findViewById(R.id.btn_logbook);

        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivity.this, MainActivity.class);
                startActivity(home);
            }
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(MainActivity.this, ListLogbook.class);
                startActivity(listlogbook);
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
                R.drawable.nanda,
                "Ananda Fitria",
                "2011522014",
                "Padang, 13 Desember 2001",
                "Jalan Situjuh 2 No.10",
                "PT Semen Padang"
        ));

        dataDashboard.add(new ModelDashboard(
                R.drawable.aii,
                "Siti Nur Aisah",
                "2011521018",
                "Padang, 16 Oktober 2002",
                "Jalan Irigasi Pasar Baru",
                "PT Gojek Indonesia"
        ));

        dataDashboard.add(new ModelDashboard(
                R.drawable.daeng,
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
       detailDashboard.putExtra("Foto", dashboard.getFotoMain());
       detailDashboard.putExtra("Nama", dashboard.getNamaMain());
       detailDashboard.putExtra("NIM", dashboard.getNimMain());
       detailDashboard.putExtra("TTL", dashboard.getTtlMain());
       detailDashboard.putExtra("Alamat", dashboard.getAlamatMain());
       detailDashboard.putExtra("Lokasi KP", dashboard.getLokasiKPMain());
       startActivity(detailDashboard);
    }
}