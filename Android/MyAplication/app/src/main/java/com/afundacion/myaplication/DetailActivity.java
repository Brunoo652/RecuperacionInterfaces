package com.afundacion.myaplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView nombreTextView;
    private TextView descripcionTextView;
    private ImageView imagenImageView;
    private Activity activity= this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        descripcionTextView = findViewById(R.id.textoDescripcion);
        nombreTextView = findViewById(R.id.nombreDetalleVideojuego);
        imagenImageView = findViewById(R.id.ImagenDetalleVideojuego);

        Intent intent = getIntent();

        String descripcion =  intent.getStringExtra("descripcion");
        String nombre = intent.getStringExtra("nombre");
        Util.loadImage("imagen_url", this, imagenImageView);
        descripcionTextView.setText(descripcion);
        nombreTextView.setText(nombre);


    }
}