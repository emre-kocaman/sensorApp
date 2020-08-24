package com.example.sensoruygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sensoruygulamasi.Compass.Compass;
import com.example.sensoruygulamasi.IsikSensor.IsikSensoru;
import com.example.sensoruygulamasi.Rotasyon.RotasyonSensoru;
import com.example.sensoruygulamasi.YerCekimi.YercekimiIvmeSensoru;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button buttonUzaklik,buttonIsik,buttonBasinc,buttonRotasyon,buttonCompass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        clicks();




    }

    public void tanimla(){


        buttonUzaklik = findViewById(R.id.buttonUzaklik);
        buttonIsik=findViewById(R.id.buttonIsik);
        buttonBasinc=findViewById(R.id.buttonBasinc);
        buttonRotasyon=findViewById(R.id.buttonRotasyon);
        buttonCompass=findViewById(R.id.buttonCompass);
    }

    public void clicks(){
        buttonUzaklik.setOnClickListener(this);
        buttonIsik.setOnClickListener(this);
        buttonBasinc.setOnClickListener(this);
        buttonRotasyon.setOnClickListener(this);
        buttonCompass.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonUzaklik:
                Intent intent = new Intent(MainActivity.this,UzaklikSensoru.class);
                startActivity(intent);
                break;
            case R.id.buttonIsik:
                Intent intentSicaklik = new Intent(MainActivity.this, IsikSensoru.class);
                startActivity(intentSicaklik);
                break;
            case R.id.buttonBasinc:
                Intent basinc = new Intent(MainActivity.this, YercekimiIvmeSensoru.class);
                startActivity(basinc);
                break;
            case R.id.buttonRotasyon:
                Intent intentRotasyon = new Intent(MainActivity.this, RotasyonSensoru.class);
                startActivity(intentRotasyon);
                break;
            case R.id.buttonCompass:
                Intent intentCompass = new Intent(MainActivity.this, Compass.class);
                startActivity(intentCompass);
                break;

        }
    }
}
