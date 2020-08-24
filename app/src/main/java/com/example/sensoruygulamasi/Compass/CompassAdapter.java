package com.example.sensoruygulamasi.Compass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensoruygulamasi.R;

import java.util.ArrayList;

public class CompassAdapter extends RecyclerView.Adapter<CompassAdapter.CardTasarimTutucu> {



    public Context context;
    public ArrayList<compassModel> compassList;

    public CompassAdapter(Context context, ArrayList<compassModel> compassList) {
        this.context = context;
        this.compassList = compassList;
    }




    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        TextView indis,derece,durum;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            indis = itemView.findViewById(R.id.textViewCompassIndis);
            derece = itemView.findViewById(R.id.textViewDerece);
            durum = itemView.findViewById(R.id.textViewCompassDurum);
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.compass_card,parent,false);
        return new CardTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        compassModel compassModel = compassList.get(position);
        holder.derece.setText(String.valueOf(compassModel.derece));
        holder.indis.setText(String.valueOf(position));

        if (position>10){
            if(compassList.get(position-10).derece-40>compassList.get(position).derece || compassList.get(position-10).derece+40<compassList.get(position).derece){
                holder.durum.setText("Keskin viraj içinde");
                compassModel.kesinVirajSayisi++;
            }
            else{
                holder.durum.setText("Stabil");
            }
        }
        else{
            holder.durum.setText("Stabil");
        }

    }

    @Override
    public int getItemCount() {
        return compassList.size();
    }
}
