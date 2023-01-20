package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.kelompok3optimisa.datamodels.ListLogbookResponse;
import com.example.kelompok3optimisa.datamodels.LogbooksItem;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class LogbookPribadi extends AppCompatActivity implements AdapterLogPribadi.ItemLogPribadiClickListener{

    private RecyclerView rvLogPribadi;
    private AdapterLogPribadi adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook_pribadi);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        SharedPreferences sharedPreferences = getSharedPreferences("mahaprefs", Context.MODE_PRIVATE);
        int id = sharedPreferences.getInt("id", 5);
        Log.d("ListLogbook-Debug", token);

        rvLogPribadi = findViewById(R.id.rv_logpribadi);
        rvLogPribadi.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterLogPribadi();
        adapter.setListener(this);
        rvLogPribadi.setAdapter(adapter);

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

        Call<ListLogbookResponse> call = dosen.listlogbook("Bearer " + token + id);
        call.enqueue(new Callback<ListLogbookResponse>() {
            @Override
            public void onResponse(Call<ListLogbookResponse> call, Response<ListLogbookResponse> response) {
                Log.d("ListLogbook-Debug", response.toString());
                ListLogbookResponse listLogbookResponse = response.body();
                if(listLogbookResponse != null){
                    List<LogbooksItem> logbooks = listLogbookResponse.getLogbooks();
                    Log.d("ListLogbook-Debug", String.valueOf(logbooks.size()));
                    Log.d("list-book-debug", "respon : " + logbooks);
                    adapter.setItemList(logbooks);
                }
            }

            @Override
            public void onFailure(Call<ListLogbookResponse> call, Throwable t) {
                Toast.makeText(LogbookPribadi.this,"logbook Tidak Ada", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onItemLogPribadiClick(LogbooksItem logbooks) {
        Intent detailIntent = new Intent(this, LogbookPribadi.class);
        detailIntent.putExtra("ID", logbooks.getId());
        detailIntent.putExtra("TANGGAL", logbooks.getDate());
        detailIntent.putExtra("AKTIFITAS", logbooks.getActivities());
        startActivity(detailIntent);
    }

}