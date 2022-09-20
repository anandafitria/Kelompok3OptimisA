package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailKP extends AppCompatActivity {

    ImageButton BtnBack;
    Button BtnLogbook, BtnInputNilai, BtnSeminarKP,BtnPembatalanKP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kp);

        BtnBack = findViewById(R.id.btn_back);
        BtnLogbook = findViewById(R.id.btn_logbookkp);
        BtnInputNilai = findViewById(R.id.btn_nilaikp);
        BtnSeminarKP = findViewById(R.id.btn_seminarkp);
        BtnPembatalanKP = findViewById(R.id.btn_pembatalankp);

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DetailKP.this, MainActivity.class);
                startActivity(back);
            }
        });

        BtnLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logbook = new Intent (DetailKP.this, ListLogbook.class);
                startActivity(logbook);
            }
        });

        BtnInputNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inputnilai = new Intent (DetailKP.this, InputNilai.class);
                startActivity(inputnilai);
            }
        });

        BtnSeminarKP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seminarkp = new Intent (DetailKP.this, SeminarKP.class);
                startActivity(seminarkp);
            }
        });

        BtnPembatalanKP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pembatalankp = new Intent (DetailKP.this, PembatalanKP.class);
                startActivity(pembatalankp);
            }
        });
    }
}