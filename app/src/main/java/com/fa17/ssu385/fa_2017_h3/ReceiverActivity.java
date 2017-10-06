package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonCLick{

    public static final String SENDER_NAME_KEY = "sender_name_key";
    public static final String SENDER_MESSAGE_KEY = "sender_message_key";

    private SendMessageFragment sendMessageFragment;
    private ReceiveMessageFragment myReceiveMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        myReceiveMessageFragment = new ReceiveMessageFragment();

        Bundle args = new Bundle();

        if(getIntent().hasExtra(SENDER_NAME_KEY)){
            args.putString(ReceiveMessageFragment.NAME_KEY,
                    getIntent().getStringExtra(SENDER_NAME_KEY));
        }
        if(getIntent().hasExtra(SENDER_MESSAGE_KEY)){
            args.putString(ReceiveMessageFragment.MESSAGE_KEY,
                    getIntent().getStringExtra(SENDER_MESSAGE_KEY));
        }

        myReceiveMessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_receiver_text, myReceiveMessageFragment)
                .commit();
    }



    @Override
    public void onClick() {
        sendMessageFragment = new SendMessageFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_receiver_text, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void onClick(String senderName, String senderMessage){
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);

    }




}
