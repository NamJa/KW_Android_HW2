package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MyCalculator extends AppCompatActivity {

    String[] intstrArr;


    TextView calcResTextView;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
        btn0, btndot, btnplus, btnminus, btnmultiple, btndivide, btnresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycalculator);

        //많기도 해라...
        calcResTextView = (TextView) findViewById(R.id.calculateResultTextView);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btndot = findViewById(R.id.btndot);
        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnmultiple = findViewById(R.id.btnmultiple);
        btndivide = findViewById(R.id.btndivide);
        btnresult = findViewById(R.id.btnresult);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + "0");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr+"+");
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr+"-");
            }
        });
        btnmultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr+"×");
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr+"÷");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();
                calcResTextView.setText(textviewStr + ".");
            }
        });
        // 핵심 코드
        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textviewStr = calcResTextView.getText().toString();

                if(textviewStr.contains("+")) {
                    intstrArr = textviewStr.split("\\+");
                    if(intstrArr[0].contains(".") || intstrArr[1].contains("."))
                    {
                        DecimalFormat displayFormat = new DecimalFormat("#.#####");
                        double result = Double.parseDouble(intstrArr[0]) + Double.parseDouble(intstrArr[1]);
                        calcResTextView.setText(textviewStr + "=" + displayFormat.format(result));
                    } else {
                        int result = Integer.parseInt(intstrArr[0]) + Integer.parseInt(intstrArr[1]);
                        calcResTextView.setText(textviewStr + "=" + Integer.toString(result));
                    }
                } else if(textviewStr.contains("-")){
                    intstrArr = textviewStr.split("-");
                    if(intstrArr[0].contains(".") || intstrArr[1].contains("."))
                    {
                        DecimalFormat displayFormat = new DecimalFormat("#.#####");
                        double result = Double.parseDouble(intstrArr[0]) - Double.parseDouble(intstrArr[1]);
                        calcResTextView.setText(textviewStr + "=" + displayFormat.format(result));
                    } else {
                        int result = Integer.parseInt(intstrArr[0]) - Integer.parseInt(intstrArr[1]);
                        calcResTextView.setText(textviewStr + "=" + Integer.toString(result));
                    }
                } else if(textviewStr.contains("×")){
                    intstrArr = textviewStr.split("×");
                    if(intstrArr[0].contains(".") || intstrArr[1].contains("."))
                    {
                        DecimalFormat displayFormat = new DecimalFormat("#.#####");
                        double result = Double.parseDouble(intstrArr[0]) * Double.parseDouble(intstrArr[1]);
                        calcResTextView.setText(textviewStr + "=" + displayFormat.format(result));
                    } else {
                        int result = Integer.parseInt(intstrArr[0]) * Integer.parseInt(intstrArr[1]);
                        calcResTextView.setText(textviewStr + "=" + Integer.toString(result));
                    }
                } else if(textviewStr.contains("÷")){
                    // double형 출력 형식
                    DecimalFormat displayFormat = new DecimalFormat("#.#####");
                    intstrArr = textviewStr.split("÷");
                    double result = Double.parseDouble(intstrArr[0]) / Double.parseDouble(intstrArr[1]);
                    calcResTextView.setText(textviewStr + "=" + displayFormat.format(result));
                }
            }
        });



        //MyWebBrowser acitivy 실행
        Button webViewExecute = findViewById(R.id.webViewBtn);
        webViewExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyWebBrowser.class);
                startActivity(intent);
            }
        });


    }
}