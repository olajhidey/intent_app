package com.jonetech.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final int TEXT_REQUEST = 1;

    private TextView fReplyHeadTextView;
    private TextView fReplyTextMessage;

    private EditText fEditText;

    public static final String MESSAGE_TEXT = "com.jonetech.twoactivities.extra.MESSAGE";
    private String fMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fEditText = (EditText) findViewById(R.id.message_text);

        fReplyHeadTextView = (TextView) findViewById(R.id.text_reply_header);

        fReplyTextMessage = (TextView) findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        fMessage = fEditText.getText().toString();
        intent.putExtra(MESSAGE_TEXT, fMessage);
        startActivityForResult(intent, TEXT_REQUEST);
        Log.d(LOG_TAG, "Button Clicked");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.REPLY_MESSAGE);
                fReplyHeadTextView.setVisibility(View.VISIBLE);

                fReplyTextMessage.setText(reply);
                fReplyTextMessage.setVisibility(View.VISIBLE);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
