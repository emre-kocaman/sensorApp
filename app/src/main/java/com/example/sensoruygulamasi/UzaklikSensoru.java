package com.example.sensoruygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UzaklikSensoru extends AppCompatActivity {

    TextView textViewProximitSensor,data,textViewSayac;
    SensorManager mSensorManager;
    Sensor mProximitySensor;
    int sayac=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uzaklik_sensoru);

        tanimla();
    }

    public void tanimla(){
        textViewProximitSensor = findViewById(R.id.textViewProximity);
        data = findViewById(R.id.data);
        textViewSayac = findViewById(R.id.textViewSayac);
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mProximitySensor= mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if(mProximitySensor==null){
            textViewProximitSensor.setText("Yakında Proximity sensör bulunamadı");
        }
        else{
            mSensorManager.registerListener(proximitySensorEventListener,mProximitySensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    SensorEventListener proximitySensorEventListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType()== Sensor.TYPE_PROXIMITY){
                textViewSayac.setText("Sayaç: " + String.valueOf(sayac));
                Log.e("SAYAC",String.valueOf(sayac));
                if(event.values[0] == 0){
                    sayac++;
                    data.setText("YAKIN");
                }
                else{
                    data.setText("UZAK");
                }

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {


        }
    };
}
