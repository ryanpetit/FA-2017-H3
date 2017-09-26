package com.fa17.ssu385.fa_2017_h3;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        SendMessageFragment senderFragment = new SendMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.sender_frame_layout, senderFragment).commit();
    }
}
