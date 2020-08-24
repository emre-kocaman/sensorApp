package com.example.sensoruygulamasi.Rotasyon;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensoruygulamasi.R;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class rotasyonAdapter extends RecyclerView.Adapter<rotasyonAdapter.CardTasarimTutucu>  {
    public Context context;
    public ArrayList<rotasyonModel> rotasyonList;

    public rotasyonAdapter(Context context, ArrayList<rotasyonModel> rotasyonList) {
        this.context = context;
        this.rotasyonList = rotasyonList;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        TextView twIndis,twZaman,twX,twY,twZ,twDurum;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            twIndis = itemView.findViewById(R.id.textView6);
            twX=itemView.findViewById(R.id.textView2);
            twY=itemView.findViewById(R.id.textView3);
            twZ=itemView.findViewById(R.id.textView4);
            twDurum=itemView.findViewById(R.id.textView5);

        }

    }



    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rotasyon,parent,false);
        return new CardTasarimTutucu(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        rotasyonModel rotasyonItem = rotasyonList.get(position);

        if(position>3){
            if (rotasyonList.get(position-3).getX()-3>rotasyonList.get(position).getX()){
                holder.twDurum.setText("Durum: Koşuyor" );
                rotasyonModel.kalkismaKosma++;
            }
            else if (rotasyonList.get(position-3).getX()-2>rotasyonList.get(position).getX()){
                holder.twDurum.setText("Durum: Yürüyor" );
                rotasyonModel.kalkismaYurume++;
            }
            else{
                holder.twDurum.setText("Durum: Duruyor" );
            }
        }
        else{
            holder.twDurum.setText("Duruyor");

        }
        holder.twIndis.setText("Indis:" +String.valueOf(position));
        holder.twX.setText("X: " +String.valueOf(rotasyonItem.getX()).substring(0,2));
        holder.twY.setText("Y: "+String.valueOf(rotasyonItem.getY()).substring(0,2));
        holder.twZ.setText("Z: "+String.valueOf(rotasyonItem.getZ()).substring(0,2));
    }

    @Override
    public int getItemCount() {
        return rotasyonList.size();
    }
}
