package com.example.sensoruygulamasi.Rotasyon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sensoruygulamasi.R;

import java.util.ArrayList;

public class rotasyonInceleme extends AppCompatActivity {

    RecyclerView RV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotasyon_inceleme);
        RV = findViewById(R.id.RV);
        Button ogrenmeyiGor = findViewById(R.id.buttonOgrenmeyiGor);


        rotasyonAdapter adapter = new rotasyonAdapter(this,RotasyonSensoru.rotasyonModelArrayList);
        RV.setHasFixedSize(true);
        RV.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        RV.setAdapter(adapter);

        ogrenmeyiGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rotasyonInceleme.this, com.example.sensoruygulamasi.Rotasyon.ogrenmeyiGor.class);
                startActivity(intent);
            }
        });



    }
}
