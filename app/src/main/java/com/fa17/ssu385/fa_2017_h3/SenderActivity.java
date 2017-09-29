package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonCLick{

    private SendMessageFragment mySendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        mySendMessageFragment = new SendMessageFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_sender_text,mySendMessageFragment)
                .commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {

        Intent intent = new Intent(this, ReceiverActivity.class);

        if(senderName != null){
            intent.putExtra(ReceiverActivity.SENDER_NAME_KEY, senderName);
        }

        if(senderMessage != null){
            intent.putExtra(ReceiverActivity.SENDER_MESSAGE_KEY, senderMessage);
        }

        startActivity(intent);

    }
}
