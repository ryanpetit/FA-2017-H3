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
        getSupportFragmentManager().beginTransaction()
                                    .add(R.id.fragment_container, mySendMessageFragment)
                                    .commit();

    }

    @Override
    public void onClick(String senderMessage, String senderName) {
        Intent intent = new Intent(this, ReceiverActivity.class);
        if(senderName != null){
            intent.putExtra(ReceiverActivity.MESSAGE, senderMessage);
        }
        if(senderName != null){
            intent.putExtra(ReceiverActivity.NAME, senderName);
        }
        if(senderMessage.length() != 0 && senderName.length() != 0){
            startActivity(intent);
        }
        startActivity(intent);
    }
}
