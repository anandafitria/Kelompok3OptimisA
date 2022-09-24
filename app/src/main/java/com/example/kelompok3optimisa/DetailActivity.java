package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private TextView Nama, NIM, Hari, Pukul, Ruang;
    private String yNama, yNIM, yHari, yPukul, yRuang;
    Button BtnBerita;
    ImageButton BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        BtnBack = findViewById(R.id.btn_back);
        BtnBerita = findViewById(R.id.btn_beritaacara);

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DetailActivity.this, ListSeminar.class);
                startActivity(back);
            }
        });

        BtnBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent berita = new Intent(DetailActivity.this, BeritaAcaraKP.class);
                startActivity(berita);
            }
        });

        initView();

        Intent terima = getIntent();
        yNama = terima.getStringExtra("xNama");
        yNIM = terima.getStringExtra("xNIM");
        yHari = terima.getStringExtra("xHari");
        yPukul = terima.getStringExtra("xPukul");
        yRuang = terima.getStringExtra("xRuang");

        Nama.setText(yNama);
        NIM.setText(yNIM);
        Hari.setText(yHari);
        Pukul.setText(yPukul);
        Ruang.setText(yRuang);


    }

    private void initView() {
        Nama = findViewById(R.id.tv_namamhs);
        NIM = findViewById(R.id.tv_nimmhs);
        Hari = findViewById(R.id.tv_haritanggal);
        Pukul = findViewById(R.id.tv_pukul);
        Ruang = findViewById(R.id.tv_ruang);
    }
}