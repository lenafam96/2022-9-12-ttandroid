package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bai2 extends AppCompatActivity {
    private EditText input_year;
    private Button buttonProcess;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        Init();
        Action();
    }

    private void Action() {
        String can[] = new String[]{"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String chi[] = new String[]{"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mão","Thìn","Tỵ","Ngọ","Mùi"};
        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = Integer.parseInt(input_year.getText().toString());
                resultText.setText(year + " là năm " + can[year%10] + " " + chi[year%12]);
            }
        });
    }

    private void Init() {
        input_year = (EditText) this.findViewById(R.id.input_year);
        buttonProcess = (Button) this.findViewById(R.id.buttonProcess);
        resultText = (TextView) this.findViewById(R.id.resultText);
        resultText.setText("");
    }
}