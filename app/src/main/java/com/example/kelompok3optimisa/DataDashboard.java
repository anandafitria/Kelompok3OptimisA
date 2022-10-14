package com.example.kelompok3optimisa;

import android.graphics.ColorSpace;

import java.util.ArrayList;

public class DataDashboard {
    public static String[][] data3 = new String[][]{
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Ananda Fitria", "2011522014", "Padang, 13-12-2001", "Jln. Situjuh II No.10", "PT. Shopee Indonesia"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Siti Nur Aisah", "2011521018", "Padang, 13-12-2001", "Jln. Situjuh II No.10", "PT. Shopee Indonesia"},
            {"https://upload.wikimedia.org/wikipedia/common/8/87/Ahmad_Dahlan.jpg", "Daeng Febrino", "2011522014", "Padang, 13-12-2001", "Jln. Situjuh II No.10", "PT. Shopee Indonesia"},
    };

    public static ArrayList<ModelDashboard> ambilDataDashboard() {
        ArrayList<ModelDashboard> dataDashboard = new ArrayList<>();
        for (String[] varData3 : data3) {
            ModelDashboard model = new ModelDashboard();
            model.setFotoMain(varData3[0]);
            model.setNamaMain(varData3[1]);
            model.setNimMain(varData3[2]);
            model.setTtlMain(varData3[3]);
            model.setAlamatMain(varData3[4]);
            model.setLokasiKPMain(varData3[5]);

            dataDashboard.add(model);
        }

        return dataDashboard;
    }
}

