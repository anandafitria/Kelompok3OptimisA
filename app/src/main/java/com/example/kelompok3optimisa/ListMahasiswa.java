package com.example.kelompok3optimisa;

public class ListMahasiswa {
    private int Foto;
    private String Nama, NIM, HariTanggal, Jam, Penguji;

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getHariTanggal() {
        return HariTanggal;
    }

    public void setHariTanggal(String hariTanggal) {
        HariTanggal = hariTanggal;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        Jam = jam;
    }

    public String getPenguji() {
        return Penguji;
    }

    public void setPenguji(String penguji) {
        Penguji = penguji;
    }

    public void add(ListMahasiswa listmhs) {
    }
}
