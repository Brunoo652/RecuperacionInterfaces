package com.afundacion.myaplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView nombreTextView;
    private TextView descripcionTextView;
    private ImageView imagenImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        descripcionTextView = findViewById(R.id.textoDescripcion);

        Intent intent = getIntent();

        String descripcion = intent.getStringExtra("descripcion");
        descripcionTextView.setText(descripcion);

    }
}