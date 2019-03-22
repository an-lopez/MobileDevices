package com.escom.ipn.mx.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Ejercicio1Activity extends AppCompatActivity {
    ArrayList<ListaEntrada> al;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        al = new ArrayList<ListaEntrada>();
        Bundle bundle = getIntent().getExtras();

        al = (ArrayList<ListaEntrada>) bundle.getSerializable("lista");

        lv = (ListView) findViewById(R.id.lv_theme);
        lv.setAdapter(new ListaAdapter(al, R.layout.activity_ejercicio1, this) {
            @Override
            public void onEntry(Object object, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                if (texto_superior_entrada != null)
                    texto_superior_entrada.setText(((ListaEntrada) object).getA());
                TextView texto_inferior_entrada = (TextView)  view.findViewById(R.id.textView_inferior);
                if (texto_inferior_entrada != null)
                    texto_inferior_entrada.setText(((ListaEntrada) object).getD());

                ImageView imagen_entrada = view.findViewById(R.id.imageView_imagen);
                if (imagen_entrada != null)
                    imagen_entrada.setImageResource(((ListaEntrada) object).getIdim());
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListaEntrada le = (ListaEntrada) parent.getItemAtPosition(position);
                CharSequence cs = "Seleccionado: " + le.getD();
                Toast t = Toast.makeText(Ejercicio1Activity.this, cs, Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }


}
