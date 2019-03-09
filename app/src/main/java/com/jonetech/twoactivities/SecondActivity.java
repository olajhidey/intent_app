package com.jonetech.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private String fMessage;
    private TextView fMessageTextView;

    public static final String REPLY_MESSAGE = "com.jonetech.twoactivities.extra.REPLY";
    private EditText fMesssageReply;
    private String fReplyMyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        fMessage = intent.getStringExtra(MainActivity.MESSAGE_TEXT);

        fMessageTextView = (TextView) findViewById(R.id.text_message);

        fMesssageReply = (EditText) findViewById(R.id.text_reply);


        fMessageTextView.setText(fMessage);
    }

    public void replyMessage(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        fReplyMyMessage = fMesssageReply.getText().toString();

        intent.putExtra(REPLY_MESSAGE, fReplyMyMessage );

        setResult(RESULT_OK, intent);

        finish();


    }
}
