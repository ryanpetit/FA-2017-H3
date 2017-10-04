package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonClick {

    public static final String SENDER_NAME_KEY = "sender_name";
    public static final String SENDER_MESSAGE_KEY = "message";

    private ReceiveMessageFragment receiveMessageFragment;
    private SendMessageFragment sendMessageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        receiveMessageFragment = new ReceiveMessageFragment();

        Bundle args = new Bundle();

        if(getIntent().hasExtra(SENDER_NAME_KEY)) {
            args.putString(ReceiveMessageFragment.NAME_KEY,
                    getIntent().getStringExtra(SENDER_NAME_KEY));
        }

        if(getIntent().hasExtra(SENDER_MESSAGE_KEY)) {
            args.putString(ReceiveMessageFragment.MESSAGE_KEY,
                    getIntent().getStringExtra(SENDER_MESSAGE_KEY));
        }

        receiveMessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_receiver, receiveMessageFragment)
                .commit();

    }

    @Override
    public void onClick() {

        sendMessageFragment = new SendMessageFragment();

        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.fragment_container_receiver, sendMessageFragment)
                                   .addToBackStack(null)
                                   .commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {

        Intent receiverIntent = new Intent(this, ReceiverActivity.class);

        if(senderName != null) {
            receiverIntent.putExtra(ReceiverActivity.SENDER_NAME_KEY, senderName);
        }
        if(senderMessage != null) {
            receiverIntent.putExtra(ReceiverActivity.SENDER_MESSAGE_KEY, senderMessage);
        }

        startActivity(receiverIntent);
    }
}
