package com.example.pract7_drvl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        TextView tx =(TextView) findViewById(R.id.itemTxt);
        String s = i.getStringExtra(MainActivity.MSG);
        tx.setText("Order : " + s);
    }
}