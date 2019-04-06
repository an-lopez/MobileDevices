package com.escom.ipn.mx.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Ejercicio2AActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView tv_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_a);

        tv_display = findViewById(R.id.tv_display);

        sharedPreferences = getSharedPreferences(getString(R.string.preferences2), MODE_PRIVATE);
        String name = sharedPreferences.getString(getString(R.string.pref_key_name), "Antonio");
        String lastname = sharedPreferences.getString(getString(R.string.pref_key_lastname), "Lopez");

        tv_display.setText(name + " "+lastname);
    }
}
