package com.example.handleimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uri = (TextView) findViewById(R.id.uri);

        Intent intent = getIntent();
        String s = String.valueOf(intent.getData());
        if(s != null)
        {
            uri.setText(getString(R.string.lable) + s);
        }
    }
}