package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonClick{
    public static final String SENDER_NAME_KEY= "garbage";
    public static final String SENDER_MESSAGE_KEY = "garbage2";
    private ReceiveMessageFragment receivedMessage;
    private SendMessageFragment sendMessageFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receivedMessage = new ReceiveMessageFragment();
        Bundle args = new Bundle();
        if (getIntent().hasExtra(SENDER_NAME_KEY)) {
            args.putString(ReceiveMessageFragment.NAME_KEY, getIntent().getStringExtra(SENDER_NAME_KEY));
        }
        if (getIntent().hasExtra(SENDER_MESSAGE_KEY)) {
            args.putString(ReceiveMessageFragment.MESSAGE_TEXT, getIntent().getStringExtra(SENDER_MESSAGE_KEY));
        }

        receivedMessage.setArguments(args);

        getSupportFragmentManager().beginTransaction().add(R.id.SecondID, receivedMessage).commit();
    }

    @Override
    public void onReplyClick(){
        sendMessageFragment = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.SecondID, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onSenderClick(String senderName, String senderMessage){
        Intent newintent = new Intent(this, NewActivity.class);
        startActivity(newintent);
    }


}

