package com.escom.ipn.mx.spinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Ejercicio2Activity extends AppCompatActivity {
    private EditText et;
    private Spinner sp;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        et = findViewById(R.id.et_ej2);
        sp = findViewById(R.id.sp_ejercicio2);
        btn = findViewById(R.id.btn_guardar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String label = et.getText().toString();
                if(label.trim().length() > 0){
                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                    db.insertLabel(label);
                    et.setText("");
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(),0);
                    loadSpinner();
                }else{
                    Toast.makeText(getApplicationContext(), "Escriba algo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = sp.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selección: " + s, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sp.setOnItemSelectedListener(onItemSelectedListener);
        loadSpinner();
    }


    private void loadSpinner(){
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<String> labels = db.getAllLabels();
        ArrayAdapter<String> spinnnerAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, labels  );
        spinnnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(spinnnerAdapter);
    }
}
