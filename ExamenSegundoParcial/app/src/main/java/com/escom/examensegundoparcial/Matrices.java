package com.escom.examensegundoparcial;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class Matrices extends AppCompatActivity {
    int a1, a2, b1, b2;
    GridLayout gl1, gl2;

    private List<EditText> matrixa;
    private List<EditText> matrixb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrices);

        matrixa = new ArrayList<EditText>();
        matrixb = new ArrayList<EditText>();

        Intent intent = getIntent();
        a1 = intent.getIntExtra("a1", 1);
        a2 = intent.getIntExtra("a2", 1);
        b1 = intent.getIntExtra("b1", 1);
        b2 = intent.getIntExtra("b2", 1);

        gl1 = findViewById(R.id.matrixa);
        gl2 = findViewById(R.id.matrixb);

        gl1.setRowCount(a1);
        gl1.setColumnCount(a2);

        gl2.setColumnCount(b1);
        gl2.setColumnCount(b2);

        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                String hint = "1"+i+j;
                EditText et = new EditText(this);
                et.setId(Integer.valueOf(hint));
                gl1.addView(et);
                et.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
                et.setText("0");
                matrixa.add(et);
            }
        }

        for (int i = 0; i < b1; i++) {
            for (int j = 0; j < b2; j++) {
                String hint = "2"+i+j;
                EditText et = new EditText(this);
                et.setId(Integer.valueOf(hint));
                et.setText("0");
                et.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
                gl2.addView(et);
                matrixb.add(et);
            }
        }
    }

    public void calculate(View view){
        int resa = getIntent().getIntExtra("r1", 1);
        int resb = getIntent().getIntExtra("r2", 1);

        Double res[][] = new Double[a1][b2];

        Double matriza[][] = new Double[a1][a2];
        Double matrizb[][] = new Double[b1][b2];

        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                System.out.println(i*a2+j);
                matriza[i][j] = Double.parseDouble(matrixa.get(i*a2 + j).getText().toString());
            }
        }

        for (int i = 0; i < b1; i++) {
            for (int j = 0; j < b2; j++) {
                matrizb[i][j] = Double.parseDouble(matrixb.get(i*b2 + j).getText().toString());
            }
        }

        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < b2; j++) {
                res[i][j] = Double.valueOf(0);
                for (int k = 0; k < a2; k++) {
                    res[i][j] += matriza[i][k]*matrizb[k][j];
                }
            }
        }

        Bundle b = new Bundle();
        b.putSerializable("res", res);

        Resultado resultado = new Resultado();
        resultado.setArguments(b);

        FragmentManager fm = getSupportFragmentManager();


        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.flayout, resultado);
        ft.commit();
    }

    public void onReturn(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
