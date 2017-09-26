package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiverActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        ReceiveMessageFragment receiverFragment = new ReceiveMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.receiver_frame_layout, receiverFragment).commit();
    }
}
