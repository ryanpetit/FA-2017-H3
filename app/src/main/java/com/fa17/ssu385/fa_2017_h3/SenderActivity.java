package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick {
    private SendMessageFragment sendMsgFrag;

    @Override
    public void onClick(String name, String message) {
        Intent intent = new Intent(this, ReceiverActivity.class);
        if (name != null) {
            intent.putExtra(ReceiverActivity.NAME_KEY, name);
        }
        if (message != null) {
            intent.putExtra(ReceiverActivity.MSG_KEY, message);
        }
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        sendMsgFrag = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.sender_frame_layout, sendMsgFrag).commit();
    }
}
