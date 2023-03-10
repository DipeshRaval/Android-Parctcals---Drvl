package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    public static final String EXTRA_MESSAGE =
            "extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    public static String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        msg = (EditText) findViewById(R.id.editText_main);
    }

    public void launchSecountActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String txt = msg.getText().toString();

        intent.putExtra(EXTRA_MESSAGE,txt);
        startActivityForResult(intent, TEXT_REQUEST);
        Log.d(LOG_TAG,"Button Clicked !!");

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}