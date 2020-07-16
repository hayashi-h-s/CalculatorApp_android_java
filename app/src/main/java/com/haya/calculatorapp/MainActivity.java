package com.haya.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private String screenContent;

    private boolean isOpPressed = false;

    private boolean isDot = false;

    private boolean clearFunc = false;

    private BigDecimal firstNumber;

    private int secondNumberIndex = 0;

    private char currentOp;

    private TextView calculatorScreen;

    private int BORDER_WEIGHT = 2;

    NumberFormat nf = NumberFormat.getNumberInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        calculatorScreen = findViewById(R.id.tvFormula);

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
//        final Button btClear = findViewById(R.id.btClear);
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

                btDelete.setText("DEL");

                String screenContentFix = calculatorScreen.getText().toString();
                screenContent = screenContentFix.replace(",", "");
                final int id = view.getId();

            switch (id){
                case R.id.n0:
                    isOpPressed = false;
                    calculatorScreen.append("0");
                    break;
                case R.id.n1:
                    isOpPressed = false;
                    calculatorScreen.append("1");
                    break;
                case R.id.n2:
                    isOpPressed = false;
                    calculatorScreen.append("2");
                    break;
                case R.id.n3:
                    isOpPressed = false;
                    calculatorScreen.append("3");
                    break;
                case R.id.n4:
                    isOpPressed = false;
                    calculatorScreen.append("4");
                    break;
                case R.id.n5:
                    isOpPressed = false;
                    calculatorScreen.append("5");
                    break;
                case R.id.n6:
                    isOpPressed = false;
                    calculatorScreen.append("6");
                    break;
                case R.id.n7:
                    isOpPressed = false;
                    calculatorScreen.append("7");
                    break;
                case R.id.n8:
                    isOpPressed = false;
                    calculatorScreen.append("8");
                    break;
                case R.id.n9:
                    isOpPressed = false;
                    calculatorScreen.append("9");
                    break;
                case R.id.btDivide:
                    OpPressed('÷');
                    break;
                case R.id.btMultiply:
                    OpPressed('×');
                    break;
                case R.id.btSubtract:
                    OpPressed('-');
                    break;
                case R.id.btAdd:
                    OpPressed('+');
                    break;
                case R.id.btPoint:
//                    screenContent = calculatorScreen.getText().toString();
                    secondNumberIndex = screenContent.length() + 1;
                    if (screenContent.isEmpty() || isOpPressed ) {
                        return;
                    }
                    if (!isDot) {
                        calculatorScreen.append(".");
                        isDot = true;
                    }
                    break;
                case R.id.btEqual:
//                    screenContent = calculatorScreen.getText().toString();
                    String secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());

                    if (secondNumberString.isEmpty()) {
                        return;
                    }

                    BigDecimal secondNumber = new BigDecimal(secondNumberString);

                    if (currentOp == '+'){
                        secondNumber = secondNumber.add(firstNumber);
                    } else if (currentOp == '-'){
                        secondNumber = firstNumber.subtract(secondNumber);
                    } else if (currentOp == '×') {
                        secondNumber = firstNumber.multiply(secondNumber);
                    } else if (currentOp == '÷') {
                        if ( secondNumber.compareTo(BigDecimal.ZERO)==0 ) {
                            return;
                        }
                        secondNumber = firstNumber.divide(secondNumber, 14, RoundingMode.HALF_UP);
                    }

                    String result = nf.format(secondNumber);

                    if (result.endsWith(".0")) {
                        result = result.substring(0, result.length() - 2);
                    }
                    calculatorScreen.setText(String.valueOf(result));
                    btDelete.setText("C");
                    isOpPressed = false;
                    clearFunc = true;
                    break;
            }
            screenContent = calculatorScreen.getText().toString();
            calculatorScreen.setText(screenContent);
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
//        btClear.setOnClickListener(calculatorListener);
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
//                String screenContent = calculatorScreen.getText().toString();
                String screenContentFix = calculatorScreen.getText().toString();
                screenContent = screenContentFix.replace(",", "");

                if (!clearFunc) {
                    int length = screenContent.length();
                    if (length > 0 ){
                        String secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        if (secondNumberString.isEmpty()) {
                            isOpPressed = false;
                            isDot = false;
                        }
                        screenContent = screenContent.substring(0,length - 1);
                        calculatorScreen.setText(screenContent);
                    }
                } else {
                    isOpPressed = false;
                    isDot = false;
                    clearFunc = false;
                    calculatorScreen.setText("");
                    btDelete.setText("DEL");
                }
            }
        });
    }
    private void OpPressed(char operation) {
        if (isOpPressed) {
            return;
        }
//        screenContent = calculatorScreen.getText().toString();
        if ( screenContent.isEmpty() && operation == '-' ) {
            calculatorScreen.append(String.valueOf(operation));
            isOpPressed = true;
            isDot = false;
            currentOp = operation;
        } else if ( screenContent.isEmpty()) {
            return;
        } else {
            secondNumberIndex = screenContent.length() + 1;
            firstNumber = new BigDecimal(screenContent);
            calculatorScreen.append(String.valueOf(operation));
            isOpPressed = true;
            isDot = false;
            currentOp = operation;
        }
        clearFunc = false;
    }
}