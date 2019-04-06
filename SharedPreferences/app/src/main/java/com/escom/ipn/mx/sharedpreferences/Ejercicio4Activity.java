package com.escom.ipn.mx.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Ejercicio4Activity extends AppCompatActivity {
    private EditText id;
    private EditText nombre;
    private TextView datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        id = findViewById(R.id.et_id);
        nombre = findViewById(R.id.et_nombre2);
        datos = findViewById(R.id.tv_lista);

    }

    public void alta(View view){
        DbHelper dbHelper = new DbHelper(getApplicationContext());
        try{
            dbHelper.insertExample(Integer.parseInt(id.getText().toString()), nombre.getText().toString());
        }catch (Exception e){
            System.out.println("ENTREEEEEE");
            Toast.makeText(getApplicationContext(), "Identificador duplicado.", Toast.LENGTH_SHORT).show();

        }
    }

    public void lista(View view){
        datos.setText("");
        DbHelper dbHelper = new DbHelper(getApplicationContext());
        List<Entry> entries = dbHelper.listValues();
        for (Entry entry: entries) {
            datos.append(entry.getId()+", "+entry.getName()+"\n");
        }
    }
}
