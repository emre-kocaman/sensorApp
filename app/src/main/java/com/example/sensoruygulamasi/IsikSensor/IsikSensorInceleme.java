package com.example.sensoruygulamasi.IsikSensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sensoruygulamasi.R;

public class IsikSensorInceleme extends AppCompatActivity {


    RecyclerView rvIsikSensorInceleme;
    IsikAdapter adapter;
    Button buttonOgrenmeyiGor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isik_sensor_inceleme);
        rvIsikSensorInceleme=findViewById(R.id.rvIsikSensorInceleme);
        adapter = new IsikAdapter(this,IsikSensoru.isikList);
        rvIsikSensorInceleme.setHasFixedSize(true);
        rvIsikSensorInceleme.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        rvIsikSensorInceleme.setAdapter(adapter);
        buttonOgrenmeyiGor=findViewById(R.id.buttonOgrenmeyiGor);
        buttonOgrenmeyiGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IsikSensorInceleme.this,IsikSensoruOgrenme.class);
                startActivity(intent);
            }
        });


    }
}
