package com.example.kelompok3optimisa;

public class ModelDashboardAPI {
    int FotoDashboard;
    String NamaDashboard;
    String NimDashboard;
    String TtlDashboard;
    String AlamatDashboard;
    String LokasiKPDashboard;

    public ModelDashboardAPI (int FotoMain, String NamaMain, String NimMain, String TtlMain, String AlamatMain, String LokasiKPMain) {
        this.FotoDashboard = FotoMain;
        this.NamaDashboard = NamaMain;
        this.NimDashboard = NimMain;
        this.TtlDashboard = TtlMain;
        this.AlamatDashboard = AlamatMain;
        this.LokasiKPDashboard = LokasiKPMain;
    }

    public int getFotoDashboard() {
        return FotoDashboard;
    }

    public void setFotoDashboard(int fotoDashboard) {
        FotoDashboard = fotoDashboard;
    }

    public String getNamaDashboard() {
        return NamaDashboard;
    }

    public void setNamaDashboard(String namaDashboard) {
        NamaDashboard = namaDashboard;
    }

    public String getNimDashboard() {
        return NimDashboard;
    }

    public void setNimDashboard(String nimDashboard) {
        NimDashboard = nimDashboard;
    }

    public String getTtlDashboard() {
        return TtlDashboard;
    }

    public void setTtlDashboard(String ttlDashboard) {
        TtlDashboard = ttlDashboard;
    }

    public String getAlamatDashboard() {
        return AlamatDashboard;
    }

    public void setAlamatDashboard(String alamatDashboard) {
        AlamatDashboard = alamatDashboard;
    }

    public String getLokasiKPDashboard() {
        return LokasiKPDashboard;
    }

    public void setLokasiKPDashboard(String lokasiKPDashboard) {
        LokasiKPDashboard = lokasiKPDashboard;
    }
}
