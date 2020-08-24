package com.example.sensoruygulamasi.IsikSensor;

public class IsikModel {

    public String gunBolumu;

    public String getGunBolumu() {
        return gunBolumu;
    }

    public void setGunBolumu(String gunBolumu) {
        this.gunBolumu = gunBolumu;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String durum;
    float isikDeger;

    public float getIsikDeger() {
        return isikDeger;
    }

    public void setIsikDeger(float isikDeger) {
        this.isikDeger = isikDeger;
    }

    public IsikModel(String durum, float isikDeger) {
        this.durum = durum;
        this.isikDeger = isikDeger;
    }
}
