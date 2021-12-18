package com.example.calcullatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nguyenvanquan7826.com.Balan;

public class MainActivity extends AppCompatActivity {
    private TextView Math;
    private TextView Result;

    private int[] idButton = {

            R.id.btn0,R.id.btn00,R.id.btn1,R.id.btn2,
            R.id.btn3, R.id.btn4, R.id.btn5,R.id.btn6,
            R.id.btn7,  R.id.btn8, R.id.btn9,
            R.id.btnPercent, R.id.btnLog,  R.id.btnPow,
            R.id.btnSub,  R.id.btnMul, R.id.btnDiv, R.id.btnPlus,
            R.id.btnOpen, R.id.btnClose, R.id.btnDot,
            R.id.btnC, R.id.btnResult, R.id.btnDel
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        connectView();
    }

    private void connectView() {
        Math = (TextView) findViewById(R.id.Math);
        Result = (TextView) findViewById(R.id.Result);

        for (int i = 0 ; i < idButton.length; i++){
            findViewById(idButton[i]).setOnClickListener(this::onClick);
        }
        init();
    }
    private void init(){
        Math.setText("|");
        Result.setText("0");
    }
    private void delete(){
        String math = Math.getText().toString().trim();
        math = math.replace(math.substring(math.length()-1),"");
        Math.setText(math);
        Result.setText("0");
    }
    public void onClick(View view){
        int id = view.getId();

        for (int i = 0; i < idButton.length - 3; i++){
            if (id == idButton[i]){
                String text = ((Button)findViewById(id)).getText().toString();

                if (Math.getText().toString().trim().equals("|")){
                    Math.setText("");
                }

                Math.append(text);
                return;
            }
        }
        if (id == R.id.btnC){
            init();
            return;
        }
        if (id == R.id.btnResult){
            cal();
        }
        if (id == R.id.btnDel){
            delete();
            return;
        }
    }

    private void cal(){
        String math = Math.getText().toString().trim();
        if (Math.length() > 0){
            Balan balan = new Balan();
            String result = balan.valueMath(math) + "";
            String error = balan.getError();

            if (error!= null){
                Result.setText(error);
            } else{
                Result.setText(result);
            }
        }
    }
}