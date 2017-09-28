package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick {

    private SendMessageFragment messageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        messageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction()
                                   .add(R.id.sender_frame_layout, messageFragment)
                                   .commit();
    }
    @Override
    public void onClick(String senderName, String senderMessage) {
        Intent intent = new Intent(SenderActivity.this, ReceiverActivity.class);

        if (senderName != null) {
            intent.putExtra(ReceiverActivity.string1, senderName);
        }
        if (senderMessage != null) {
            intent.putExtra(ReceiverActivity.string2, senderMessage);
        }
        startActivity(intent);
    }
}
