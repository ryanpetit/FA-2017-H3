package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick{

    private SendMessageFragment mySendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        mySendMessageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.sender_frame_layout, mySendMessageFragment).commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {
        Intent messageIntent = new Intent(this, ReceiverActivity.class);
        if(senderName != null) {
            messageIntent.putExtra(ReceiverActivity.stringName, senderName);
        }
        if(senderMessage != null) {
            messageIntent.putExtra(ReceiverActivity.stringMessage, senderMessage);
        }
        startActivity(messageIntent);
    }
}
