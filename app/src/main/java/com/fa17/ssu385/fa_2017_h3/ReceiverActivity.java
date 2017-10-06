package com.fa17.ssu385.fa_2017_h3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity{

    public static final String nameKeyR = "nameKeyR";
    public static final String messageKeyR = "nameKeyR";

    private ReceiveMessageFragment receiveMessageFragment;
    //private SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sendMessageFragment = new SendMessageFragment();

        setContentView(R.layout.activity_receiver);
        receiveMessageFragment = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if(getIntent().hasExtra(nameKeyR)){
            args.putString(ReceiveMessageFragment.nameKey,
                    getIntent().getStringExtra(nameKeyR));
        }

        if(getIntent().hasExtra(messageKeyR)){
            args.putString(ReceiveMessageFragment.messageKey,
                    getIntent().getStringExtra(messageKeyR));
        }

        receiveMessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_receiver, receiveMessageFragment).commit();
    }
/*

    @Override
    public void onClick() {
        sendMessageFragment = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.sender_Frame_Layout, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
*/

}
