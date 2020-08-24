package com.example.sensoruygulamasi.IsikSensor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensoruygulamasi.R;

import java.util.ArrayList;

public class IsikAdapter extends RecyclerView.Adapter<IsikAdapter.CardTasarimTutucu>{

    private Context context;
    private ArrayList<IsikModel> ısikModelArrayList;

    public IsikAdapter(Context context, ArrayList<IsikModel> ısikModelArrayList) {
        this.context = context;
        this.ısikModelArrayList = ısikModelArrayList;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{

        TextView indis,deger,durum;
        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            indis= itemView.findViewById(R.id.textViewCompassIndis);
            deger = itemView.findViewById(R.id.textViewDerece);
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
        IsikModel isikmodel = ısikModelArrayList.get(position);

        holder.deger.setText(String.valueOf(isikmodel.getIsikDeger()));
        holder.indis.setText(String.valueOf(position));
        if (isikmodel.isikDeger>0 && isikmodel.isikDeger<40){

            holder.durum.setText("Gece");
        }
        else if (isikmodel.isikDeger>40 && isikmodel.isikDeger<80){
            holder.durum.setText("Akşam");
        }
        else if (isikmodel.isikDeger>80 && isikmodel.isikDeger<120){
            holder.durum.setText("İkindi");
        }
        else if (isikmodel.isikDeger>120 && isikmodel.isikDeger<140){
            holder.durum.setText("Sabah");
        }
        else{
            holder.durum.setText("Öğlen");
        }


    }

    @Override
    public int getItemCount() {
        return ısikModelArrayList.size();
    }
}
