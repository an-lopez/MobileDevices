package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ejercicio2Activity extends AppCompatActivity {
    EditText etA;
    EditText etB;
    EditText etC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        etA = findViewById(R.id.et_a);
        etB = findViewById(R.id.et_b);
        etC = findViewById(R.id.et_c);
    }

    public void send(View view){
        double a = Double.parseDouble(String.valueOf(etA.getText()));
        double b = Double.parseDouble(String.valueOf(etB.getText()));
        double c = Double.parseDouble(String.valueOf(etC.getText()));

        Bundle bundle = new Bundle();
        bundle.putDouble("a", a);
        bundle.putDouble("b", b);
        bundle.putDouble("c", c);

        Intent intent = new Intent(this, Ejercicicio2AActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
