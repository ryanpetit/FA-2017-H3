package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick {

    public static final String string1 = "string1";
    public static final String string2 = "string2";

    private ReceiveMessageFragment receivemessageFragment;
    private SendMessageFragment sendmessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        receivemessageFragment = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if (getIntent().hasExtra(string1)) {
            args.putString(ReceiveMessageFragment.string1Fragment,
                    getIntent().getStringExtra(string1));
        }

        if (getIntent().hasExtra(string2)) {
            args.putString(ReceiveMessageFragment.string2Fragment,
                    getIntent().getStringExtra(string2));
        }
        receivemessageFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                                   .add(R.id.reciever_frame_layout, receivemessageFragment)
                                   .commit();
    }

    @Override
    public void onClick() {
        sendmessageFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.recieve_constraint_layout, sendmessageFragment)
                                   .commit();
    }
}
