package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick{
    public static final String NAME_KEY = "name_key";
    public static final String MESSAGE_KEY = "message_key";
    private ReceiveMessageFragment receiveFragment;
    private SendMessageFragment sendFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiveFragment = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if(getIntent().hasExtra(NAME_KEY)){
            args.putString(ReceiveMessageFragment.NAME_KEY, getIntent().getStringExtra(NAME_KEY));
        }

        if(getIntent().hasExtra(MESSAGE_KEY)){
            args.putString(ReceiveMessageFragment.MESSAGE_KEY, getIntent().getStringExtra(MESSAGE_KEY));
        }

        receiveFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.receiver_frame_layout, receiveFragment)
                .commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {

    }
}
