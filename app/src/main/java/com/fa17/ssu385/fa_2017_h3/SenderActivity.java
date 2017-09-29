package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick {

    private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        sendMessageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.sender_frame_layout, sendMessageFragment).commit();
    }

    @Override
    public void onClick(String sender_name, String sender_message) {
        Intent intent = new Intent(SenderActivity.this, ReceiverActivity.class);

        if (sender_name != null) {
            intent.putExtra(ReceiverActivity.SENDER_NAME_KEY, sender_name);
        }

        if (sender_message != null) {
            intent.putExtra(ReceiverActivity.SENDER_MESSAGE_KEY, sender_message);
        }

        startActivity(intent);
    }
}
