package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ejercicio1AActivity extends AppCompatActivity {
    EditText etNom;
    EditText etAp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_a);
        etNom = findViewById(R.id.et_nom);
        etAp = findViewById(R.id.et_ap);
    }

    public void send(View view) {
        String nombre = String.valueOf(etNom.getText());
        String apellido = String.valueOf(etAp.getText());

        Bundle bundle = new Bundle();
        bundle.putString("nom", nombre);
        bundle.putString("ap", apellido);

        Intent intent = new Intent(this, Ejercicio1Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
