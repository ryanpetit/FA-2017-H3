package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonClick {
    public static final String usernameExtra = "USER";
    public static final String userMessageExtra = "MESSAGE";
    private ReceiveMessageFragment receiveMessageFragment;
    private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiveMessageFragment = new ReceiveMessageFragment();

        Bundle args = new Bundle();

        if (getIntent().hasExtra(usernameExtra)) {
            args.putString(ReceiveMessageFragment.username,
                    getIntent().getStringExtra(usernameExtra));
        }

        if (getIntent().hasExtra(userMessageExtra)) {
            args.putString(ReceiveMessageFragment.userMessage,
                    getIntent().getStringExtra(userMessageExtra));
        }

        receiveMessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.receiver_frame_layout, receiveMessageFragment)
                .commit();
    }

    @Override
    public void onClick() {
        sendMessageFragment = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.receiver_frame_layout, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}
