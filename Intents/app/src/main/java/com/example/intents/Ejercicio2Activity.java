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
        int a = Integer.parseInt(String.valueOf(etA.getText()));
        int b = Integer.parseInt(String.valueOf(etB.getText()));
        int c = Integer.parseInt(String.valueOf(etC.getText()));

        Bundle bundle = new Bundle();
        bundle.putInt("a", a);
        bundle.putInt("b", b);
        bundle.putInt("c", c);

        Intent intent = new Intent(this, Ejercicicio2AActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
