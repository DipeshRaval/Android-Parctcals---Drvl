package com.example.activityandintents;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textHead,txt;
    private EditText sendMsg;
    public static int Test_Request = 1;
    public static String sendKey = "send Message";
    public static String Log_Tag = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMsg = (EditText) findViewById(R.id.inputMsg);
        textHead = (TextView) findViewById(R.id.text_head_main);
        txt = (TextView) findViewById(R.id.text_main);
    }

    public void launchSecoundActivity(View view) {
        Intent intent = new Intent(this,SecoundActivity.class);
        String msg = sendMsg.getText().toString();

        intent.putExtra(sendKey,msg);
        startActivityForResult(intent,Test_Request);
        Log.d(Log_Tag,"Button_Clicked!!");
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Test_Request)
        {
            if(resultCode == RESULT_OK)
            {
                String s = data.getStringExtra(SecoundActivity.KeyReply);
                textHead.setVisibility(View.VISIBLE);
                txt.setText(s);
                txt.setVisibility(View.VISIBLE);
            }
        }
    }

}