package com.haya.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private String screenContent;

    private String resultContent;

    private String stringOp;

    private String firstNumberString;

    private String secondNumberString;

    private boolean isOpPressed = false;

    private boolean isDot = false;

    private boolean isEqual = false;

    private BigDecimal firstNumber;

    private BigDecimal secondNumber;

    private BigDecimal resultNumber;

    private int secondNumberIndex;

    private char currentOp;

    private TextView calculatorScreen;

    private TextView resultScreen;

    DecimalFormat decimalFormat = new DecimalFormat("#,###.##############");

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
        final Button btDot = findViewById(R.id.btDot);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String screenContentFix = calculatorScreen.getText().toString();

                if (view.getId() == R.id.btSubtract && screenContentFix.isEmpty()) {
                    calculatorScreen.append(String.valueOf("-"));
                    return;
                }

                // return処理まとめ
                if (view.getId() == R.id.btDivide||view.getId() == R.id.btMultiply||view.getId() == R.id.btSubtract||view.getId() == R.id.btAdd||view.getId() == R.id.btEqual||view.getId() == R.id.btDot||screenContentFix.isEmpty()) {
                    if (screenContentFix.endsWith("+")||screenContentFix.endsWith("-")||screenContentFix.endsWith("×")||screenContentFix.endsWith("÷")||screenContentFix.endsWith(".")) {
                        return;
                    }
                }

                if (isDot && view.getId() == R.id.btDot) {
                    return;
                }

                if (view.getId() == R.id.btEqual) {
                    if (secondNumberString.equals("0")) {
                        return;
                    }
                }

                if (firstNumberString != null) {
                    firstNumberString = firstNumberString.replace(",", "");
                }
                if (secondNumberString != null) {
                    secondNumberString = secondNumberString.replace(",", "");
                }

                screenContent = screenContentFix.replace(",", "");
                calculatorScreen.setText(screenContent);

                final int id = view.getId();

            switch (id){
                case R.id.n0:

                    calculatorScreen.append("0");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n1:
                    calculatorScreen.append("1");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n2:
                    calculatorScreen.append("2");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n3:
                    calculatorScreen.append("3");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }
                    break;
                case R.id.n4:
                    calculatorScreen.append("4");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n5:
                    calculatorScreen.append("5");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n6:
                    calculatorScreen.append("6");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n7:
                    calculatorScreen.append("7");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n8:
                    calculatorScreen.append("8");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
                    }

                    break;
                case R.id.n9:
                    calculatorScreen.append("9");
                    screenContent = calculatorScreen.getText().toString();

                    if (isOpPressed) {
                        secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                    } else {
                        firstNumberString = calculatorScreen.getText().toString();
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
                case R.id.btDot:

                    if (!isDot) {

                        isDot = true;
                        AddComma();
                        if (secondNumberString != null) {
                            secondNumberString = secondNumberString + ".";
                            screenContent = firstNumberString + stringOp + secondNumberString;
                        } else {
                            firstNumberString = firstNumberString + ".";
                            screenContent = firstNumberString;
                        }
                        calculatorScreen.setText(screenContent);
                    }
                    return;
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
                                secondNumber = null;
                            } else {
                                secondNumberString = screenContent.substring(secondNumberIndex,screenContentlength - 1);
                                if (secondNumberString.endsWith(".")) {
                                    AddComma();
                                    secondNumberString = secondNumberString + ".";
                                    screenContent = firstNumberString + stringOp + secondNumberString;
                                    calculatorScreen.setText(screenContent);
                                    return;
                                }
                            }
                        } else {
                            if (firstNumberString.length() == 1) {
                                firstNumberString = null;
                                firstNumber = null;
                                calculatorScreen.setText("");
                                screenContent = calculatorScreen.getText().toString();
                            } else {
                                firstNumberString = screenContent.substring(0,screenContentlength - 1);
                                screenContent = firstNumberString;
                                if (firstNumberString.endsWith(".")) {
                                    AddComma();
                                    firstNumberString = firstNumberString + ".";
                                    screenContent = firstNumberString;
                                    calculatorScreen.setText(screenContent);
                                    return;
                                }
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
                    firstNumber = null;
                    secondNumber = null;
                    screenContent = null;
                    calculatorScreen.setText("");
                    screenContent = calculatorScreen.getText().toString();
                    break;
                case R.id.btEqual:
                    if (isOpPressed) {
                        Equal();

                        firstNumberString = resultContent;
                        firstNumberString = firstNumberString.replace(",", "");

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

                firstNumber = new BigDecimal(firstNumberString);
                firstNumberString = decimalFormat.format(firstNumber);

                secondNumber = new BigDecimal(secondNumberString);

                if (!(currentOp == '÷' && secondNumber.compareTo(BigDecimal.ZERO) == 0)) {
                    Equal();
                    resultContent = decimalFormat.format(resultNumber);
                    resultScreen.setText(resultContent);
                }

                if (isDot && secondNumberString.endsWith("0")) {
                    secondNumberString = secondNumber.toString();
                } else {
                    secondNumberString = decimalFormat.format(secondNumber);
                }

                screenContent = firstNumberString + stringOp + secondNumberString;

            } else if (isOpPressed) {

                firstNumber = new BigDecimal(firstNumberString);
                firstNumberString = decimalFormat.format(firstNumber);
                screenContent = firstNumberString + stringOp;
                resultScreen.setText("");

            } else if (firstNumberString != null && !(firstNumberString.equals("-"))){

                firstNumber = new BigDecimal(firstNumberString);
                if (isDot && firstNumberString.endsWith("0")) {
                    firstNumberString = firstNumber.toString();
                } else {
                    firstNumberString = decimalFormat.format(firstNumber);
                }
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
        btDot.setOnClickListener(calculatorListener);
    }

    private void OpPressed(char operation) {
        if (!isOpPressed) {
            firstNumber = firstNumber.stripTrailingZeros();
            firstNumberString = firstNumber.toString();
            secondNumberIndex = firstNumberString.length() + 1;
            isOpPressed = true;
            isDot = false;
            currentOp = operation;
            stringOp = String.valueOf(operation);
        }
    }

    private void Equal() {

        if (currentOp == '+'){
            resultNumber = secondNumber.add(firstNumber);
        } else if (currentOp == '-'){
            resultNumber = firstNumber.subtract(secondNumber);
        } else if (currentOp == '×') {
            resultNumber = firstNumber.multiply(secondNumber);
        } else if (currentOp == '÷') {
            resultNumber = firstNumber.divide(secondNumber, 14, RoundingMode.HALF_UP);
        }
    }

    private void AddComma() {
        if (isOpPressed && secondNumberString != null) {

            firstNumber = new BigDecimal(firstNumberString);
            firstNumberString = decimalFormat.format(firstNumber);

            secondNumber = new BigDecimal(secondNumberString);

            if (isDot && secondNumberString.endsWith("0")) {
                secondNumberString = secondNumber.toString();
            } else {
                secondNumberString = decimalFormat.format(secondNumber);
            }
            screenContent = firstNumberString + stringOp + secondNumberString;

        } else if (isOpPressed) {

            firstNumber = new BigDecimal(firstNumberString);
            firstNumberString = decimalFormat.format(firstNumber);
            screenContent = firstNumberString + stringOp;

        } else {

            firstNumber = new BigDecimal(firstNumberString);
            if (isDot && firstNumberString.endsWith("0")) {
                firstNumberString = firstNumber.toString();
            } else {
                firstNumberString = decimalFormat.format(firstNumber);
            }
            screenContent = firstNumberString;

        }
    }
}