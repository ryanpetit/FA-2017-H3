package com.fa17.ssu385.fa_2017_h3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tyler Gearing on 10/2/17.
 */

public class NewActivity extends AppCompatActivity {

    Button startOverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        startOverButton = (Button)findViewById(R.id.start_over);

        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewActivity.this, SenderActivity.class);
                startActivity(intent);
            }
        });

    }
}
