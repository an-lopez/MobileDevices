package com.example.fragmentsandservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejercicio4Activity extends AppCompatActivity {
    private TextView jtv;
    private Button jbn;
    private boolean count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);
        count = true;
        jtv = (TextView) findViewById(R.id.xtvT);

        jbn = (Button) findViewById(R.id.xbnI);

        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initCrono();
            }
        });

        Button stopButton = (Button) findViewById(R.id.xbnT);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopCrono();
            }
        });

        MiCrono.setUpdateListener(this);
    }

    @Override
    protected void onDestroy() {
        stopCrono();
        super.onDestroy();
    }

    private void initCrono() {
        stopCrono();
        Intent in = new Intent(this, MiCrono.class);
        startService(in);
        count = true;
    }

    private void stopCrono() {
        refreshCrono(0);
        Intent in = new Intent(this, MiCrono.class);
        stopService(in);

    }

    public void refreshCrono(double t) {
        jtv.setText(String.format("%.2f", t) + " segs");
    }

    public void pauseCrono(View view) {
        count = false;
    }

    public void resumeCrono(View view) {
        count = true;
    }

    public boolean isCount() {
        return count;
    }
}
