package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity {
    public static final String senderNameString;
    public static final String senderMessageString;
    private ReceiveMessageFragment receiveMessageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiveMessageFragment = (receiveMessageFragment)findViewById(R.id.user_message_submission_box);
        Bundle args = new Bundle();

        if(getIntent().hasExtra(senderNameString))	{
            args.putString(ReceiveMessageFragment.nameString,
                    getIntent().getStringExtra(senderNameString));
        }
        if(getIntent().hasExtra(senderMessageString))	{
            args.putString(ReceiveMessageFragment.messageString,
                    getIntent().getStringExtra(senderMessageString));
        }
        receiveMessageFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.sender_text,	receiveMessageFragment)
                .commit();
    }
}
