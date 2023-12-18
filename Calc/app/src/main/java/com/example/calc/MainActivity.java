package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         txt1 = (EditText) findViewById(R.id.text1);
         txt2 = (EditText) findViewById(R.id.text2);
         result = (TextView) findViewById(R.id.result);
    }

    public void addition(View view) {
        int n1 = Integer.parseInt(String.valueOf(txt1.getText()));
        int n2 = Integer.parseInt(String.valueOf(txt2.getText()));

        int s = n1 + n2;

        result.setText("Sum : " + s);
    }
}