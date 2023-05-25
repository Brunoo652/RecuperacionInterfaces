package com.afundacion.myaplication;

import android.app.Activity;
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

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        NombreVideojuego = itemView.findViewById(R.id.nombreVideojuego);
        Caratula = itemView.findViewById(R.id.caratula);
    }

    public void showData(Datalist datalist, Activity activity) {
        NombreVideojuego.setText(datalist.getNombre());
        loadImage(datalist.getUrl(), activity);
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
}
