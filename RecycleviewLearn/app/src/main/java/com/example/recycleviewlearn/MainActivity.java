package com.example.recycleviewlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<String> mLinkList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyle);

        for (int i=0;i<100;i++)
        {
            mLinkList.addLast("Word : " + i);
        }

        RecyleAdapter recyleAdapter = new RecyleAdapter(this,mLinkList);
        recyclerView.setAdapter(recyleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}