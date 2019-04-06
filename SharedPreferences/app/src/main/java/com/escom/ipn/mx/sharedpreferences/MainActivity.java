package com.escom.ipn.mx.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shared1(View view){
        Intent intent = new Intent(this, Ejercicio1Activity.class);
        startActivity(intent);
    }

    public void shared2(View view){
        Intent intent = new Intent(this, Ejercicio2Activity.class);
        startActivity(intent);
    }

    public void shared3(View view){
        Intent intent = new Intent(this, Ejercicio3Activity.class);
        startActivity(intent);
    }

    public void databases(View view){
        Intent intent = new Intent(this, Ejercicio4Activity.class);
        startActivity(intent);
    }
}
