package com.example.pract5_drvl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText locInput = (EditText) findViewById(R.id.locInput);
        EditText linkInput = (EditText) findViewById(R.id.linkInput);
        EditText textInput = (EditText) findViewById(R.id.textInput);
        EditText numInput = (EditText) findViewById(R.id.numInput);

        Button shareBtn = (Button) findViewById(R.id.shereBtn);
        Button openLoc = (Button) findViewById(R.id.locBtn);
        Button openUrl = (Button) findViewById(R.id.linkBtn);
        Button callBtn = (Button) findViewById(R.id.callBtn);

        openUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlSTr = linkInput.getText().toString();
                Uri url = Uri.parse(urlSTr);

                Intent intent = new Intent(Intent.ACTION_VIEW,url);

                startActivity(intent);
//                if(intent.resolveActivity(getPackageManager()) != null)
//                {
//                    startActivity(intent);
//                }else{
//
//                    Log.d("ImplicitIntents", "Can't handle this intent!");
//                    Log.d("Val", String.valueOf(intent.resolveActivity(getPackageManager())));
//                }
            }
        });

        openLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc = locInput.getText().toString();
                Uri locUri = Uri.parse("geo:0,0?q=" + loc);

                Intent intent = new Intent(Intent.ACTION_VIEW,locUri);

                startActivity(intent);
//                if(intent.resolveActivity(getPackageManager()) != null)
//                {
//                    startActivity(intent);
//                }else{
//
//                    Log.d("ImplicitIntents", "Can't handle this intent!");
//                    Log.d("Val", String.valueOf(intent.resolveActivity(getPackageManager())));
//                }
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = textInput.getText().toString();
                String MiMEType = "text/plain";

                if(!msg.equals("")){
                    ShareCompat.IntentBuilder.from(MainActivity.this).setText(msg).setChooserTitle("Send Message With ...").setType(MiMEType).startChooser();
                } else {
                    Toast toast = Toast.makeText(MainActivity.this,"Msg Can't Be empty !", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numInput.getText().toString();
                Uri uri = Uri.parse("tel:" + num);
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);

                startActivity(intent);
            }
        });
    }
}