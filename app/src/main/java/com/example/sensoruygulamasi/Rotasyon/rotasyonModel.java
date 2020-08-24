package com.example.sensoruygulamasi.Rotasyon;

public class rotasyonModel {

    private float indis,x,y,z;
    private String durum;
    private long zaman;
    static int kalkismaKosma,kalkismaYurume;

    public float getIndis() {
        return indis;
    }

    public rotasyonModel(float x, float y, float z, String durum, long zaman) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.durum = durum;
        this.zaman = zaman;
    }

    public void setIndis(int indis) {
        this.indis = indis;
    }

    public float getZaman() {
        return zaman;
    }

    public void setZaman(long zaman) {
        this.zaman = zaman;
    }

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
