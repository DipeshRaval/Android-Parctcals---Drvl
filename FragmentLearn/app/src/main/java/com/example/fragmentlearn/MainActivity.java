package com.example.fragmentlearn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindFrag(FragA.newInstance("Dipesh","42"),0);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("   Fragment");
        actionBar.setSubtitle("    Static and Dynamic Fragments");
        actionBar.setIcon(R.drawable.baseline_cast_24);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    public void bindFrag(Fragment fragment,int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag == 0)
        {
            ft.add(R.id.container,fragment,"frag");
            fm.popBackStack("ROOT ELEMENT",FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack("ROOT ELEMENT");
        }else{
            ft.replace(R.id.container,fragment,"frag");
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    public void AddFragA(View view) {
        bindFrag(FragA.newInstance("Dipesh","42"),0);
    }

    public void AddFragB(View view) {
        bindFrag(new FrabB(),1);
    }

    public void AddFragC(View view) {
        bindFrag(new FragC(),1);
    }
}