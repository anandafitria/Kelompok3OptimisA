package com.example.kelompok3optimisa;

public class ModelDashboard {
    int FotoMain;
    String NamaMain;
    String NimMain;
    String TtlMain;
    String AlamatMain;
    String LokasiKPMain;

    public ModelDashboard() { }

    public ModelDashboard (int FotoMain, String NamaMain, String NimMain, String TtlMain, String AlamatMain, String LokasiKPMain) {
        this.FotoMain = FotoMain;
        this.NamaMain = NamaMain;
        this.NimMain = NimMain;
        this.TtlMain = TtlMain;
        this.AlamatMain = AlamatMain;
        this.LokasiKPMain = LokasiKPMain;
    }

    public int getFotoMain() {
        return FotoMain;
    }

    public void setFotoMain(int fotoMain) {
        FotoMain = fotoMain;
    }

    public String getNamaMain() {
        return NamaMain;
    }

    public void setNamaMain(String namaMain) {
        NamaMain = namaMain;
    }

    public String getNimMain() {
        return NimMain;
    }

    public void setNimMain(String nimMain) {
        NimMain = nimMain;
    }

    public String getTtlMain() {
        return TtlMain;
    }

    public void setTtlMain(String ttlMain) {
        TtlMain = ttlMain;
    }

    public String getAlamatMain() {
        return AlamatMain;
    }

    public void setAlamatMain(String alamatMain) {
        AlamatMain = alamatMain;
    }

    public String getLokasiKPMain() {
        return LokasiKPMain;
    }

    public void setLokasiKPMain(String lokasiKPMain) {
        LokasiKPMain = lokasiKPMain;
    }
}
