package com.example.kelompok3optimisa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kelompok3optimisa.datamodels.GetDetailLogbookResponse;
import com.example.kelompok3optimisa.datamodels.GetListLogbookResponse;
import com.example.kelompok3optimisa.datamodels.Logbook;
import com.example.kelompok3optimisa.datamodels.LogbooksItem;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailLogbook extends AppCompatActivity {

    String NamaLogbook, NimLogbook, LokasiKPLogbook;
    TextView tvNamaLogbook, tvNimLogbook, tvLokasiKPLogbook;
    Integer FotoLogbook;
    ImageView ivFotoLogbook;
    ImageButton BtnHome, BtnProfil, BtnListLogbook;
    Button BtnResponse;
    String gettoken, token;
    Logbook logbook;
    InterfaceDosen interfaceDosen;
    SharedPreferences sharedPref;
    private AdapterLogbook adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        Intent detailLogbook = getIntent();
        if(detailLogbook != null){


            String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().build())
                    .build();
            InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

            Call<GetDetailLogbookResponse> call = dosen.getDetailLogbook("Bearer " + token);
            call.enqueue(new Callback<GetDetailLogbookResponse>() {
                @Override
                public void onResponse(Call<GetDetailLogbookResponse> call, Response<GetDetailLogbookResponse> response) {

                    Log.d("ListLogbook-Debug", response.toString());
                    GetDetailLogbookResponse getDetailLogbookResponse = response.body();
                    if(getDetailLogbookResponse != null) {
                    }
                }

                @Override
                public void onFailure(Call<GetDetailLogbookResponse> call, Throwable t) {
                }

            });

            FotoLogbook = detailLogbook.getIntExtra("Foto", 0);
            ivFotoLogbook = findViewById(R.id.iv_fotologbook);
            ivFotoLogbook.setImageResource(FotoLogbook);

            NamaLogbook = detailLogbook.getStringExtra("Nama");
            tvNamaLogbook = findViewById(R.id.tv_namalogbook);
            tvNamaLogbook.setText(NamaLogbook);

            NimLogbook = detailLogbook.getStringExtra("NIM");
            tvNimLogbook = findViewById(R.id.tv_nimlogbook);
            tvNimLogbook.setText(NimLogbook);

            LokasiKPLogbook = detailLogbook.getStringExtra("Lokasi KP");
            tvLokasiKPLogbook = findViewById(R.id.tv_lokasikplogbook);
            tvLokasiKPLogbook.setText(LokasiKPLogbook);
        }

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnResponse = findViewById(R.id.btn_response);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailLogbook.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(DetailLogbook.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(DetailLogbook.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent response = new Intent(DetailLogbook.this, ResponKp.class);
                startActivity(response);
            }
        });
    }
}