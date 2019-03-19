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
        int a = bundle.getInt("a");
        int b = bundle.getInt("b");
        int c = bundle.getInt("c");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        tv_res.setText(resolve(a, b, c));
    }

    private String resolve(int a, int b, int c) {
        double tempa = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        double tempb = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        if (Double.isNaN(tempa) && !Double.isNaN(tempb)) {
            return tempb + "";
        } else if (!Double.isNaN(tempa) && Double.isNaN(tempb)) {
            return tempa + "";
        } else if (Double.isNaN(tempa) && Double.isNaN(tempb)) {
            return "No tiene raíz";
        }
        return tempa + " o " + tempb;
    }
}
