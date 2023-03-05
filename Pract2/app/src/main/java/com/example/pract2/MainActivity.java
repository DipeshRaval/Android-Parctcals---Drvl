package com.example.pract2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = (TextView) findViewById(R.id.count_txt);
        if(savedInstanceState != null)
        {
            count = savedInstanceState.getInt("count");
            Log.d("count", String.valueOf(count));
            showCount.setText(count);
        }
        else{
            Log.d("Val", "nulllll");
        }
    }

    public void toastHandle(View view) {
        Toast toast = Toast.makeText(this
        ,R.string.toast_msg,Toast.LENGTH_SHORT);

        toast.show();
    }

    public void countHandle(View view) {
        count++;
        if(showCount != null)
        {
            showCount.setText(Integer.toString(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",count);
    }
}