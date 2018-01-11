package com.example.micha.calculator;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private double argumentOne, argumentTwo;
    private String operation;
    private TextView answer;
    private TextView math;
    private Button dot;
    private Button equals;
    private Button clear;
    private Button sign;
    private Button square;
    private Button thirdPower;
    private Button sqrt;
    private Button inverse;
    private Button cos;
    private Button sin;
    private Button tan;
    private Button ten;
    private Button factorial;
    private Button ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        argumentOne = argumentTwo = 0;
        math = findViewById(R.id.math);
        answer = findViewById(R.id.answer);
        operation = "";
        dot = findViewById(R.id.dot);
        equals = findViewById(R.id.equals);
        clear = findViewById(R.id.clear);
        sign = findViewById(R.id.negpos);
        square = findViewById(R.id.square);
        thirdPower = findViewById(R.id.third);
        sqrt = findViewById(R.id.sqrt);
        inverse = findViewById(R.id.inverse);
        ten = findViewById(R.id.ten);
        factorial = findViewById(R.id.factorial);
        ln = findViewById(R.id.ln);


        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit = math.getText().toString();
                if (!edit.contains(".")) {
                    math.setText(edit + ".");
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!operation.equals("")) {
                    String number = math.getText().toString().split(" ")[2];

                    argumentTwo = Double.parseDouble(number);
                    switch(operation){
                        case "+":
                            answer.setText(Double.toString(argumentOne + argumentTwo));
                            break;
                        case "x":
                            answer.setText(Double.toString(argumentOne * argumentTwo));
                            break;
                        case "÷":
                            answer.setText(Double.toString(argumentOne / argumentTwo));
                            break;
                        case "-":
                            answer.setText(Double.toString(argumentOne - argumentTwo));
                            break;
                        case "^":
                            answer.setText(Double.toString(Math.pow(argumentOne,argumentTwo)));
                        default:
                            Log.d(TAG, "Not sure what happened: " + operation);
                    }
                    operation = "";
                    argumentOne = argumentTwo = 0;
                    math.setText(getString(R.string.zero_string));
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                math.setText(getString(R.string.zero_string));
                operation = "";
                argumentOne = 0;
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = math.getText().toString();
                Double value = -1 * Double.parseDouble(number);
                math.setText(Double.toString(value));
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPower(2);
            }
        });
        int orientation = getApplicationContext().getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
             thirdPower.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
            setPower(3);
            }
            });
             sqrt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
            setPower(0.5);
            }
            });
            factorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(operation.equals("")){
                        Double number = Double.parseDouble(math.getText().toString());
                        Double factorial = 1.0;
                        for(int i = 1; i <= number; i++){
                            factorial *= i;
                        }
                        math.setText(Double.toString(factorial));
                    }
                }
            });

        }
    }

    private void setPower(double n){
        String number = math.getText().toString();
        double value = Double.parseDouble(number);
        math.setText(Double.toString(Math.pow(value,n)));
    }

    public void addNumber(View view) {
        String number = math.getText().toString();
        Button pressed = (Button) view;
        if (number.equals("0")) {
            math.setText(pressed.getText().toString());
        } else {
            math.setText(number + pressed.getText().toString());
        }

    }



    public void setOperation(View view) {
        if (operation.equals("")) {
            argumentOne = Double.parseDouble(math.getText().toString());
            operation = ((Button) view).getText().toString();
            math.setText(math.getText().toString()+" "+operation+" ");
        }
    }

    public void hypoth(View view) {
        if(operation.equals("")) {
            Double radians = Double.parseDouble(math.getText().toString()) * Math.PI/180;
            String button = ((Button)view).getText().toString();
            switch (button){
                case "cos":
                    math.setText(Double.toString(Math.cos(radians)));
                    break;
                case "sin":
                    math.setText(Double.toString(Math.sin(radians)));
                    break;
                case "tan":
                    math.setText(Double.toString(Math.tan(radians)));
                    break;
            }
        }
    }
}
