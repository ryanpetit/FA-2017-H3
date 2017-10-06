package com.fa17.ssu385.fa_2017_h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    public static final String SUCCESS_MESSAGE_KEY = "success";
    private TextView newText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        newText = (TextView)findViewById(R.id.new_text);
        if (getIntent().getStringExtra(SUCCESS_MESSAGE_KEY) != null){
            newText.setText(getIntent().getStringExtra(SUCCESS_MESSAGE_KEY));
        }

    }
}
