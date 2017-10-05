package com.fa17.ssu385.fa_2017_h3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.onReplyButtonClick, SendMessageFragment.OnSendButtonClick {
    public static final String NAME_KEY = "name";
    public static final String MESSAGE_KEY = "message";
    private ReceiveMessageFragment receiver;
    private SendMessageFragment sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiver = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if(getIntent().hasExtra(NAME_KEY)){
            args.putString(ReceiveMessageFragment.NAME_KEY, getIntent().getStringExtra(NAME_KEY));
        }

        if(getIntent().hasExtra(MESSAGE_KEY)){
            args.putString(ReceiveMessageFragment.MESSAGE_KEY, getIntent().getStringExtra(MESSAGE_KEY));
        }

        receiver.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                                    .add(R.id.frame_receiver_layout, receiver)
                                    .commit();
    }

    @Override
    public void onClick() {
        sender = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_receiver_layout, sender);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(String sendIt)
}
