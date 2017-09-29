package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick {

    private SendMessageFragment messageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        messageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction()
                                    .add(R.id.sender_frame,
                                            messageFragment)
                                    .commit();


    }





    @Override
    public void onClick(String senderName, String senderMessage) {
        Intent intent = new Intent(SenderActivity, ReceiverActivity);

    }
}
