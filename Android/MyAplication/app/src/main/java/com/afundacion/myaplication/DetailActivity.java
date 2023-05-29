package com.afundacion.myaplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        descriptionTextView = findViewById(R.id.textoDescripcion);

        // Obtén la descripción del videojuego del Intent
        String description = getIntent().getStringExtra("description");

        // Muestra la descripción en el TextView
        descriptionTextView.setText(description);
    }
}