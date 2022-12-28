package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.kelompok3optimisa.datamodels.LogoutResponse;
import com.example.kelompok3optimisa.retrofit.ApiClient;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {

    ImageButton BtnHome, BtnGantiPassword, BtnBack, BtnListLogbook, BtnLogout;
    InterfaceDosen interfaceDosen;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        interfaceDosen = ApiClient.getClient().create(InterfaceDosen.class);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String token = sharedPref.getString("TOKEN", "");

        BtnHome = findViewById(R.id.btn_home);
        BtnGantiPassword = findViewById(R.id.btn_gantipassword);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnLogout = findViewById(R.id.btn_logout);

        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<LogoutResponse> call = interfaceDosen.logout("Bearer " + token);

                call.enqueue(new Callback<LogoutResponse>() {
                    @Override
                    public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                        LogoutResponse logoutResponse = response.body();
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.remove("TOKEN");
                        editor.apply();
                        finish();
                        Toast.makeText(ProfilActivity.this,"Successfully Log Out", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProfilActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<LogoutResponse> call, Throwable t) {

                    }
                });
            }
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(ProfilActivity.this, MainActivity.class);
            startActivity(back);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(ProfilActivity.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnGantiPassword.setOnClickListener(view -> {
            Intent password = new Intent(ProfilActivity.this, GantiPassword.class);
            startActivity(password);
        });

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(ProfilActivity.this, MainActivity.class);
            startActivity(home);
        });
    }
    public void onClickSimpan(View view) {
        Toast.makeText(ProfilActivity.this, "Data Profil berhasil disimpan", Toast.LENGTH_SHORT).show();
        Intent simpan = new Intent(ProfilActivity.this, MainActivity.class);
        startActivity(simpan);
    }
}