package com.example.kelompok3optimisa;

import android.graphics.ColorSpace;

import java.util.ArrayList;

public class DataMahasiswa {
    public static String[][] data = new String[][]{
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Ananda Fitria", "2011522014", "Selasa/17 Mei 20021", "11.00-13.00", "Ruang Sidang Jurusan SI"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Siti Nur Aisah", "2011521018", "Rabu/18 Mei 20021", "08.00-10.00", "Ruang Sidang Jurusan SI"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Daeng Febrino", "2011521019", "Jumat/20 Mei 20021", "14.00-16.00", "Ruang Sidang Jurusan SI"},
    };

   public static ArrayList<ModelMahasiswa> ambilDataMahasiswa() {
       ArrayList<ModelMahasiswa> dataMahasiswa = new ArrayList<>();
       for (String[] varData : data) {
           ModelMahasiswa model = new ModelMahasiswa();
           model.setFoto(varData[0]);
           model.setNamamhs(varData[1]);
           model.setNimmhs(varData[2]);
           model.setHaritanggal(varData[3]);
           model.setPukul(varData[4]);
           model.setRuang(varData[5]);

           dataMahasiswa.add(model);
       }

       return dataMahasiswa;
   }
}
