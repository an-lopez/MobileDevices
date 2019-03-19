package com.example.layouts;

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
        Intent intent = new Intent(this, RelativeActivity.class);
        startActivity(intent);
    }

    public void linear1(View view){
        Intent intent = new Intent(this, LinearActivity.class);
        startActivity(intent);
    }

    public void linear2(View view){
        Intent intent = new Intent(this, LinearWeight.class);
        startActivity(intent);
    }

    public void frame(View view){
        Intent intent = new Intent(this, FrameActivity.class);
        startActivity(intent);
    }

    public void table(View view){
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }

    public void grid(View view){
        Intent intent = new Intent(this, GridActivity.class);
        startActivity(intent);
    }

    public void scroll(View view){
        Intent intent = new Intent(this, ScrollActivity.class);
        startActivity(intent);
    }
}
