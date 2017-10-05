package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity {
    public static final String SENDER_NAME_KEY= "sender_name_key";
    public static final String SENDER_MESSAGE_KEY = "sender_message_key";
    private ReceiveMessageFragment receivedMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receivedMessage = new ReceiveMessageFragment();
        Bundle args = new Bundle();
        if (getIntent().hasExtra(SENDER_NAME_KEY)) {
            args.putString(ReceiveMessageFragment.NAME_KEY, getIntent().getStringExtra(SENDER_NAME_KEY));
        }
        if (getIntent().hasExtra(SENDER_MESSAGE_KEY)) {
            args.putString(ReceiveMessageFragment.MESSAGE_TEXT, getIntent().getStringExtra(SENDER_MESSAGE_KEY));
        }

        receivedMessage.setArguments(args);

        getSupportFragmentManager().beginTransaction().add(R.id.SecondID, receivedMessage).commit();
    }
}