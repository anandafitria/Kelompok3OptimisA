package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResponKp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respon_kp);

    }
    public void button3 (View view)
    {
        Toast.makeText(this, "Berhasil Diupdate", Toast.LENGTH_SHORT).show();
    }
    public void button4 (View view)
    {
        Toast.makeText(this, "Berhasil Diedit", Toast.LENGTH_SHORT).show();
    }

}