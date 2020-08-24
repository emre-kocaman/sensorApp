package com.example.sensoruygulamasi.Compass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sensoruygulamasi.R;

public class ogrenemyiGor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenemyi_gor);

        TextView textViewKeskinViraj = findViewById(R.id.textViewKeskinViraj);
        textViewKeskinViraj.setText("Keskin virajda kalınan saniye: \n"+compassModel.kesinVirajSayisi/5);
    }
}
