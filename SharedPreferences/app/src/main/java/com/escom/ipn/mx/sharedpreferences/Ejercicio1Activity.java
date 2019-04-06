package com.escom.ipn.mx.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Ejercicio1Activity extends AppCompatActivity {
    SharedPreferences sp;
    EditText et_nombre;
    EditText et_x;
    EditText et_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        sp = getSharedPreferences(getString(R.string.preferencess), MODE_PRIVATE);
        et_x = findViewById(R.id.et_x);
        et_y = findViewById(R.id.et_y);
        et_nombre = findViewById(R.id.et_nombre);

        et_x.setText(""+sp.getFloat(getString(R.string.pref_key_x), 0));
        et_y.setText(""+ sp.getFloat(getString(R.string.pref_key_y), 0));
        et_nombre.setText(sp.getString(getString(R.string.pref_key_nombre), "ESCOM"));
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "Preferencias guardadas", Toast.LENGTH_SHORT);

        super.onPause();
        SharedPreferences.Editor editor = sp.edit();

        Double x = Double.parseDouble(et_x.getText().toString());
        Double y = Double.parseDouble(et_y.getText().toString());

        editor.putString(getString(R.string.pref_key_nombre), et_nombre.getText().toString());
        editor.putFloat(getString(R.string.pref_key_x), x.floatValue());
        editor.putFloat(getString(R.string.pref_key_y), y.floatValue());
        editor.commit();

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Preferencias guardadas", Toast.LENGTH_SHORT);
        super.onDestroy();
    }
}
