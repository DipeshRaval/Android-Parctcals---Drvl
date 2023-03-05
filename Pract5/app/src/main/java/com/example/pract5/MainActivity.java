package com.example.pract5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText urlInput,locInput,textInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlInput = (EditText) findViewById(R.id.urlInput);
        locInput = (EditText) findViewById(R.id.locInput);
        textInput = (EditText) findViewById(R.id.textInput);
    }

    public void shereText(View view) {
        String msg = textInput.getText().toString();
        String MiMEType = "text/plain";
        if(!msg.equals(""))
        {
            ShareCompat.IntentBuilder.
                    from(this).setText(msg).setType(MiMEType).setChooserTitle("Send This message with .....").startChooser();
        } else {
            Toast toast = Toast.makeText(this,"Msg Can't Be empty !", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void openLocation(View view) {
        String loc = locInput.getText().toString();
        Uri geoLoc = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,geoLoc);

        startActivity(intent);
//            if(intent.resolveActivity(getPackageManager()) != null)
//            {
//                startActivity(intent);
//            }else{
//                Log.d("ImplicitIntents", "Can't handle this intent!");
//            }
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void openWebsite(View view) {
            String url = urlInput.getText().toString();
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            startActivity(intent);

//            if(intent.resolveActivity(getPackageManager()) != null)
//            {
//                startActivity(intent);
//            }else{
//
//                Log.d("ImplicitIntents", "Can't handle this intent!");
//                Log.d("Val", String.valueOf(intent.resolveActivity(getPackageManager())));
//            }
    }

}

