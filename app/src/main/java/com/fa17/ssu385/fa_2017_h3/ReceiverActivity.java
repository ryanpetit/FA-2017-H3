package com.fa17.ssu385.fa_2017_h3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity implements ReceiveMessageFragment.OnReplyButtonClick {

    public static final String NAME_KEY_SENDER = "name_key_sender";
    public static final String MESSAGE_KEY_SENDER = "message_key_sender";
    private ReceiveMessageFragment receiverFragment;
    private SendMessageFragment newSenderFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        receiverFragment = new ReceiveMessageFragment();
        Bundle args = new Bundle();

        if(getIntent().hasExtra(NAME_KEY_SENDER)){
            args.putString(ReceiveMessageFragment.STRING_KEY_NAME,
                    getIntent().getStringExtra(NAME_KEY_SENDER));
        }
        if(getIntent().hasExtra(MESSAGE_KEY_SENDER)){
            args.putString(ReceiveMessageFragment.STRING_KEY_MESSAGE,
                    getIntent().getStringExtra(MESSAGE_KEY_SENDER));
        }

        receiverFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().add(R.id.receiver_frame_layout, receiverFragment).commit();
    }

    @Override
    public void onReplyClick(String replyName, String replyMessage) {
        newSenderFrag = new SendMessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.bottom_receiver_layout, newSenderFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //@Override
    //public void onReplyClick(String nameReply, String messageReply) {
    //    newSenderFrag = new SendMessageFragment();
    //    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    //    transaction.replace(R.id.bottom_button, newSenderFrag);
    //    transaction.addToBackStack(null);
    //    transaction.commit();
    }
}
