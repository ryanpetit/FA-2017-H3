package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity implements
        SendMessageFragment.onSendButtonClick {

    private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        sendMessageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.sender_frame_layout, sendMessageFragment)
                .commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {
        Intent myIntent = new Intent(this, ReceiverActivity.class);

        if(senderName != null){
            myIntent.putExtra(ReceiverActivity.nameKeyR, senderName);
        }
        if(senderMessage != null){
            myIntent.putExtra(ReceiverActivity.messageKeyR, senderMessage);
        }
        startActivity(myIntent);
    }
}
