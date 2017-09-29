package com.fa17.ssu385.fa_2017_h3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick{
    public static final String stringName = "stringName";
    public static final String stringMessage = "stringMessage";
    private ReceiveMessageFragment receiver;
    private SendMessageFragment sendMessageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiver = new ReceiveMessageFragment();
        Bundle args = new Bundle();
        if(getIntent().hasExtra(stringName)) {
            args.putString(ReceiveMessageFragment.nameFinal,
                    getIntent().getStringExtra(stringName));
        }
        if(getIntent().hasExtra(stringMessage)) {
            args.putString(ReceiveMessageFragment.messageFinal,
                    getIntent().getStringExtra(stringMessage));
        }
        receiver.setArguments(args);
        getSupportFragmentManager().beginTransaction().add(R.id.receiver_frame_layout, receiver)
                .commit();
    }

    @Override
    public void onClick() {
        sendMessageFragment = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.new_activity, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
