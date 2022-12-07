package com.example.kelompok3optimisa;

public class ModelSeminar {
    int FotoSeminar;
    String NamaSeminar;
    String NimSeminar;
    String HariSeminar;
    String JamSeminar;
    String RuangSeminar;

    public ModelSeminar (int FotoSeminar, String NamaSeminar, String NimSeminar, String HariSeminar, String JamSeminar, String RuangSeminar) {
        this.FotoSeminar = FotoSeminar;
        this.NamaSeminar = NamaSeminar;
        this.NimSeminar = NimSeminar;
        this.HariSeminar = HariSeminar;
        this.JamSeminar = JamSeminar;
        this.RuangSeminar = RuangSeminar;
    }

    public int getFotoSeminar() {
        return FotoSeminar;
    }

    public void setFotoSeminar(int fotoSeminar) {
        FotoSeminar = fotoSeminar;
    }

    public String getNamaSeminar() {
        return NamaSeminar;
    }

    public void setNamaSeminar(String namaSeminar) {
        NamaSeminar = namaSeminar;
    }

    public String getNimSeminar() {
        return NimSeminar;
    }

    public void setNimSeminar(String nimSeminar) {
        NimSeminar = nimSeminar;
    }

    public String getHariSeminar() {
        return HariSeminar;
    }

    public void setHariSeminar(String hariSeminar) {
        HariSeminar = hariSeminar;
    }

    public String getJamSeminar() {
        return JamSeminar;
    }

    public void setJamSeminar(String jamSeminar) {
        JamSeminar = jamSeminar;
    }

    public String getRuangSeminar() {
        return RuangSeminar;
    }

    public void setRuangSeminar(String ruangSeminar) {
        RuangSeminar = ruangSeminar;
    }
}