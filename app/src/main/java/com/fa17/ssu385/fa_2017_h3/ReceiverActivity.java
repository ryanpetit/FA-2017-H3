package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonClick {
    public static final String MSG_KEY = "MESSAGE";
    public static final String NAME_KEY = "NAME";

    private ReceiveMessageFragment recMsgFrag;
    private SendMessageFragment sendMsgFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        recMsgFrag = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if (getIntent().hasExtra(NAME_KEY)) {
            args.putString(ReceiveMessageFragment.NAME_KEY, getIntent().getStringExtra(NAME_KEY));
        }
        if (getIntent().hasExtra(MSG_KEY)) {
            args.putString(ReceiveMessageFragment.MSG_KEY, getIntent().getStringExtra(MSG_KEY));
        }

        recMsgFrag.setArguments(args);

        getSupportFragmentManager().beginTransaction().add(R.id.receiver_frame_layout, recMsgFrag).commit();
    }

    @Override
    public void onClick() {
        sendMsgFrag = new SendMessageFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.receiver_frame_layout, sendMsgFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {
        Intent intent = new Intent(this, NewActivity.class);
//        if (senderName != null) {
//            intent.putExtra(ReceiverActivity.NAME_KEY, senderName);
//        }
//        if (senderMessage != null) {
//            intent.putExtra(ReceiverActivity.MSG_KEY, senderMessage);
//        }
        startActivity(intent);
    }
}
