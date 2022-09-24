package com.example.kelompok3optimisa;

import android.graphics.ColorSpace;

import java.util.ArrayList;

public class DataLogbook {
    public static String[][] data2 = new String[][]{
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Ananda Fitria", "2011522014"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Siti Nur Aisah", "2011521018"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Daeng Febrino", "2011522014"},
    };

    public static ArrayList<ModelLogbook> ambilDataLogbook() {
        ArrayList<ModelLogbook> dataLogbook = new ArrayList<>();
        for (String[] varData2 : data2) {
            ModelLogbook model = new ModelLogbook();
            model.setFoto(varData2[0]);
            model.setNama_mhs(varData2[1]);
            model.setNim_mhs(varData2[2]);

            dataLogbook.add(model);
        }

        return dataLogbook;
    }
}

