package com.example.kelompok3optimisa;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResponKp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respon_kp);
    }

    public void updateOnClick(View view) {
        Toast.makeText(ResponKp.this, "Berhasil Diupdate", Toast.LENGTH_SHORT).show();
    }

    public void editOnClick(View view) {
        Toast.makeText(ResponKp.this, "Berhasil Diedit", Toast.LENGTH_SHORT).show();
    }
}