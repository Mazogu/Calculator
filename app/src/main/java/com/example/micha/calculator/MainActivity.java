package com.example.micha.calculator;

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
                String number = math.getText().toString();
                double value = Double.parseDouble(number);
                math.setText(Double.toString(value * value));
            }
        });
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
}
