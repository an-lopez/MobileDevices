package com.example.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ejercicio1Activity extends AppCompatActivity {
    TextView tvNom;
    TextView tvAp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        tvNom = findViewById(R.id.tv_nom);
        tvAp = findViewById(R.id.tv_ap);
        Bundle b = getIntent().getExtras();

        tvNom.setText("Nombre: "+b.getString("nom"));
        tvAp.setText("Apellido: "+b.getString("ap"));

    }
}
