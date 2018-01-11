package com.example.micha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int argumentOne, argumentTwo;
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
                if(!edit.contains(".")){
                    math.setText(edit + ".");
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                math.setText(getString(R.string.zero_string));
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
                math.setText(Double.toString(value*value));
            }
        });
    }

    public void addNumber(View view) {
        if(operation.equals("")){
            Button pressed = (Button) view;
            if(math.getText().toString().equals("0")){
                math.setText(pressed.getText().toString());
            }
            else {
                math.setText(math.getText().toString() + pressed.getText().toString());
            }
        }
    }




}
