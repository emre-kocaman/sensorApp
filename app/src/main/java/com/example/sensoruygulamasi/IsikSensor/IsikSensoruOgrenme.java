package com.example.sensoruygulamasi.IsikSensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sensoruygulamasi.R;

public class IsikSensoruOgrenme extends AppCompatActivity {


    TextView textViewIsikOgrenme;
    int sabahsayac=0,oglensayac=0,ikindisayac=0,aksamsayac=0,gecesayac=0;


    //Gece Akşam  İkindi Sabah Öğlen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isik_sensoru_ogrenme);
        textViewIsikOgrenme=findViewById(R.id.textViewIsikOgrenme);

        /*for (int i = 0; i<IsikSensoru.isikList.size();i++){
            if (IsikSensoru.isikList.get(i).durum.equals("Gece")){
                gecesayac++;
            }
            if (IsikSensoru.isikList.get(i).durum.equals("Akşam")){
                aksamsayac++;
            }
            if (IsikSensoru.isikList.get(i).durum.equals("İkindi")){
                ikindisayac++;
            }
            if (IsikSensoru.isikList.get(i).durum.equals("Sabah")){
                sabahsayac++;
            }
            if (IsikSensoru.isikList.get(i).durum.equals("Öğlen")){
                oglensayac++;
            }
        }*/
        Log.e("denemasdf",String.valueOf(IsikSensoru.isikList.size()));
        for (IsikModel item : IsikSensoru.isikList){
            if (item.durum.equals("Gece")){
                gecesayac++;
            }
            else if (item.durum.equals("Akşam")){
                aksamsayac++;
            }
            else if (item.durum.equals("İkindi")){
                ikindisayac++;
            }
            else if (item.durum.equals("Sabah")){
                sabahsayac++;
            }
            else if (item.durum.equals("Öğlen")){
                oglensayac++;
            }
        }

        if (aksamsayac>sabahsayac && aksamsayac>ikindisayac && aksamsayac>gecesayac && aksamsayac>oglensayac){
            textViewIsikOgrenme.setText("GÜNÜN VAKTİ \n AKŞAM");
        }
        else if (sabahsayac>ikindisayac&& sabahsayac>gecesayac && sabahsayac>oglensayac){
            textViewIsikOgrenme.setText("GÜNÜN VAKTİ \n SABAH");

        }
        else if(ikindisayac>gecesayac&&ikindisayac>oglensayac){
            textViewIsikOgrenme.setText("GÜNÜN VAKTİ \n İKİNDİ");

        }
        else if(gecesayac>oglensayac){
            textViewIsikOgrenme.setText("GÜNÜN VAKTİ \n GECE");

        }
        else{
            textViewIsikOgrenme.setText("GÜNÜN VAKTİ \n ÖĞLEN");

        }




    }
}
