package com.example.fragmentsandservices;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1Activity extends AppCompatActivity implements MiFragmento.OnFragmentInteractionListener {
    TextView xtv;
    Button jbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        xtv = (TextView) findViewById(R.id.xtv);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                Fragment f = fm.findFragmentByTag("editor");

                if (null == f) {
                    FragmentTransaction ft = fm.beginTransaction();

                    ft.add(R.id.xfl, new MiFragmento(), "editor");
                    ft.commit();
                }
                xtv.setText("");
                Toast.makeText(Ejercicio1Activity.this, "Utilizando Fragment",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void digitado(int resultado, String texto) {
        TextView jtv = (TextView) findViewById(R.id.xtv);
        if (resultado == MiFragmento.OK) {
            jtv.setText(texto);
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment fe = fm.findFragmentByTag("editor");
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fe);
        ft.commit();
    }
}
