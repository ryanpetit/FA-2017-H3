package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity {

    public static final String name2 = "name2";
    public static final String message2 = "message2";

    private ReceiveMessageFragment receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiver = new ReceiveMessageFragment();
        Bundle args = new Bundle();
    }

    if(getIntent().hasExtra(name2)) {
        args.putString(receiver.name,
        getIntent().getStringExtra(name2));
    }

    if(getIntent().hasExtra(message2)) {
        args.putString(receiver.message,
                getIntent().getStringExtra(message2));
    }

    receiver.setArguments(args);

    getSupportFragmentManager().beginTransaction()
                                .add(R.id.receiver_frame, receiver)
                                .commit();
}
