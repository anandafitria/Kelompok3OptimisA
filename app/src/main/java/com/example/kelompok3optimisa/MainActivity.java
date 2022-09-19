package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton BtnLogbook, BtnSeminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnLogbook = findViewById(R.id.btn_logbook);
        BtnSeminar = findViewById(R.id.btn_seminar);

        BtnLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailkp = new Intent(MainActivity.this, DetailKP.class);
                startActivity(detailkp);
            }
        });

        BtnSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seminarkp = new Intent(MainActivity. this, ListSeminar.class);
                startActivity(seminarkp);
            }
        });
    }
}