package com.example.botones;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ejercicio1Activity extends AppCompatActivity {
    MediaPlayer mp;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        btn = (Button) findViewById(R.id.btnSonido);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
            }
        });

        mp = MediaPlayer.create(Ejercicio1Activity.this, R.raw.sws);
        mp.start();
    }

    public void onDestroy() {
        mp.stop();
        super.onDestroy();
    }
}
