package jp.co.hnut.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import android.media.MediaPlayer;
import android.media.AudioAttributes;
import android.media.SoundPool;


public class MainActivity extends AppCompatActivity {

    private int test = 0;

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

    private SoundPool soundPool;

    // ピアノ音源変数
    private int piano_c, piano_d, piano_e, piano_f, piano_g, piano_a, piano_b, piano_c_high, piano_d_high, piano_e_high,
                del_piano, clear_piano, divide_piano, multiply_piano, minus_piano, plus_piano, equal_piano, dot_piano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        calculatorScreen = findViewById(R.id.tvFormula);
        resultScreen = findViewById(R.id.tvResult);

        //属性の定義
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        // SoundPoolの作成
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                // ストリーム数に応じて
                .setMaxStreams(10)
                .build();

        // 0~9のピアノ音源読み込み
        piano_c = soundPool.load(this, R.raw.piano_c, 1);
        piano_d = soundPool.load(this, R.raw.piano_d, 1);
        piano_e = soundPool.load(this, R.raw.piano_e, 1);
        piano_f = soundPool.load(this, R.raw.piano_f, 1);
        piano_g = soundPool.load(this, R.raw.piano_g, 1);
        piano_a = soundPool.load(this, R.raw.piano_a, 1);
        piano_b = soundPool.load(this, R.raw.piano_b, 1);
        piano_c_high = soundPool.load(this, R.raw.piano_c_high, 1);
        piano_d_high = soundPool.load(this, R.raw.piano_d_high, 1);
        piano_e_high = soundPool.load(this, R.raw.piano_e_high, 1);
        // 0~9以外のピアノ音源読み込み
        del_piano = soundPool.load(this, R.raw.del_piano, 1);
        clear_piano = soundPool.load(this, R.raw.clear_piano, 1);
        divide_piano = soundPool.load(this, R.raw.divide_piano, 1);
        multiply_piano = soundPool.load(this, R.raw.multiply_piano, 1);
        minus_piano = soundPool.load(this, R.raw.minus_piano, 1);
        plus_piano = soundPool.load(this, R.raw.plus_piano, 1);
        equal_piano = soundPool.load(this, R.raw.equal_piano, 1);
        dot_piano = soundPool.load(this, R.raw.dot_piano, 1);

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
        final Button btDelete = findViewById(R.id.btDelete);
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

                // 画面が空の時にマイナスを入力する処理
                if (view.getId() == R.id.btSubtract && screenContentFix.isEmpty()) {
                    soundPool.play(divide_piano, 1.0f, 1.0f, 0, 0, 1);
                    calculatorScreen.append(String.valueOf("-"));
                    screenContent = calculatorScreen.getText().toString();
                    return;
                }

                // 不適切な入力時にreturn
                if (view.getId() == R.id.btDivide||view.getId() == R.id.btMultiply||view.getId() == R.id.btSubtract||view.getId() == R.id.btAdd||view.getId() == R.id.btEqual||view.getId() == R.id.btDot) {
                    if (screenContentFix.isEmpty()) {
                        soundPool.play(del_piano, 1.0f, 1.0f, 0, 0, 1);
                        return;
                    }
                    if (screenContentFix.endsWith("+")||screenContentFix.endsWith("-")||screenContentFix.endsWith("×")||screenContentFix.endsWith("÷")||screenContentFix.endsWith(".")) {
                        soundPool.play(del_piano, 1.0f, 1.0f, 0, 0, 1);
                        return;
                    }
                }
                // ドットが押されている状態で、ドットを押した時にreturn
                if (isDot && view.getId() == R.id.btDot) {
                    soundPool.play(del_piano, 1.0f, 1.0f, 0, 0, 1);
                    return;
                }

                // イコールを押した時、２項目がなければreturn
                if (view.getId() == R.id.btEqual) {
                    if (secondNumberString == null) {
                        soundPool.play(del_piano, 1.0f, 1.0f, 0, 0, 1);
                        return;
                    }
                    // イコールを押した時、割り算で２項目が0ならreturn
                    if (currentOp == '÷' || secondNumberString.equals("0")) {
                        soundPool.play(del_piano, 1.0f, 1.0f, 0, 0, 1);
                        return;
                    }
                }

                // 文字列のカンマを取り除く処理
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
                    ButtonFunc();
                    n0.setBackgroundResource(R.drawable.whitenote);
                    soundPool.play(piano_e_high, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n1:

                    calculatorScreen.append("1");
                    ButtonFunc();
                    n1.setBackgroundResource(R.drawable.blacknote);
                    soundPool.play(piano_c, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n2:

                    calculatorScreen.append("2");
                    ButtonFunc();
                    n2.setBackgroundResource(R.drawable.whitenote);
                    soundPool.play(piano_d, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n3:

                    calculatorScreen.append("3");
                    ButtonFunc();
                    n3.setBackgroundResource(R.drawable.blacknote);
                    soundPool.play(piano_e, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n4:

                    calculatorScreen.append("4");
                    ButtonFunc();
                    n4.setBackgroundResource(R.drawable.blacknote);
                    soundPool.play(piano_f, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n5:

                    calculatorScreen.append("5");
                    ButtonFunc();
                    n5.setBackgroundResource(R.drawable.whitenote);
                    soundPool.play(piano_g, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n6:

                    calculatorScreen.append("6");
                    ButtonFunc();
                    n6.setBackgroundResource(R.drawable.blacknote);
                    soundPool.play(piano_a, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n7:

                    calculatorScreen.append("7");
                    ButtonFunc();
                    n7.setBackgroundResource(R.drawable.blacknote);
                    soundPool.play(piano_b, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n8:

                    calculatorScreen.append("8");
                    ButtonFunc();
                    n8.setBackgroundResource(R.drawable.whitenote);
                    soundPool.play(piano_c_high, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.n9:

                    calculatorScreen.append("9");
                    ButtonFunc();
                    n9.setBackgroundResource(R.drawable.blacknote);
                    soundPool.play(piano_d_high, 1.0f, 1.0f, 0, 0, 1);

                    break;

                case R.id.btDivide:
                    OpPressed('÷');
                    BackgroundBlack();
                    BackgroundWhite();
                    soundPool.play(divide_piano, 1.0f, 1.0f, 0, 0, 1);
                    break;
                case R.id.btMultiply:
                    OpPressed('×');
                    BackgroundBlack();
                    BackgroundWhite();
                    soundPool.play(multiply_piano, 1.0f, 1.0f, 0, 0, 1);
                    break;
                case R.id.btSubtract:
                    OpPressed('-');
                    BackgroundBlack();
                    BackgroundWhite();
                    soundPool.play(minus_piano, 1.0f, 1.0f, 0, 0, 1);
                    break;
                case R.id.btAdd:
                    OpPressed('+');
                    BackgroundBlack();
                    BackgroundWhite();
                    soundPool.play(plus_piano, 1.0f, 1.0f, 0, 0, 1);
                    break;
                case R.id.btDot:

                    soundPool.play(dot_piano, 1.0f, 1.0f, 0, 0, 1);
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
                    BackgroundBlack();
                    BackgroundWhite();
                    return;

                case R.id.btDelete:

                    soundPool.play(del_piano, 1.0f, 1.0f, 0, 0, 1);
                    int screenContentlength = screenContent.length();

                    if (screenContentlength > 0 ){

                        // 最後の文字が +,-,×,÷だった時の処理
                        if (screenContent.endsWith("+")||screenContent.endsWith("-")||screenContent.endsWith("×")||screenContent.endsWith("÷")) {
                            // 画面が - だけだった時は、画面をリセットする
                            if (screenContent.equals("-")) {
                                calculatorScreen.setText("");
                                screenContent = calculatorScreen.getText().toString();
                                return;
                            }
                            isOpPressed = false;
                            stringOp = null;
                            currentOp = '\u0000';
                            secondNumberIndex = 0;
                            AddComma();
                            calculatorScreen.setText(screenContent);
                            BackgroundBlack();
                            BackgroundWhite();
                            return;
                        }

                        //最後の文字が"."だった時の処理
                        if (screenContent.endsWith(".")) {
                            isDot = false;
                        }

                        if (isOpPressed && secondNumberString != null) {
                            // ２項目の文字が一文字だった時
                            if (secondNumberString.length() == 1) {
                                secondNumberString = null;
                                secondNumber = null;
                            } else {
                                secondNumberString = screenContent.substring(secondNumberIndex,screenContentlength - 1);

                                //一文字削除した後の最後の文字がカンマだった時の処理
                                if (secondNumberString.endsWith(".")) {
                                    AddComma();
                                    secondNumberString = secondNumberString + ".";
                                    screenContent = firstNumberString + stringOp + secondNumberString;
                                    calculatorScreen.setText(screenContent);
                                    BackgroundBlack();
                                    BackgroundWhite();
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

                                //一文字削除した後の最後の文字がカンマだった時の処理
                                if (firstNumberString.endsWith(".")) {
                                    AddComma();
                                    firstNumberString = firstNumberString + ".";
                                    screenContent = firstNumberString;
                                    calculatorScreen.setText(screenContent);
                                    BackgroundBlack();
                                    BackgroundWhite();
                                    return;
                                }
                            }
                        }
                    }
                    BackgroundBlack();
                    BackgroundWhite();
                    break;

                case R.id.btClear:

                    soundPool.play(clear_piano, 1.0f, 1.0f, 0, 0, 1);
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
                    BackgroundBlack();
                    BackgroundWhite();
                    break;

                case R.id.btEqual:

                    soundPool.play(equal_piano, 1.0f, 1.0f, 0, 0, 1);
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
                        // 答えに小数点が含まれている場合の処理
                        if (screenContent.contains(".")) {
                            isDot = true;
                        }

                        isEqual = true;
                        resultScreen.setText("");
                        BackgroundBlack();
                        BackgroundWhite();
                        break;
                    }
            }

            //イコールを押した時にDELボタンがクリアボタンになる処理
            if (isEqual) {
                btDelete.setVisibility(View.INVISIBLE);
                isEqual = false;
            } else {
                btDelete.setVisibility(View.VISIBLE);
            }

            // カンマを追加する処理
            AddComma();

            // 2項目の値がある時だけ、計算結果を自動で表示
            if (isOpPressed && secondNumberString != null) {
                if (!(currentOp == '÷' && secondNumberString.equals("0"))) {
                    Equal();
                    resultContent = decimalFormat.format(resultNumber);
                    resultScreen.setText(resultContent);
                }
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
            firstNumberString = firstNumber.toPlainString();
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

        //カンマを追加する処理
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
            resultScreen.setText("");

        } else if (firstNumberString != null && !firstNumberString.equals("-")) {

            firstNumber = new BigDecimal(firstNumberString);
            if (isDot && firstNumberString.endsWith("0")) {
                firstNumberString = firstNumber.toString();
            } else {
                firstNumberString = decimalFormat.format(firstNumber);
            }
            screenContent = firstNumberString;
            resultScreen.setText("");
        }
    }

    private void BackgroundBlack() {

        final Button n1 = findViewById(R.id.n1);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n9 = findViewById(R.id.n9);

        n1.setBackgroundResource(R.color.colorBlack);
        n3.setBackgroundResource(R.color.colorBlack);
        n4.setBackgroundResource(R.color.colorBlack);
        n6.setBackgroundResource(R.color.colorBlack);
        n7.setBackgroundResource(R.color.colorBlack);
        n9.setBackgroundResource(R.color.colorBlack);

    }

    private void BackgroundWhite() {

        final Button n0 = findViewById(R.id.n0);
        final Button n2 = findViewById(R.id.n2);
        final Button n5 = findViewById(R.id.n5);
        final Button n8 = findViewById(R.id.n8);

        n0.setBackgroundResource(R.color.colorWhite);
        n2.setBackgroundResource(R.color.colorWhite);
        n5.setBackgroundResource(R.color.colorWhite);
        n8.setBackgroundResource(R.color.colorWhite);

    }

    private void ButtonFunc() {

        screenContent = calculatorScreen.getText().toString();

        if (isOpPressed) {
            secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
        } else {
            firstNumberString = calculatorScreen.getText().toString();
        }
        BackgroundBlack();
        BackgroundWhite();

    }
}