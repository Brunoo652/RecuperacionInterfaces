package com.afundacion.myaplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView NombreVideojuego;
    private final ImageView Caratula;
   // Context context;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        NombreVideojuego = itemView.findViewById(R.id.nombreVideojuego);
        Caratula = itemView.findViewById(R.id.caratula);
        GoToDetail();
    }

    public void showData(Datalist datalist, Activity activity) {
        NombreVideojuego.setText(datalist.getNombre());
        loadImage(datalist.getUrl(), activity);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes obtener el elemento de datos seleccionado y pasarlos a otra actividad
                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra("descripcion", datalist.getDesc());
                // Agrega cualquier otro dato adicional que desees pasar
                activity.startActivity(intent);
            }
        });
    }

    private void loadImage(String url, Activity activity) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap image = getBitmapFromUrl(url);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Caratula.setImageBitmap(image);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private Bitmap getBitmapFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();
        return BitmapFactory.decodeStream(input);
    }

    //on clik lisetener que lleve a la actividad del detalle
    private void GoToDetail(){
        //caratula
        Caratula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                itemView.getContext().startActivity(intent);

            }
        });

        //nombre
        NombreVideojuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                itemView.getContext().startActivity(intent);

            }
        });
    }
}
