package com.escom.examensegundoparcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a1, a2, b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = findViewById(R.id.A1);
        a2 = findViewById(R.id.A2);
        b1 = findViewById(R.id.B1);
        b2 = findViewById(R.id.B2);

    }

    public void checkMatriz(View view){
        int a1 = Integer.parseInt(this.a1.getText().toString());
        int a2 = Integer.parseInt(this.a2.getText().toString());
        int b1 = Integer.parseInt(this.b1.getText().toString());
        int b2 = Integer.parseInt(this.b2.getText().toString());
        int a, b;
        if(a1 == a2 && a2 == b1 && b1 == b2){
            a  = b = a1;
            Intent intent = new Intent(this, Matrices.class);
            intent.putExtra("a1", a1);
            intent.putExtra("a2", a2);
            intent.putExtra("b1", b1);
            intent.putExtra("b2", b2);
            startActivity(intent);
        }   else if(a2 == b1){
            a = a1;
            b = b2;

            Intent intent = new Intent(this, Matrices.class);
            intent.putExtra("a1", a1);
            intent.putExtra("a2", a2);
            intent.putExtra("b1", b1);
            intent.putExtra("b2", b2);
            intent.putExtra("r1", a);
            intent.putExtra("r2", b);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Matriz no valida", Toast.LENGTH_SHORT).show();
        }
    }
}
