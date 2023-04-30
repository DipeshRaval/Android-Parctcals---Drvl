package com.example.pract7_drvl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String orderItem = "No Items";
    static String MSG = "Order Item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToastMsg()
    {
        Toast.makeText(this, orderItem, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        orderItem = getString(R.string.donut_order_message);
        showToastMsg();
    }


    public void showFroyoOrder(View view) {
        orderItem = getString(R.string.froyo_order_message);
        showToastMsg();
    }

    public void showIceCreamOrder(View view) {
        orderItem = getString(R.string.ice_cream_order_message);
        showToastMsg();
    }


    public void handleShop(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra(MSG,orderItem);
        startActivity(intent);
    }


}