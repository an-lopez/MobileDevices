package com.escom.ipn.mx.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Ejercicio3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        final ListView lv = findViewById(R.id.lv_ejemplo2);
        NuevaEntradaAdapter nea = new NuevaEntradaAdapter(this, R.layout.nueva_entrada_item);
        lv.setAdapter(nea);
        for(NuevaEntrada i: getEntradas()){
            nea.add(i);
        }
    }

    private List<NuevaEntrada> getEntradas(){
        List<NuevaEntrada> datos = new ArrayList<NuevaEntrada>();
        for (int i = 0; i < 31; i++) {
            datos.add(new NuevaEntrada(
                    "Datos de Entrada " + i, "Antonio López",
                    new GregorianCalendar(2016, 12, i).getTime(),
                    i % 2 == 0 ? R.drawable.buho : R.drawable.colibri));
        }
        return datos;
    }
}
