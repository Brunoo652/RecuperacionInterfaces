package com.afundacion.myaplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Util {

    static void loadImage(String url, Activity activity, ImageView Caratula) {
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

    static Bitmap getBitmapFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();
        return BitmapFactory.decodeStream(input);
    }
}
