package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ReceiverActivity extends AppCompatActivity {
    public static final String senderNameString = "sender_name_string";
    public static final String senderMessageString = "sender_message_string";
    private ReceiveMessageFragment receiveMessageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiveMessageFragment = new ReceiveMessageFragment();

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
