package com.example.sensoruygulamasi.Rotasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sensoruygulamasi.R;

import java.util.ArrayList;

public class RotasyonSensoru extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sm;
    TextView textViewSensorY,textViewSensorX,textViewSensorZ,textViewLP ;
    Button buttonIncele;
    static ArrayList<rotasyonModel> rotasyonModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotasyon_sensoru);
        tanimla();

        buttonIncele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RotasyonSensoru.this,rotasyonInceleme.class);
                startActivity(intent);
            }
        });

    }
    public void tanimla(){
        textViewSensorY = findViewById(R.id.textViewSensorY);
        textViewSensorX = findViewById(R.id.textViewSensorX);
        textViewSensorZ = findViewById(R.id.textViewSensorZ);
        textViewLP=findViewById(R.id.textViewLP);
        buttonIncele = findViewById(R.id.buttonIncele);
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }









    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()== Sensor.TYPE_ACCELEROMETER){
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            long time = System.currentTimeMillis();
            rotasyonModel rot = new rotasyonModel(x,y,z,"durum",time);

            rotasyonModelArrayList.add(rot);


            if (y<10 && y>8){
                textViewLP.setText("PORTRAIT");
            }

            if(y<1 && y>-1){
                textViewLP.setText("LANDSPACE");
            }
            textViewSensorY.setText(String.valueOf(y));
            textViewSensorX.setText(String.valueOf(x));
            textViewSensorZ.setText(String.valueOf(z));


        }

    }

    @Override
    public void onAccuracyChanged(Sensor arg0,int arg1) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.registerListener(this,accelerometer,0);
    }
}
