package com.example.botones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void relative(View view){
        Intent intent = new Intent(this, Ejercicio1Activity.class);
        startActivity(intent);
    }

    public void linear1(View view){
        Intent intent = new Intent(this, Ejercicio2Activity.class);
        startActivity(intent);
    }
}
