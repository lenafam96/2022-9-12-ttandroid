package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bai3 extends AppCompatActivity {
    private EditText input_hs_a,input_hs_b;
    private Button buttonSolve;
    private TextView resultTextB3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        Init();
        Action();
    }

    private void Action() {
        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(input_hs_a.getText().toString());
                float b = Float.parseFloat(input_hs_b.getText().toString());
                if(a==0){
                    if(b==0)
                        resultTextB3.setText("Phương trình đúng với mọi nghiệm thực");
                    else
                        resultTextB3.setText("Phương trình vô nghiệm");
                }
                else
                    resultTextB3.setText("Phương trình có nghiệm x = "+(-b/a));
            }
        });
    }

    private void Init() {
        input_hs_a = (EditText) this.findViewById(R.id.input_hs_a);
        input_hs_b = (EditText) this.findViewById(R.id.input_hs_b);
        buttonSolve = (Button) this.findViewById(R.id.buttonSolve);
        resultTextB3 = (TextView) this.findViewById(R.id.resultTextB3);
        resultTextB3.setText("");
    }
}