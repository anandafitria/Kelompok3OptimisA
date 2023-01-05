package com.example.kelompok3optimisa;

import android.util.EventLogTags;

public class ModelLogbook {
    //int FotoLogbook;
    String agenda;
    String tanggal;

    public ModelLogbook(String agenda, String tanggal) {
        this.agenda = agenda;
        this.tanggal = tanggal;

        //this.HariTglLogbook = HariTglLogbook;
        //this.FotoLogbook = FotoLogbook;
        //this.NamaLogbook = NamaLogbook;
        //this.NimLogbook = NimLogbook;
        //this.LokasiKPLogbook = LokasiKPLogbook;
    }

    public String getAgenda() { return agenda;}

    public  void setAgenda(String agenda) { this.agenda = agenda;}

    public String getTanggal() { return tanggal;}

    public void setTanggal(String tanggal) { this.tanggal = tanggal;}
    //public int getFotoLogbook() {return FotoLogbook;}

    //public void setFotoLogbook(int fotoLogbook) {FotoLogbook = fotoLogbook;}

    //public String getHariTglLogbook() {return HariTglLogbook;}

    //public void setHariTglLogbook(String hariTglLogbook) {HariTglLogbook = hariTglLogbook;}

    //public String getNamaLogbook() {
    //return NamaLogbook;
    //}

    //public void setNamaLogbook(String namaLogbook) {
    //NamaLogbook = namaLogbook;
    //}

    //public String getNimLogbook() {
    //return NimLogbook;
    //}

    //public void setNimLogbook(String nimLogbook) {
    //NimLogbook = nimLogbook;
    //}

    //public String getLokasiKPLogbook() {
    //return LokasiKPLogbook;
    //}

    //public void setLokasiKPLogbook(String lokasiKPLogbook) {
    //LokasiKPLogbook = lokasiKPLogbook;
    //}

}