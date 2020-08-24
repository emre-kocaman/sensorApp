package com.example.sensoruygulamasi.YerCekimi;

public class yerCekimiModel {
    private float Xivme,Yivme,Zivme;

    public float getXivme() {
        return Xivme;
    }

    public void setXivme(float xivme) {
        Xivme = xivme;
    }

    public float getYivme() {
        return Yivme;
    }

    public void setYivme(float yivme) {
        Yivme = yivme;
    }

    public float getZivme() {
        return Zivme;
    }

    public void setZivme(float zivme) {
        Zivme = zivme;
    }

    public yerCekimiModel(float xivme, float yivme, float zivme) {
        Xivme = xivme;
        Yivme = yivme;
        Zivme = zivme;
    }
}
