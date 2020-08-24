package com.example.sensoruygulamasi.Rotasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sensoruygulamasi.R;

public class ogrenmeyiGor extends AppCompatActivity {

    TextView a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenmeyi_gor);

        a = findViewById(R.id.textViewKosma);
        b = findViewById(R.id.textViewYurume);

        a.setText("Run triggered: " + rotasyonModel.kalkismaKosma);
        b.setText("Walk triggered: "+ rotasyonModel.kalkismaYurume);
    }
}
