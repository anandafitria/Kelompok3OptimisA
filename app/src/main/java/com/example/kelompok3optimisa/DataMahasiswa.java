package com.example.kelompok3optimisa;

import android.graphics.ColorSpace;

import java.util.ArrayList;

public class DataMahasiswa {
    public static String[][] data = new String[][]{
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Ananda Fitria", "2011522014", "Selasa/17 Mei 20021", "11.00-13.00"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Siti Nur Aisah", "2011521018", "Selasa/17 Mei 20021", "11.00-13.00"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Daeng Febrino", "2011522014", "Selasa/17 Mei 20021", "11.00-13.00"},
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

           dataMahasiswa.add(model);
       }

       return dataMahasiswa;
   }
}
