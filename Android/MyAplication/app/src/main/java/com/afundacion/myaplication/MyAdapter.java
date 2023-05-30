package com.afundacion.myaplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Datalist> allTheData;
    private Activity activity;

//   public MyAdapter(List<dataList>);

    public MyAdapter(List<Datalist> dataset, Activity activity) {
        this.allTheData = dataset;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.view_holder, parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datalist dataInPositionToBeRendered= allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allTheData.size();
    }

    public interface OnItemClickListener {
        //método para manejar el evento de selección de un videojuego en el adaptador.
        void onItemClick(int position);
    }

/*
    //“Crea” una celda.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    //“Popula” la celda.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //    String data = dataList.get(position);
    //    holder.textViewTitle.setText(data);
    }

    //Devuelve el “número de elementos” en total de la colección.
    @Override
    public int getItemCount() {
        return dataList.size();
    }*/
}