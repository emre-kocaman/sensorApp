package com.example.sensoruygulamasi.IsikSensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sensoruygulamasi.R;

import java.io.IOException;
import java.util.ArrayList;

public class IsikSensoru extends AppCompatActivity implements SensorEventListener{

    TextView dataIsik;
    Sensor isikSensor;
    SensorManager sensorManager;
    Context context;
    ConstraintLayout layout;
    static ArrayList<IsikModel> isikList=new ArrayList<>();
    Button buttonInceleIsik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isik_sensoru);

        tanimla();
        buttonInceleIsik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IsikSensoru.this,IsikSensorInceleme.class);
                startActivity(intent);
            }
        });
    }


    public void tanimla(){

        context=this;
        layout=findViewById(R.id.layoutIsik);
        dataIsik=findViewById(R.id.dataSicaklik);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        isikSensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if(isikSensor==null){
            dataIsik.setText("Cihazda ışık sensörü bulunamadı");
        }
        else{
            sensorManager.registerListener(this,isikSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
        buttonInceleIsik=findViewById(R.id.buttonInceleIsik);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_LIGHT){

            //dataIsik.setText("Işık değeri: " + event.values[0]);

            IsikModel isikModel=new IsikModel(getBolum(event.values[0]),event.values[0]);
            isikList.add(isikModel);

            if (event.values[0]> 40){
                dataIsik.setText("Ortam ışığı yeterli.");
                layout.setBackgroundResource(R.drawable.sonuk);
            }
            else if (event.values[0]<40){
                dataIsik.setText("Ortam ışığı yetersiz.");
                layout.setBackgroundResource(R.drawable.yaniyor);
            }
        }
        else{
            dataIsik.setText("Işık değeri okunamıyor.");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    public String getBolum(float deger){


        if (deger>0 && deger<40){
            return "Gece";
        }
        else if (deger>40 && deger<80){
            return "Akşam";

        }
        else if (deger>80 && deger<120){
            return "İkindi";

        }
        else if (deger>120 && deger<140){
            return "Sabah";

        }
        else{
            return "Öğlen";

        }
    }

}
