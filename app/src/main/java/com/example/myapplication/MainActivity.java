package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText input_a;
    private EditText input_b;
    private EditText result;
    private Button buttonSubmit, buttonClear,bai2,bai3,bai4;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        Action();
    }

    private void Action() {
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_a.setText("");
                input_b.setText("");
                result.setText("");
                ((RadioButton)radioGroup.getChildAt(0)).setChecked(true);
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(input_a.getText().toString());
                float b = Float.parseFloat(input_b.getText().toString());
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.tong:
                        result.setText(String.valueOf(a+b)); break;
                    case R.id.hieu:
                        result.setText(String.valueOf(a-b)); break;
                    case R.id.tich:
                        result.setText(String.valueOf(a*b)); break;
                    case R.id.thuong:
                        result.setText(String.valueOf(a/b)); break;
                    case R.id.luythua:
                        result.setText(String.valueOf(Math.pow(a,b))); break;
                    case R.id.min:
                        result.setText(String.valueOf(Math.min(a,b))); break;
                }

            }
        });
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bai2.class);
                startActivity(intent);
            }
        });
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bai3.class);
                startActivity(intent);
            }
        });
        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bai4.class);
                startActivity(intent);
            }
        });
    }

    private void Init() {
        input_a = (EditText) this.findViewById(R.id.input_a);
        input_b = (EditText) this.findViewById(R.id.input_b);
        result = (EditText) this.findViewById(R.id.result);
        buttonSubmit = (Button) this.findViewById(R.id.buttonSubmit);
        buttonClear = (Button) this.findViewById(R.id.buttonClear);
        bai2 = (Button) this.findViewById(R.id.bai2);
        bai3 = (Button) this.findViewById(R.id.bai3);
        bai4 = (Button) this.findViewById(R.id.bai4);
        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);
    }
}