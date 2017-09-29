package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity {
    private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        sendMessageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.sender_text, sendMessageFragment).commit();
    }


    if(senderName != null){
        intent.putExtra(ReceiverActivity.senderNameString, senderName);
    }
    if(senderMessage !=	null){
        intent.putExtra(ReceiverActivity.senderMessageString, senderMessage);
    }
    startActivity(intent);

}
