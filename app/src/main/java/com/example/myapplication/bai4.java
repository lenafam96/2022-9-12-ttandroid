package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class bai4 extends AppCompatActivity {
    private Button buttonAction;
    private RadioGroup radioGroup;
    private TextView text_input_b4_a,text_input_b4_b,text_input_b4_c,resultTextB4;
    private EditText input_b4_a,input_b4_b,input_b4_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        Init();
        Action();
    }
    private void Action() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.checkPerfectNumber:
                    case R.id.checkPrimeNumber:
                    {
                        text_input_b4_b.setVisibility(View.INVISIBLE);
                        text_input_b4_c.setVisibility(View.INVISIBLE);
                        input_b4_b.setVisibility(View.INVISIBLE);
                        input_b4_c.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case R.id.solveEquation2:
                    {
                        text_input_b4_b.setVisibility(View.VISIBLE);
                        text_input_b4_c.setVisibility(View.INVISIBLE);
                        input_b4_b.setVisibility(View.VISIBLE);
                        input_b4_c.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case R.id.solveEquation3:
                    {
                        text_input_b4_b.setVisibility(View.VISIBLE);
                        text_input_b4_c.setVisibility(View.VISIBLE);
                        input_b4_b.setVisibility(View.VISIBLE);
                        input_b4_c.setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }
        });
        buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.checkPerfectNumber:
                    {
                        int a = Integer.parseInt(input_b4_a.getText().toString());
                        resultTextB4.setText(a+(IsPerfectNumber(a)?" là số hoàn hảo":" không phải số hoàn hảo"));
                        break;
                    }
                    case R.id.checkPrimeNumber:
                    {
                        int a = Integer.parseInt(input_b4_a.getText().toString());
                        resultTextB4.setText(a+(IsPrimeNumber(a)?" là số nguyên tố":" không phải số nguyên tố"));
                        break;
                    }
                    case R.id.solveEquation2:
                    {
                        float a = Float.parseFloat(input_b4_a.getText().toString());
                        float b = Float.parseFloat(input_b4_b.getText().toString());
                        if(a==0){
                            if(b==0)
                                resultTextB4.setText("Phương trình đúng với mọi nghiệm thực");
                            else
                                resultTextB4.setText("Phương trình vô nghiệm");
                        }
                        else
                            resultTextB4.setText("Phương trình có nghiệm x = "+(-b/a));
                        break;
                    }
                    case R.id.solveEquation3:
                    {
                        float a = Float.parseFloat(input_b4_a.getText().toString());
                        float b = Float.parseFloat(input_b4_b.getText().toString());
                        float c = Float.parseFloat(input_b4_c.getText().toString());
                        if(a!=0){
                            float delta = b*b - 4*a*c;
                            if(delta == 0)
                                resultTextB4.setText("Phương trình có nghiệm kép x1 = x2 = "+(-b/(2*a)));
                            else if(delta<0)
                                resultTextB4.setText("Phương trình vô nghiệm thực");
                            else
                                resultTextB4.setText("Phương trình có 2 nghiệm x1 = "+((-b+Math.sqrt(delta))/(2*a))+" và x2 = "+((-b-Math.sqrt(delta))/(2*a)));
                        }
                        else
                            resultTextB4.setText("Không phải phương trình bậc 2");
                        break;
                    }
                }
            }
        });
    }

    private void Init() {
        buttonAction = (Button) this.findViewById(R.id.buttonAction);
        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);
        text_input_b4_a = (TextView) this.findViewById(R.id.text_input_b4_a);
        text_input_b4_b = (TextView) this.findViewById(R.id.text_input_b4_b);
        text_input_b4_c = (TextView) this.findViewById(R.id.text_input_b4_c);
        resultTextB4 = (TextView) this.findViewById(R.id.resultTextB4);
        resultTextB4.setText("");
        input_b4_a = (EditText) this.findViewById(R.id.input_b4_a);
        input_b4_b = (EditText) this.findViewById(R.id.input_b4_b);
        input_b4_c = (EditText) this.findViewById(R.id.input_b4_c);
    }
    private boolean IsPerfectNumber(int n){
        if(n<1)
            return false;
        int sum = 0;
        for (int i=1;i<=n/2;i++){
            if(n%i==0)
                sum+=i;
        }
        return sum==n;
    }

    private boolean IsPrimeNumber(int n){
        if(n<2)
            return false;
        for (int i=2;i*i<=n;i++)
            if(n%i==0)  return false;
        return true;
    }
}