package com.example.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ejercicicio2AActivity extends AppCompatActivity {
    TextView tv_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicicio2_a);

        tv_res = findViewById(R.id.tv_res);

        Bundle bundle = getIntent().getExtras();
        double a = bundle.getDouble("a");
        double b = bundle.getDouble("b");
        double c = bundle.getDouble("c");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        tv_res.setText(resolve(a, b, c));
    }

    private String resolve(double a, double b, double c) {
        double raiz1;
        double raiz2;

        if (a == 0) {
            raiz1 = -c / b;
            return "x = " + String.format("%.02f", raiz1);
        } else {

            double interior = Math.pow(b, 2) - 4 * a * c;
            if (interior < 0) {
                interior *= -1;
                interior = Math.sqrt(interior) / (2 * a);
                b = -b / (2 * a);

                return "x = "+b + " + " + String.format("%.02f", interior) + "i \n x = " + b + " - " + String.format("%.02f", interior) + "i";
            } else {
                raiz1 = (-b + Math.sqrt(interior)) / (2 * a);
                raiz2 = (-b - Math.sqrt(interior)) / (2 * a);

                if(raiz1 == raiz2)
                    return "x = "+String.format("%.02f", raiz1);
                return "x = " + String.format("%.02f", raiz1) + "\nx = "+String.format("%.02f", raiz2);
            }
        }
    }
}
