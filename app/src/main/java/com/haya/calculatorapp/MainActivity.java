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
import java.text.DecimalFormat;
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

    private BigDecimal resultNumber;

    private int secondNumberIndex;

    private int a = 10;

    private char currentOp;

    private TextView calculatorScreen;

    private TextView resultScreen;

//    NumberFormat nf2 = NumberFormat.getMaximumFractionDigits();

    NumberFormat nf = NumberFormat.getNumberInstance();

//    NumberFormat mf = NumberFormat.get(10);

    DecimalFormat decimalFormat = new DecimalFormat("#,###.##########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        calculatorScreen = findViewById(R.id.tvFormula);
        resultScreen = findViewById(R.id.tvResult);

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

                String screenContentFix = calculatorScreen.getText().toString();

                screenContent = screenContentFix.replace(",", "");

                calculatorScreen.setText(screenContent);
                final int id = view.getId();



//                String[] numbers = {"1","2","3"};
//
//                for(String n:numbers) {
//                    if (nn.getId() == R.id.nn) {
//                        if (firstNumberString.startsWith("0")) {
//                            calculatorScreen.append("0");
//                        }
//                    }
//                }

            switch (id){
                case R.id.n0:
                    calculatorScreen.append("0");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
//                        if (firstNumberString.startsWith("0")&& !isDot ) {
//                            firstNumberString = screenContent.substring(0,screenContent.length() -1 );
//                            return;
//                        }
                        firstNumber = new BigDecimal(firstNumberString);
//                        firstNumberString = decimalFormat.format(firstNumber);
//                        int firstNumberint = firstNumber.intValue();
//                        firstNumberString = firstNumber.toString();
//                        nf.getMaximumFractionDigits();
//                        nf.getMinimumFractionDigits();
                        nf.setMinimumFractionDigits(2);
                        nf.setMaximumFractionDigits(7);

//                        firstNumberString = decimalFormat.format(firstNumber);
                        firstNumberString = nf.format(firstNumber);
                    }

                    break;
                case R.id.n1:
                    calculatorScreen.append("1");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        nf.setMaximumFractionDigits(12);
//                        firstNumberString = decimalFormat.format(firstNumber);
                        firstNumberString = nf.format(firstNumber);
                    }

                    break;
                case R.id.n2:
                    calculatorScreen.append("2");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

                    break;
                case R.id.n3:
                    calculatorScreen.append("3");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

                    break;
                case R.id.n4:
                    calculatorScreen.append("4");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

                    break;
                case R.id.n5:
                    calculatorScreen.append("5");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

                    break;
                case R.id.n6:
                    calculatorScreen.append("6");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

                    break;
                case R.id.n7:
                    calculatorScreen.append("7");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

                    break;
                case R.id.n8:
                    calculatorScreen.append("8");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

                    break;
                case R.id.n9:
                    calculatorScreen.append("9");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                        secondNumber = new BigDecimal(secondNumberString);
                        secondNumber = secondNumber.stripTrailingZeros();
                        secondNumberString = decimalFormat.format(secondNumber);
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                        firstNumber = new BigDecimal(firstNumberString);
                        firstNumberString = decimalFormat.format(firstNumber);
                    }

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
                        if (isOpPressed && secondNumberString != null) {
                            screenContent = firstNumberString + stringOp + secondNumberString;
                        } else if (isOpPressed) {
                            screenContent = firstNumberString + stringOp;
                        } else {
                            screenContent = firstNumberString;
                        }
                        calculatorScreen.setText(screenContent);
                        return;
                    }

                    if (!isDot) {
                        calculatorScreen.append(".");
                        screenContent = calculatorScreen.getText().toString();
                        isDot = true;
                            if (isOpPressed) {
                                secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                            } else {
                                firstNumberString = calculatorScreen.getText().toString();
                                firstNumber = new BigDecimal(firstNumberString);
                                firstNumberString = nf.format(firstNumber);
                                firstNumberString = firstNumberString + ".";
                            }
                        }
                    break;
                case R.id.btDelete:
                    int screenContentlength = screenContent.length();
                    if (screenContentlength > 0 ){
                        if (screenContent.endsWith("+")||screenContent.endsWith("-")||screenContent.endsWith("×")||screenContent.endsWith("÷")) {
                            isOpPressed = false;
                            stringOp = null;
                            currentOp = '\u0000';
                            secondNumberIndex = 0;
                        }
                        if (screenContent.endsWith(".")) {
                            isDot = false;
                        }
                        if (isOpPressed && secondNumberString != null) {
                            if (secondNumberString.length() == 1) {
                                secondNumberString = null;
                            } else {
                                secondNumberString = screenContent.substring(secondNumberIndex,screenContentlength - 1);
                                secondNumber = new BigDecimal(secondNumberString);
                                secondNumberString = nf.format(secondNumber);
                            }
                        } else {
                            if (firstNumberString.length() == 1) {
                                firstNumberString = null;
                                screenContent = null;
                            } else {
                                firstNumberString = screenContent.substring(0,screenContentlength - 1);
                                firstNumber = new BigDecimal(firstNumberString);
                                firstNumberString = nf.format(firstNumber);
                            }
                        }
                    }

                    break;
                case R.id.btClear:
                    isOpPressed = false;
                    isDot = false;
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
                        Equal();
                        screenContent = decimalFormat.format(resultNumber);

                        calculatorScreen.setText(String.valueOf(screenContent));
                        firstNumberString = calculatorScreen.getText().toString();
                        secondNumberString = null;
                        secondNumber = null;

                        isOpPressed = false;
                        isDot = false;
                        stringOp = null;
                        currentOp = '\u0000';
                        if (screenContent.contains(".")) {
                            isDot = true;
                        }
                        isEqual = true;
                        resultScreen.setText("");
                        break;
                    }
            }
            if (isEqual) {
                btDelete.setVisibility(View.INVISIBLE);
                isEqual = false;
            } else {
                btDelete.setVisibility(View.VISIBLE);
            }

            if (isOpPressed && secondNumberString != null) {
                screenContent = firstNumberString + stringOp + secondNumberString;
                Equal();
                resultContent = decimalFormat.format(resultNumber);
                resultScreen.setText(resultContent);
            } else if (isOpPressed) {
                screenContent = firstNumberString + stringOp;
                resultScreen.setText("");

            } else {
                screenContent = firstNumberString;
                resultScreen.setText("");
            }
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
        if (isOpPressed||"-".equals(screenContent)||screenContent.isEmpty()||screenContent.endsWith(".")) {
            return;
        }

        if ( screenContent.isEmpty() && operation == '-' ) {
            firstminus = true;
            calculatorScreen.append(String.valueOf(operation));
        } else {
            secondNumberIndex = screenContent.length() + 1;
            isOpPressed = true;
            isDot = false;
            currentOp = operation;
            stringOp = String.valueOf(operation);
        }

    }
    private void Equal() {


        firstNumberString = firstNumberString.replace(",", "");
        secondNumberString = secondNumberString.replace(",", "");
        secondNumber = new BigDecimal(secondNumberString);
        firstNumber = new BigDecimal(firstNumberString);

        if (currentOp == '+'){
            resultNumber = secondNumber.add(firstNumber);
        } else if (currentOp == '-'){
            resultNumber = firstNumber.subtract(secondNumber);
        } else if (currentOp == '×') {
            resultNumber = firstNumber.multiply(secondNumber);
        } else if (currentOp == '÷') {
            if ( secondNumber.compareTo(BigDecimal.ZERO) == 0 ) {
                return;
            }
            resultNumber = firstNumber.divide(secondNumber, 14, RoundingMode.HALF_UP);
        }
    }
}