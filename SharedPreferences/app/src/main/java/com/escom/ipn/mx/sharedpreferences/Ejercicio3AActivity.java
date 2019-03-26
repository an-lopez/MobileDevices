package com.escom.ipn.mx.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class Ejercicio3AActivity extends AppCompatActivity {
    MyCanvas canvas;
    SharedPreferences sharedPreferences;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityCompat.requestPermissions(Ejercicio3AActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

        sharedPreferences = getSharedPreferences(getString(R.string.preferences3), MODE_PRIVATE);
        path = sharedPreferences.getString(getString(R.string.pref_key_img), "");
        System.out.println("path " + path);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    canvas = new MyCanvas(this, path);
                    setContentView(canvas);
                    // permission was granted, do something you want
                } else {
                    // permission denied
                    Toast.makeText(Ejercicio3AActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
