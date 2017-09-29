package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ReceiverActivity extends AppCompatActivity {
    public static String SENDER_NAME_KEY = "senderNameKey";
    public static String SENDER_MESSAGE_KEY = "senderMessageKey";
    private ReceiveMessageFragment receiverMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiverMessageFragment = new ReceiveMessageFragment();

        Bundle args = new Bundle();

        if (getIntent().hasExtra(SENDER_NAME_KEY)) {
            args.putString(ReceiveMessageFragment.NAME_KEY, getIntent().getStringExtra(SENDER_NAME_KEY));
        }
        if (getIntent().hasExtra(SENDER_MESSAGE_KEY)) {
            args.putString(ReceiveMessageFragment.MESSAGE_KEY, getIntent().getStringExtra(SENDER_MESSAGE_KEY));
        }

        receiverMessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().add(R.id.receive_fragment, receiverMessageFragment).commit();
    }
}
