package com.escom.canvasexample;

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

    public void canva1(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("option", 1);
        startActivity(intent);
    }

    public void canva2(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("option", 2);
        startActivity(intent);
    }
}
