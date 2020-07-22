package com.haya.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.lang.Object;
import java.util.Objects;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String screenContent;

    private String resultContent;

    private String test = "0";

    private String zero = "0";

    private String minus = "-";

    private String empty = null;

    private String stringOp;

    private String firstNumberString;

    private String secondNumberString;

    private boolean isOpPressed = false;

    private boolean isDot = false;

    private boolean isEqual = false;

    private boolean firstminus = false;

    private BigDecimal firstNumber;

    private BigDecimal secondNumber;

    private int secondNumberIndex;

    private char currentOp;

    private TextView calculatorScreen;

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
        final Button btClear = findViewById(R.id.btClear);
        final ImageButton btDelete = findViewById(R.id.btDelete);
        final Button btDivide = findViewById(R.id.btDivide);
        final Button btMultiply = findViewById(R.id.btMultiply);
        final Button btSubtract = findViewById(R.id.btSubtract);
        final Button btAdd = findViewById(R.id.btAdd);
        final Button btEqual = findViewById(R.id.btEqual);
        final Button btPoint = findViewById(R.id.btPoint);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String screenContent = calculatorScreen.getText().toString();
                String screenContentFix = calculatorScreen.getText().toString();
//                if (screenContentFix == zero) {
//                    isZero = true;
//                }
                screenContent = screenContentFix.replace(",", "");
//                String str = "1111×2222";
////                List<String> split = Arrays.asList(str.split("×"));
////                System.out.println(split.get(0));
////                System.out.println(split.get(1));

                calculatorScreen.setText(screenContent);
                final int id = view.getId();

            switch (id){
                case R.id.n0:
//                    if ( isZero && !isDot ) {
//                        return;
//                    } else if (isDot){
//                        isZero = false;
//                        isOpPressed = false;
//                    screenContent = calculatorScreen.getText().toString();
//                    firstNumber = new BigDecimal(screenContent);
//                    test = "1";
//                    if ("0".equals(screenContent)) {
//                        return;
//                    }
                    calculatorScreen.append("0");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = nf.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = nf.format(firstNumber);
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n1:
                    calculatorScreen.append("1");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = nf.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = nf.format(firstNumber);
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n2:
                    calculatorScreen.append("2");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n3:
                    calculatorScreen.append("3");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n4:
                    calculatorScreen.append("4");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n5:
                    calculatorScreen.append("5");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n6:
                    calculatorScreen.append("6");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n7:
                    calculatorScreen.append("7");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n8:
                    calculatorScreen.append("8");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
                    break;
                case R.id.n9:
                    calculatorScreen.append("9");
                    screenContent = calculatorScreen.getText().toString();
                    test = "1";
//                    BigDecimal screenContentNumber = new BigDecimal(screenContent);
//                    screenContent = screenContentNumber.toString();
                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = secondNumber.toString();
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = firstNumber.toString();
                    }
//                    } else if (!isZero){
//                        isZero = true;
//                        isOpPressed = false;
//                        calculatorScreen.append("0");
//                    }
                    test = "1";
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
                    if (screenContent.isEmpty()||screenContent.endsWith("+")||screenContent.endsWith("-")||screenContent.endsWith("×")||screenContent.endsWith("÷")||screenContent.endsWith(".")) {
                        return;
                    }
                    test = "1";
                    if (!isDot) {
                        calculatorScreen.append(".");
                        screenContent = calculatorScreen.getText().toString();
                        isDot = true;
//                        if (isOpPressed && secondNumberString != null) {
////                            screenContent = firstNumberString + stringOp + secondNumberString;
//                            if (secondNumberString.length() == 1) {
//                                secondNumberString = null;
//                            } else {
//                                secondNumberString = screenContent.substring(secondNumberIndex,screenContentlength - 1);
//                            }
//                        } else {
//                            firstNumberString = screenContent.substring(0,screenContentlength - 1);
                            if (isOpPressed) {
                                secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
//                                secondNumber = new BigDecimal(secondNumberString);
//                                secondNumberString = secondNumber.toString();
                            } else {
                                firstNumberString = calculatorScreen.getText().toString();
                                firstNumber = new BigDecimal(firstNumberString);
                                firstNumberString = nf.format(firstNumber);
                                firstNumberString = firstNumberString + ".";
                            }
                        }
                    test = "1";
                    break;
                case R.id.btDelete:
                    int screenContentlength = screenContent.length();
                    if (screenContentlength > 0 ){
                        if (screenContent.endsWith("+")||screenContent.endsWith("-")||screenContent.endsWith("×")||screenContent.endsWith("÷")) {
//                            if (firstminus) {
//                                firstminus = false;
//                            }
                            isOpPressed = false;
                            stringOp = null;
                            currentOp = '\u0000';
                            secondNumberIndex = 0;
                        }
                        if (screenContent.endsWith(".")) {
                            isDot = false;
                        }
//                        firstNumberString = screenContent.substring(0,screenContentlength - 1);
//                        firstNumberString = screenContent
//                        calculatorScreen.setText(screenContent);
                        if (isOpPressed && secondNumberString != null) {
//                            screenContent = firstNumberString + stringOp + secondNumberString;
                            if (secondNumberString.length() == 1) {
                                secondNumberString = null;
                            } else {
                                secondNumberString = screenContent.substring(secondNumberIndex,screenContentlength - 1);
                                secondNumber = new BigDecimal(secondNumberString);
                                secondNumberString = nf.format(secondNumber);
                            }
                        } else {
//                            firstNumberString = screenContent.substring(0,screenContentlength - 1);
                            if (firstNumberString.length() == 1) {
                                firstNumberString = null;
                                screenContent = null;
                            } else {
                                firstNumberString = screenContent.substring(0,screenContentlength - 1);
                                firstNumber = new BigDecimal(firstNumberString);
                                secondNumberString = nf.format(firstNumber);
                            }
                        }
                    }
                    test = "1";
                    break;
                case R.id.btClear:
                    isOpPressed = false;
                    isDot = false;
//                    firstminus = false;
                    stringOp = null;
                    currentOp = '\u0000';
                    firstNumberString = null;
                    secondNumberString = null;
                    calculatorScreen.setText("");
                    screenContent = calculatorScreen.getText().toString();
                    btDelete.setVisibility(View.VISIBLE);
                    break;
                case R.id.btEqual:
                    if (screenContent.endsWith("+")||screenContent.endsWith("-")||screenContent.endsWith("×")||screenContent.endsWith("÷")||screenContent.endsWith(".")) {
                        return;
                    }
                    if (isOpPressed) {
                        test = "1";
//                        screenContent = calculatorScreen.getText().toString();
//                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        firstNumberString = firstNumberString.replace(",", "");
                        secondNumberString = secondNumberString.replace(",", "");
                        secondNumber = new BigDecimal(secondNumberString);
                        firstNumber = new BigDecimal(firstNumberString);

                        if (currentOp == '+'){
                            secondNumber = secondNumber.add(firstNumber);
                        } else if (currentOp == '-'){
                            secondNumber = firstNumber.subtract(secondNumber);
                        } else if (currentOp == '×') {
                            secondNumber = firstNumber.multiply(secondNumber);
                        } else if (currentOp == '÷') {
                            if ( secondNumber.compareTo(BigDecimal.ZERO) == 0 ) {
                                return;
                            }
                            secondNumber = firstNumber.divide(secondNumber, 14, RoundingMode.HALF_UP);
                        }
//                        screenContent = secondNumber.toString();
                        screenContent = nf.format(secondNumber);
                        if (screenContent.endsWith(".0")) {
                            screenContent = screenContent.substring(0, screenContent.length() - 2);
                        }

                        calculatorScreen.setText(String.valueOf(screenContent));

                        firstNumberString = calculatorScreen.getText().toString();
                        secondNumberString = null;
//
//                        long resultNumber = secondNumber.longValue();
////                      String result = nf.format(secondNumber);
//                        String result = String.format("%,d",resultNumber);

                        isOpPressed = false;
                        isDot = false;
//                        firstminus = false;
                        stringOp = null;
                        currentOp = '\u0000';
                        if (screenContent.contains(".")) {
                            isDot = true;
                        }
//                        if (result.contains("-")) {
//                            firstminus = true;
//                        }
                        isEqual = true;
                        break;
                    }
            }
            if (isEqual) {
                btDelete.setVisibility(View.INVISIBLE);
                isEqual = false;
            } else {
                btDelete.setVisibility(View.VISIBLE);
            }
//            screenContent = calculatorScreen.getText().toString();
//            calculatorScreen.setText(firstNumberString);
//            calculatorScreen.setText(secondNumberString);
            test = "1";
//                null.equals(screenContent)
            if (isOpPressed && secondNumberString != null) {
                screenContent = firstNumberString + stringOp + secondNumberString;
            } else if (isOpPressed) {
                screenContent = firstNumberString + stringOp;
            } else {
                screenContent = firstNumberString;
            }
            calculatorScreen.setText(screenContent);
//            long resultNumber = secondNumber.longValue();
//                        String result = nf.format(secondNumber);
//            String result = String.format("%,d",resultNumber);
            test = "1";
            //            int screenContentLength = screenContent.length();
//            if (firstminus) {
//                if (screenContent == firstMinusString ) {
//                    screenContent = calculatorScreen.getText().toString();
//                } else {
//                    screenContent = screenContent.substring(1,screenContentLength);
//                }
//            }
//            test = "1";
//            if (isOpPressed && (screenContent.endsWith("-")||screenContent.endsWith("+")||screenContent.endsWith("×")||screenContent.endsWith("÷"))) {
//                screenContent = screenContent.substring(0,secondNumberIndex - 1);
//            }
//                test = "1";
//            if (isOpPressed && (screenContent.contains("+")||screenContent.contains("-")||screenContent.contains("×")||screenContent.contains("÷"))) {
//                if (currentOp == '+') {
//                    List<String> split = Arrays.asList(screenContent.split("\\+"));
//                    firstNumberString = split.get(0);
//                    secondNumberString = split.get(1);
//                    screenContent = firstNumberString + stringOp + secondNumberString;
//                } else if (currentOp == '-') {
//                    List<String> split = Arrays.asList(screenContent.split("\\-"));
//                    firstNumberString = split.get(0);
//                    secondNumberString = split.get(1);
//                    screenContent = firstNumberString + stringOp + secondNumberString;
//                } else if (currentOp == '×' || currentOp == '÷') {
//                    List<String> split = Arrays.asList(screenContent.split(stringOp));
//                    firstNumberString = split.get(0);
//                    secondNumberString = split.get(1);
//                    screenContent = firstNumberString + stringOp + secondNumberString;
//                }
//            }
//                test = "1";
//            if (firstminus || (!screenContent.contains("+")&&!screenContent.contains("-")&&!screenContent.contains("×")&&!screenContent.contains("÷"))) {
//                if (isOpPressed) {
//                    screenContent = screenContent + stringOp;
//                }
////                if (firstminus) {
////                    screenContent = firstMinusString + screenContent;
////                }
//                calculatorScreen.setText(screenContent);
//            }
//            test = "1";
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
        btDelete.setOnClickListener(calculatorListener);
        btDivide.setOnClickListener(calculatorListener);
        btMultiply.setOnClickListener(calculatorListener);
        btSubtract.setOnClickListener(calculatorListener);
        btAdd.setOnClickListener(calculatorListener);
        btEqual.setOnClickListener(calculatorListener);
        btPoint.setOnClickListener(calculatorListener);
    }

    private void OpPressed(char operation) {
//        screenContent = calculatorScreen.getText().toString();
        test = "1";
//        String minus = "-";
        if (isOpPressed||"-".equals(screenContent)||screenContent.isEmpty()) {
            return;
        }
        test = "1";
        if ( screenContent.isEmpty() && operation == '-' ) {
//            isOpPressed = true;
//            isDot = false;
            firstminus = true;
            calculatorScreen.append(String.valueOf(operation));
//            currentOp = operation;
//            firstminusString = String.valueOf(operation);
        } else {
            secondNumberIndex = screenContent.length() + 1;
//            firstNumber = new BigDecimal(screenContent);
//            calculatorScreen.append(String.valueOf(operation));
            isOpPressed = true;
            isDot = false;
            currentOp = operation;
            stringOp = String.valueOf(operation);
            //         // String kakeru_st = String.valueOf(kakeru);
        }
        test = "1";
//        screenContent = calculatorScreen.getText().toString();
    }
}