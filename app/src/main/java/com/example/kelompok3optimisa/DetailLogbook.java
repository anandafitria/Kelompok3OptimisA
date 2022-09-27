package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailLogbook extends AppCompatActivity {

    private TextView NamaLogbook, NIMLogbook;
    private String yNamaLogbook, yNIMLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        initView();

        Intent terima = getIntent();
        yNamaLogbook = terima.getStringExtra("xNamaLogbook");
        yNIMLogbook = terima.getStringExtra("xNIMLogbook");

        NamaLogbook.setText(yNamaLogbook);
        NIMLogbook.setText(yNIMLogbook);
    }

    private void initView() {
        NamaLogbook = findViewById(R.id.tv_namalogbook);
        NIMLogbook = findViewById(R.id.tv_nimlogbook);
    }
}