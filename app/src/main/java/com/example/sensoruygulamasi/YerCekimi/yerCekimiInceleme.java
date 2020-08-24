package com.example.sensoruygulamasi.YerCekimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.sensoruygulamasi.R;

public class yerCekimiInceleme extends AppCompatActivity {

    RecyclerView RVyerCekimi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yer_cekimi_inceleme);
        RVyerCekimi=findViewById(R.id.RVyerCekimi);
        RVyerCekimi.setHasFixedSize(true);
        RVyerCekimi.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        yerCekimiAdapter adapter = new yerCekimiAdapter(this,YercekimiIvmeSensoru.yerCekimiModelArrayList);
        RVyerCekimi.setAdapter(adapter);
    }
}
