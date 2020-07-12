package com.haya.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    test

    private boolean isOpPressed = false;

    private double firstNumber = 0;

    private int secondNumberIndex = 0;

    private char currentOp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        final TextView calculatorScreen = findViewById(R.id.tvFormula);

        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button btClear = findViewById(R.id.btClear);
        final Button btPercent = findViewById(R.id.btPercent);
        final Button btTax = findViewById(R.id.btTax);
        final Button btDelete = findViewById(R.id.btDelete);
        final Button btDivide = findViewById(R.id.btDivide);
        final Button btMultiply = findViewById(R.id.btMultiply);
        final Button btSubtract = findViewById(R.id.btSubtract);
        final Button btAdd = findViewById(R.id.btAdd);
        final Button btEqual = findViewById(R.id.btEqual);
        final Button btPoint = findViewById(R.id.btPoint);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = view.getId();
                switch (id){
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.btClear:
                        break;
                    case R.id.btPercent:
                        break;
                    case R.id.btTax:
                        break;
                    case R.id.btDelete:
                        break;
                    case R.id.btDivide:
                        break;
                    case R.id.btMultiply:
                        break;
                    case R.id.btSubtract:
                        break;
                    case R.id.btAdd:
                        String screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("+");
                        isOpPressed = true;
                        currentOp = '+';
                        break;
                    case R.id.btPoint:
                        break;
                    case R.id.btEqual:
                        if (isOpPressed){
                            if (currentOp == '+'){
                                screenContent = calculatorScreen.getText().toString();
                                String secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                                double secondNumber = Double.parseDouble(secondNumberString);
                                secondNumber += firstNumber;
                                String result = String.valueOf(secondNumber);
                                if (result.endsWith(".0")) {
                                    result = result.substring(0, result.length() - 2);
                                }
                                calculatorScreen.setText(String.valueOf(result));
                            }
                        }
                        break;
                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        btClear.setOnClickListener(calculatorListener);
        btPercent.setOnClickListener(calculatorListener);
        btTax.setOnClickListener(calculatorListener);
        btDelete.setOnClickListener(calculatorListener);
        btDivide.setOnClickListener(calculatorListener);
        btMultiply.setOnClickListener(calculatorListener);
        btSubtract.setOnClickListener(calculatorListener);
        btAdd.setOnClickListener(calculatorListener);
        btEqual.setOnClickListener(calculatorListener);
        btPoint.setOnClickListener(calculatorListener);

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayElements = calculatorScreen.getText().toString();
                int length = displayElements.length();
                if (length > 0){
                    displayElements = displayElements.substring(0,length - 1);
                    calculatorScreen.setText(displayElements);
                }
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorScreen.setText("");
            }
        });


    }
}