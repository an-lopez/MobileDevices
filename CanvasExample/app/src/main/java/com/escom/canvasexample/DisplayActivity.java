package com.escom.canvasexample;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;

public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        LinearLayout ll = findViewById(R.id.ll_main);

        Intent intent = getIntent();
        int option = intent.getIntExtra("option",1);

        switch (option){
            case 1:
                ll.addView(new Canva(ll.getContext()));
                break;
            case 2:
                ll.addView(new Canva2(ll.getContext()));
                break;
        }
    }

}
