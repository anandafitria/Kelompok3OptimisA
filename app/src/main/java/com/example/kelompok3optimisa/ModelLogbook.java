package com.example.kelompok3optimisa;

public class ModelLogbook {
    int FotoLogbook;
    String NamaLogbook;
    String NimLogbook;
    String LokasiKPLogbook;

    public ModelLogbook(int FotoLogbook, String NamaLogbook, String NimLogbook, String LokasiKPLogbook) {
        this.FotoLogbook = FotoLogbook;
        this.NamaLogbook = NamaLogbook;
        this.NimLogbook = NimLogbook;
        this.LokasiKPLogbook = LokasiKPLogbook;
    }

    public int getFotoLogbook() {
        return FotoLogbook;
    }

    public void setFotoLogbook(int fotoLogbook) {
        FotoLogbook = fotoLogbook;
    }

    public String getNamaLogbook() {
        return NamaLogbook;
    }

    public void setNamaLogbook(String namaLogbook) {
        NamaLogbook = namaLogbook;
    }

    public String getNimLogbook() {
        return NimLogbook;
    }

    public void setNimLogbook(String nimLogbook) {
        NimLogbook = nimLogbook;
    }

    public String getLokasiKPLogbook() {
        return LokasiKPLogbook;
    }

    public void setLokasiKPLogbook(String lokasiKPLogbook) {
        LokasiKPLogbook = lokasiKPLogbook;
    }
}
