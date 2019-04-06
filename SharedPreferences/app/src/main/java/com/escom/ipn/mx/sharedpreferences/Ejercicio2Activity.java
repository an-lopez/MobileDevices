package com.escom.ipn.mx.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ejercicio2Activity extends AppCompatActivity {
    TextView tv_name;
    TextView tv_lastname;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        tv_name = findViewById(R.id.et_name);
        tv_lastname = findViewById(R.id.et_lastname);
        sharedPreferences = getSharedPreferences(getString(R.string.preferences2), MODE_PRIVATE);
    }

    public void sharedIntent(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.pref_key_name), tv_name.getText().toString());
        editor.putString(getString(R.string.pref_key_lastname), tv_lastname.getText().toString());
        editor.commit();

        Intent intent = new Intent(this, Ejercicio2AActivity.class);
        startActivity(intent);
        
    }

    public void show(View view) {
        Intent intent = new Intent(this, Ejercicio2AActivity.class);
        startActivity(intent);
    }
}
