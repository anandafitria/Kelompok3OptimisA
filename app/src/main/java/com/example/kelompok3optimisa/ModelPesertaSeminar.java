package com.example.kelompok3optimisa;

public class ModelPesertaSeminar {
    String NamaPeserta;
    String NimPeserta;

    public ModelPesertaSeminar (String NamaPeserta, String NimPeserta) {
       this.NamaPeserta = NamaPeserta;
       this.NimPeserta = NimPeserta;
    }

    public String getNamaPeserta() {
        return NamaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        NamaPeserta = namaPeserta;
    }

    public String getNimPeserta() {
        return NimPeserta;
    }

    public void setNimPeserta(String nimPeserta) {
        NimPeserta = nimPeserta;
    }
}
