package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SenderActivity extends AppCompatActivity implements SendMessageFragment.OnSendButtonClick{

    SendMessageFragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        sendMessageFragment = new SendMessageFragment();  // new instance of sendMessageFragment
        getSupportFragmentManager().beginTransaction()
                                   .add(R.id.sender_frame, sendMessageFragment)
                                   .commit();  // adding our fragment to the framelayout we set up
    }

    @Override
    public void onClick(String senderName, String senderMessage) {
        // Override function provided by the OnSendButtonClick implementation created in
        // SendMessageFragment

        // This function is called when the sendButton in SendMessageFragment is pressed

        // Create an intent from SenderActivity to ReceiverActivity
        Intent send = new Intent(this, ReceiverActivity.class);

        // Add the contents of senderName to the intent
        if(senderName != null)  // error checking
            send.putExtra(ReceiverActivity.SENDER_NAME_KEY, senderName);

        // Add the contents of senderMessage to the intent
        if(senderMessage != null)  // error checking
            send.putExtra(ReceiverActivity.SENDER_MESSAGE_KEY, senderMessage);

        // Start an instance of the ReceiverActivity class and pass it the senderName and
        // senderMessage variables by using our created Intent
        startActivity(send);
    }
}
