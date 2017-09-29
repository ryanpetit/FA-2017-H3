package com.fa17.ssu385.fa_2017_h3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        text = (TextView)findViewById(R.id.new_text);
        text.setText("I'm New");
    }
}
