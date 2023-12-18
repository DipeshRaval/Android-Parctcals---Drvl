package com.example.selectmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tx = (TextView) findViewById(R.id.itemSelect);
        sp = (Spinner) findViewById(R.id.selectorCoundry);

        String Country[] = {"Please select a your Country.","India","US","USA","Canada","Africa"};

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Country);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(adp);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(i == 0)
            {
                tx.setText("");
            }
            else {
                tx.setText("Your Country : " + Country[i]);
                tx.setTextColor(Color.RED);
            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}