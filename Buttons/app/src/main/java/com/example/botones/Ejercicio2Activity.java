package com.example.botones;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class Ejercicio2Activity extends AppCompatActivity {
    FloatingActionButton jfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        jfab = (FloatingActionButton) findViewById(R.id.xfab);
        jfab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(Ejercicio2Activity.this, "Pip Pip Da Doodly Doo!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
