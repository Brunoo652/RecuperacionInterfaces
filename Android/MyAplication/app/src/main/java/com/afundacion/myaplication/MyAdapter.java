package com.afundacion.myaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<dataList> allTheData;
    private ListadoVideojuegos listadoVideojuegos;

    public MyAdapter(List<dataList>)



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
        String data = dataList.get(position);
        holder.textViewTitle.setText(data);
    }

    //Devuelve el “número de elementos” en total de la colección.
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


