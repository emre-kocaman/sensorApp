package com.example.sensoruygulamasi.YerCekimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensoruygulamasi.R;

import java.util.ArrayList;

public class yerCekimiAdapter extends RecyclerView.Adapter<yerCekimiAdapter.CardTasarimTutucu> {

    private Context context;
    private ArrayList<yerCekimiModel> yerCekimiModelArrayList;

    public yerCekimiAdapter(Context context, ArrayList<yerCekimiModel> yerCekimiModelArrayList) {
        this.context = context;
        this.yerCekimiModelArrayList = yerCekimiModelArrayList;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{


        TextView X,Y,Z,durum,indis;
        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            X=itemView.findViewById(R.id.textView2);
            Y = itemView.findViewById(R.id.textView3);
            Z = itemView.findViewById(R.id.textView4);
            durum =itemView.findViewById(R.id.textView5);
            indis = itemView.findViewById(R.id.textView6);
        }
    }



    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rotasyon,parent,false);
        return new CardTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        yerCekimiModel yercekimi = yerCekimiModelArrayList.get(position);

        holder.X.setText("X: "+String.valueOf(yercekimi.getXivme()));
        holder.Y.setText("Y: "+String.valueOf(yercekimi.getYivme()));
        holder.Z.setText("Z: "+String.valueOf(yercekimi.getZivme()));
        holder.indis.setText("Indis: "+ String.valueOf(position));
        holder.durum.setText("Atmosfer ile olan açı farkı: "+(90*yercekimi.getYivme())/9.8);
    }

    @Override
    public int getItemCount() {
        return yerCekimiModelArrayList.size();
    }
}
