package com.example.sensoruygulamasi.Compass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sensoruygulamasi.R;

public class compassIncele extends AppCompatActivity {


    RecyclerView RvCompass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass_incele);

        RvCompass=findViewById(R.id.RvCompass);
        CompassAdapter adapter = new CompassAdapter(this,Compass.compassModels);
        RvCompass.setHasFixedSize(true);
        RvCompass.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        RvCompass.setAdapter(adapter);
        Button buttonOgrenmeyiGor = findViewById(R.id.buttonOgrenmeyiGor);
        buttonOgrenmeyiGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compassIncele.this,ogrenemyiGor.class);
                startActivity(intent);
            }
        });
    }
}
