package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_number;
    TextView tv_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = findViewById(R.id.et_number);
        tv_number = findViewById(R.id.tv_number);

        tv_number.setText(String.valueOf(et_number.getText()));
    }


    public void checkFibonnaci(View view) {
        int n = Integer.parseInt(String.valueOf(et_number.getText()));
        if (isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4)) {
            tv_number.setText("Es fibonacci");
        } else {
            tv_number.setText("No es fibonacci");
        }
    }

    public void checkPalindrome(View view) {

        String str = String.valueOf(et_number.getText());
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }

        if (str.equals(reverse)) {
            tv_number.setText("Es palindromo");
        } else {
            tv_number.setText("No es palindromo");
        }
    }

    public void checkPrime(View view){
        int n = Integer.parseInt(String.valueOf(et_number.getText()));
        if(isPrime(n)){
            tv_number.setText("Es primo");
        }else{
            tv_number.setText("No es primo");
        }
    }

    public void checkWonderful(View view){
        int n = Integer.parseInt(String.valueOf(et_number.getText()));
        tv_number.setText(wonderfulIt(n));
    }

    private boolean isPerfectSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }

    private boolean isPrime(int n) {
        // Corner cases
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private String wonderfulIt(int n){
        String cadena = "";
        int temp = n;
        cadena += n+", ";
        while(temp != 1){
            if(temp%2 == 0){
                temp /= 2;
            }else{
                temp = temp*3+1;
            }
            cadena += temp+", ";
        }
        return cadena.substring(0, cadena.length()-2);
    }
}
