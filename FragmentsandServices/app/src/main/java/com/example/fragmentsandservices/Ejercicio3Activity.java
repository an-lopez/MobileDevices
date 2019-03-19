package com.example.fragmentsandservices;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ejercicio3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration c = getResources().getConfiguration();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(c.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            HorizontalFragment hf = new HorizontalFragment();
            ft.replace(android.R.id.content, hf);
        }else{
            VerticalFragment vf = new VerticalFragment();
            ft.replace(android.R.id.content, vf);
        }
        ft.commit();
    }
}
