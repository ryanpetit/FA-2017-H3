package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity {
    public static final String NAME_KEY = null;
    public static final String MESSAGE_KEY = null;
    private ReceiveMessageFragment receiveMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiveMessageFragment = new ReceiveMessageFragment();
        Bundle args = new Bundle();
        //key names??
        if (getIntent().hasExtra(NAME_KEY)){
            args.putString(ReceiveMessageFragment.NAME_KEY_FRAGMENT,
            getIntent().getStringExtra(NAME_KEY));
            String myString = ReceiveMessageFragment.NAME_KEY_FRAGMENT;
            String myOtherString = getIntent().getStringExtra(NAME_KEY);
        }

        if(getIntent().hasExtra(MESSAGE_KEY)){
            args.putString(ReceiveMessageFragment.MESSAGE_KEY_FRAGMENT,
            getIntent().getStringExtra(MESSAGE_KEY));
        }

        receiveMessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                                    .add(R.id.receiver_container, receiveMessageFragment)
                                    .commit();
    }
}
