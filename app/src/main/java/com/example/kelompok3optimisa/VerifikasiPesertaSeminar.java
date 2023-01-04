package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kelompok3optimisa.datamodels.ApprovePesertaSeminar;
import com.example.kelompok3optimisa.datamodels.LogoutResponse;
import com.example.kelompok3optimisa.datamodels.RejectPesertaSeminar;
import com.example.kelompok3optimisa.retrofit.ApiClient;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifikasiPesertaSeminar extends AppCompatActivity {

    String NamaPeserta, NimPeserta;
    TextView tvNamaPeserta, tvNimPeserta;
    ImageButton BtnHome, BtnProfil, BtnListLogbook;
    Button BtnAccept, BtnReject;
    InterfaceDosen interfaceDosen;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_peserta_seminar);

        interfaceDosen = ApiClient.getClient().create(InterfaceDosen.class);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String token = sharedPref.getString("TOKEN", "");

        Intent detailVerifPeserta = getIntent();
        if(detailVerifPeserta != null){

            NamaPeserta = detailVerifPeserta.getStringExtra("Nama");
            tvNamaPeserta = findViewById(R.id.tv_namapeserta);
            tvNamaPeserta.setText(NamaPeserta);

            NimPeserta = detailVerifPeserta.getStringExtra("NIM");
            tvNimPeserta = findViewById(R.id.tv_nimpeserta);
            tvNimPeserta.setText(NimPeserta);
        }

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnAccept = findViewById(R.id.btn_verifya);
        BtnReject = findViewById(R.id.btn_verifga);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(VerifikasiPesertaSeminar.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(VerifikasiPesertaSeminar.this, ProfilActivity.class);
            startActivity(profil);
        });


        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(VerifikasiPesertaSeminar.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ApprovePesertaSeminar> call = interfaceDosen.approvePesertaSeminar("Bearer " + token);

                call.enqueue(new Callback<ApprovePesertaSeminar>() {
                    @Override
                    public void onResponse(Call<ApprovePesertaSeminar> call, Response<ApprovePesertaSeminar> response) {
                        ApprovePesertaSeminar approvePesertaSeminar = response.body();
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.remove("TOKEN");
                        editor.apply();
                        finish();
                        Toast.makeText(VerifikasiPesertaSeminar.this,"Mahasiswa Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(VerifikasiPesertaSeminar.this, PesertaSeminar.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ApprovePesertaSeminar> call, Throwable t) {
                    }
                });
            }
        });

        BtnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<RejectPesertaSeminar> call = interfaceDosen.rejectPesertaSeminar("Bearer " + token);

                call.enqueue(new Callback<RejectPesertaSeminar>() {
                    @Override
                    public void onResponse(Call<RejectPesertaSeminar> call, Response<RejectPesertaSeminar> response) {
                        RejectPesertaSeminar rejectPesertaSeminar = response.body();
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.remove("TOKEN");
                        editor.apply();
                        finish();
                        Toast.makeText(VerifikasiPesertaSeminar.this,"Mahasiswa Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(VerifikasiPesertaSeminar.this, PesertaSeminar.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<RejectPesertaSeminar> call, Throwable t) {
                    }
                });
            }
        });
    }
}