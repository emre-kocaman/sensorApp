package com.example.sensoruygulamasi.Compass;

public class compassModel {

    double derece;
    String durum;
    static double kesinVirajSayisi;

    public compassModel(double derece, String durum) {
        this.derece = derece;
        this.durum = durum;
    }

    public double getDerece() {
        return derece;
    }

    public void setDerece(double derece) {
        this.derece = derece;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
