package com.fa17.ssu385.fa_2017_h3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonClick{

    // Key values used to access the data passed through our intent
    public static final String SENDER_NAME_KEY = "sender_name";
    public static final String SENDER_MESSAGE_KEY = "sender_message";

    private ReceiveMessageFragment receiveMessageFragment;
    private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call super
        super.onCreate(savedInstanceState);

        // Set view
        setContentView(R.layout.activity_receiver);

        // Create new ReceiveMessageFragment
        receiveMessageFragment = new ReceiveMessageFragment();

        // Put the variables from the intent into a Bundle
        Bundle args = new Bundle();  // create a new bundle
        if(getIntent().hasExtra(SENDER_NAME_KEY)) {  // name
            args.putString(ReceiveMessageFragment.NAME_KEY,
                           getIntent().getStringExtra(SENDER_NAME_KEY));
        }
        if(getIntent().hasExtra(SENDER_MESSAGE_KEY)) {  // message
            args.putString(ReceiveMessageFragment.MESSAGE_KEY,
                           getIntent().getStringExtra(SENDER_MESSAGE_KEY));
        }

        // pass the bundle to our fragment
        receiveMessageFragment.setArguments(args);

        // set the receiveMessageFragment into the receiver_frame
        getSupportFragmentManager().beginTransaction()
                                   .add(R.id.receiver_frame, receiveMessageFragment)
                                   .commit();
    }

    @Override
    public void onClick() {
        sendMessageFragment = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.receiver_frame, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(String senderName, String senderMessage) {
    }
}
