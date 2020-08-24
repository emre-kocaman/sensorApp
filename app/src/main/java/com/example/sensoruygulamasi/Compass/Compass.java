package com.example.sensoruygulamasi.Compass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sensoruygulamasi.R;

import java.util.ArrayList;


public class Compass extends AppCompatActivity implements SensorEventListener {


    // globals
    private float[] gravityData = new float[3];
    private float[] geomagneticData = new float[3];
    private boolean hasGravityData = false;
    private boolean hasGeomagneticData = false;
    private double rotationInDegrees;
    static ArrayList<compassModel> compassModels = new ArrayList<>();
    Button buttonInceleCompass;

    Sensor accelerometer,compass;
    SensorManager sm;

    ImageView ulkeBayragi;
    private TextView textViewCompass,textViewCompassUlke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);


        textViewCompass=findViewById(R.id.textViewCompass);
        ulkeBayragi=findViewById(R.id.ulkeBayragi);
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        compass = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this,compass,SensorManager.SENSOR_DELAY_NORMAL);
        textViewCompassUlke=findViewById(R.id.textViewCompassUlke);
        buttonInceleCompass = findViewById(R.id.buttonInceleCompass);

        buttonInceleCompass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Compass.this,compassIncele.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onSensorChanged (SensorEvent event){

        Log.e("denemeeasdf","asdfasdf");
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                System.arraycopy(event.values, 0, gravityData, 0, 3);
                hasGravityData = true;
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                System.arraycopy(event.values, 0, geomagneticData, 0, 3);
                hasGeomagneticData = true;
                break;
            default:
                return;
        }

        if (hasGravityData && hasGeomagneticData) {
            float identityMatrix[] = new float[9];
            float rotationMatrix[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(rotationMatrix, identityMatrix,
                    gravityData, geomagneticData);

            if (success) {
                float orientationMatrix[] = new float[3];
                SensorManager.getOrientation(rotationMatrix, orientationMatrix);
                float rotationInRadians = orientationMatrix[0];
                rotationInDegrees = Math.toDegrees(rotationInRadians);

                if (rotationInDegrees<0){
                    rotationInDegrees+=360;
                }
                compassModel com;
                com = new compassModel(rotationInDegrees,"Keskin viraj dönüldü");
                compassModels.add(com);

                if(rotationInDegrees>330 || rotationInDegrees<15){//Ukrayna
                    textViewCompassUlke.setText("Ukrayna");
                    ulkeBayragi.setImageResource(R.drawable.ukrayna);
                }
                else if(rotationInDegrees>15 && rotationInDegrees < 45 ){//Rusya
                    textViewCompassUlke.setText("Rusya");
                    ulkeBayragi.setImageResource(R.drawable.rusya);
                }
                else if (rotationInDegrees>45  && rotationInDegrees< 65){//Gürcistan
                    textViewCompassUlke.setText("Gürcistan");
                    ulkeBayragi.setImageResource(R.drawable.gurcistan);

                }
                else if(rotationInDegrees >65 && rotationInDegrees<75){//Ermenistan
                    textViewCompassUlke.setText("Ermenistan");
                    ulkeBayragi.setImageResource(R.drawable.ermenistan);

                }
                else if(rotationInDegrees>75 && rotationInDegrees<100){//İran
                    textViewCompassUlke.setText("İran");
                    ulkeBayragi.setImageResource(R.drawable.iran);

                }
                else if(rotationInDegrees>100 && rotationInDegrees<115) {//Irak
                    textViewCompassUlke.setText("Irak");
                    ulkeBayragi.setImageResource(R.drawable.irak);

                }
                else if (rotationInDegrees>115 && rotationInDegrees<180){// Suriye
                    textViewCompassUlke.setText("Suriye");
                    ulkeBayragi.setImageResource(R.drawable.suriye);

                }
                else if (rotationInDegrees>180 && rotationInDegrees<225){//Kıbrıs
                    textViewCompassUlke.setText("Kıbrıs");
                    ulkeBayragi.setImageResource(R.drawable.kibris);

                }
                else if (rotationInDegrees>300 && rotationInDegrees<330){//Bulgaristan
                    textViewCompassUlke.setText("Bulgaristan");
                    ulkeBayragi.setImageResource(R.drawable.bulgaristan);

                }
                else if (rotationInDegrees>225 && rotationInDegrees<300){//Yunanistan
                    textViewCompassUlke.setText("Yunanistan");
                    ulkeBayragi.setImageResource(R.drawable.yunanistan);

                }

                textViewCompass.setText("BAKTIĞINIZ DERECE: \n" + String.valueOf(rotationInDegrees).substring(0,5));



            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}