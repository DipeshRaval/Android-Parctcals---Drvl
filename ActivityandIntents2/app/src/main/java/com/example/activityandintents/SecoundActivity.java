package com.example.activityandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecoundActivity extends AppCompatActivity {
    EditText replyInput;
    public static String KeyReply = "reply Message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);
        replyInput = (EditText) findViewById(R.id.replyInput);
        TextView reply = (TextView) findViewById(R.id.text_reply);
        Intent intent = getIntent();
        String sendMsg = intent.getStringExtra(MainActivity.sendKey);
        reply.setText(sendMsg);
    }

    public void replyToActivity(View view) {
        Intent intent = new Intent();
        String replyMsg = replyInput.getText().toString();
        intent.putExtra(KeyReply,replyMsg);
        setResult(RESULT_OK,intent);
        finish();
    }
}