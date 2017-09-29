package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonClick{
    public static final String MESSAGE = "messageFromSender";
    public static final String NAME = "nameFromSender";
    private ReceiveMessageFragment receiveMessageFragment;
    private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiveMessageFragment = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if(getIntent().hasExtra(NAME)){
            args.putString(ReceiveMessageFragment.NAME, getIntent().getStringExtra(NAME));
        }
        if(getIntent().hasExtra(MESSAGE)){
            args.putString(ReceiveMessageFragment.MESSAGE, getIntent().getStringExtra(MESSAGE));
        }
        receiveMessageFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                                    .add(R.id.receiver_id, receiveMessageFragment)
                                    .commit();
    }

    @Override
    public void onClick(){
        sendMessageFragment = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.receiver_id, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        /*
        Intent intent = new Intent(this, SenderActivity.class);
        startActivity(intent);*/
    }

    @Override
    public void onClick(String senderMessage, String senderName) {
        Intent intent = new Intent(this, NewActivity.class);
        if(senderName != null){
            intent.putExtra(ReceiverActivity.MESSAGE, senderMessage);
        }
        if(senderName != null){
            intent.putExtra(ReceiverActivity.NAME, senderName);
        }
        if(senderMessage.length() != 0 && senderName.length() != 0){
            startActivity(intent);
        }
        startActivity(intent);
    }
}
