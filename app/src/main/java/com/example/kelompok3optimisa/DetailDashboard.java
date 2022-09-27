package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailDashboard extends AppCompatActivity {

    private TextView NamaMain, NimMain;
    private String yNamaMain, yNimMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dashboard);

        initView();

        Intent terima = getIntent();
        yNamaMain = terima.getStringExtra("xNamaMain");
        yNimMain = terima.getStringExtra("xNimMain");

        NamaMain.setText(yNamaMain);
        NimMain.setText(yNimMain);
    }

    private void initView() {
        NamaMain = findViewById(R.id.tv_namamain);
        NimMain = findViewById(R.id.tv_nimmain);
    }
}