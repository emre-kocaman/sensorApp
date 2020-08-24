package com.example.sensoruygulamasi.YerCekimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.sensoruygulamasi.R;

import java.util.ArrayList;

public class YercekimiIvmeSensoru extends AppCompatActivity implements SensorEventListener {


    TextView dataGravityY,dataGravityZ,dataGravityX,textViewGravity;
    Sensor GravitySensor;
    SensorManager sensorManager;
    Context context;
    ConstraintLayout Gravitylayout;
    static ArrayList<yerCekimiModel> yerCekimiModelArrayList = new ArrayList<>();
    Button buttonYerCekimiIncele;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yercekimi_ivme);
        tanimla();

        buttonYerCekimiIncele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YercekimiIvmeSensoru.this,yerCekimiInceleme.class);
                startActivity(intent);
            }
        });
    }

    public void tanimla(){
            context=this;
            Gravitylayout=findViewById(R.id.layoutGravity);

        dataGravityY=findViewById(R.id.dataGravityY);
        dataGravityZ=findViewById(R.id.dataGravityZ);
        dataGravityX=findViewById(R.id.dataGravityX);
        textViewGravity=findViewById(R.id.textViewGravity);
            sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
            GravitySensor=sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

            if(GravitySensor==null){
                textViewGravity.setText("Cihazda yerçekimi ivme sensörü bulunamadı");
            }
            else{
                sensorManager.registerListener(this,GravitySensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
        buttonYerCekimiIncele = findViewById(R.id.buttonYerCekimiIncele);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()==Sensor.TYPE_GRAVITY){

            yerCekimiModel nesne = new yerCekimiModel(event.values[0],event.values[1],event.values[2]);
            yerCekimiModelArrayList.add(nesne);

            dataGravityX.setText(String.valueOf(event.values[0]).substring(0,5));
            dataGravityY.setText(String.valueOf(event.values[1]).substring(0,5));
            dataGravityZ.setText(String.valueOf(event.values[2]).substring(0,5));
        }
        else{
            textViewGravity.setText("Basınç değeri okunamıyor.");
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
