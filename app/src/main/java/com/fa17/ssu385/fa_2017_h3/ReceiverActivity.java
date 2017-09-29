package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity {

    public static final string Passed_Key1;
    public static final string Passed_Key2;

    private ReceiveMessageFragment receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiver =;
        Bundle args = new Bundle();
    }

    if(getIntent().hasExtra(SENDER_NAME_KEY)) {
        args.putString(ReceiveMessageFragment.NAME_KEY,
        getIntent().getStringExtra(SENDER_NAME_KEY));
    }

    if(getIntent().hasExtra(SENDER_MESSAGE_KEY)) {
        args.putString(ReceiveMesssageFragment.MESSAGE_KEY,
                getIntent().getStringExtra(SENDER_MESSAGE_KEY));
    }

    myReceiveMessageFragment.setArguments(args);

    getSupportFragmentManager().beginTransaction()
                                .add(R.id.receiver_fragment_container, receiveMessageFragment)
                                .commit();
}
