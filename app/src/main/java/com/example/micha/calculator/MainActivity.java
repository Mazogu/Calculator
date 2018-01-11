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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        argumentOne = argumentTwo = 0;
        math = findViewById(R.id.math);
        answer = findViewById(R.id.answer);
        operation = "";

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
