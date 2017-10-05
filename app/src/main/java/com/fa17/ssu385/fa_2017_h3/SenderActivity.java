package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick {
    private SendMessageFragment mySendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        mySendMessageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_activity_sender, mySendMessageFragment).commit();

    }

    @Override
    public void onClick(String sendLinearName, String sendLinearMessage){
        Intent intent = new Intent (this, ReceiverActivity.class);
        if(sendLinearName != null){
            intent.putExtra(ReceiverActivity.SENDER_NAME_KEY, sendLinearName);
        }
        if(sendLinearMessage != null){
            intent.putExtra(ReceiverActivity.SENDER_MESSAGE_KEY, sendLinearMessage);
        }
        startActivity(intent);
    }
}
