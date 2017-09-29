package com.fa17.ssu385.fa_2017_h3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick, SendMessageFragment.OnSendButtonClick {
    public static final String SENDER_NAME_KEY = "awefaw";
    public static final String SENDER_MESSAGE_KEY = "wefwea";
    private ReceiveMessageFragment myReceiverMessageFragment;
    private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        myReceiverMessageFragment = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if(getIntent().hasExtra(SENDER_NAME_KEY)){
            args.putString(ReceiveMessageFragment.NAME_KEY,getIntent().getStringExtra((SENDER_NAME_KEY)));
        }

        if(getIntent().hasExtra(SENDER_MESSAGE_KEY)){
            args.putString(ReceiveMessageFragment.MESSAGE_KEY,getIntent().getStringExtra((SENDER_MESSAGE_KEY)));
        }

        myReceiverMessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().add(R.id.receiver_fragment_container, myReceiverMessageFragment).commit();
    }

    @Override
    public void onClick(){
        sendMessageFragment = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.receiver_fragment_container, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onClick(String senderName, String senderMessage) {

    }
}
