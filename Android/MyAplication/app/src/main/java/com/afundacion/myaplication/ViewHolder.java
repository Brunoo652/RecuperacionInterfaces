package com.afundacion.myaplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    // Agrega las vistas necesarias
    public TextView textViewTitle;


    public ViewHolder(View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
    }

}