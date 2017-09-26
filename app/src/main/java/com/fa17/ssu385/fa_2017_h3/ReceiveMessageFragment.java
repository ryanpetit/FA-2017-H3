package com.fa17.ssu385.fa_2017_h3;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiveMessageFragment extends Fragment {
    private Button replyButton;
    private TextView receivedName, receivedMessage;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_receive_message, container, false);
        replyButton = (Button)rootView.findViewById(R.id.recfrag_linlay2_button);
        receivedName = (TextView)rootView.findViewById(R.id.recfrag_linlay1_textview2);
        receivedMessage = (TextView)rootView.findViewById(R.id.recfrag_linlay2_textview1);
        String retrievedMessage = null;
        String retrievedName = null;
        if (getActivity().getIntent().hasExtra("MESSAGE")) {
            retrievedMessage = getActivity().getIntent().getStringExtra("MESSAGE");
            receivedMessage.setText(retrievedMessage);
        }
        if (getActivity().getIntent().hasExtra("NAME")) {
            retrievedName = getActivity().getIntent().getStringExtra("NAME");
            receivedName.setText(retrievedName);
        }
        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendReply();
            }
        });
        return rootView;
    }

    private void sendReply() {
        startActivity(new Intent(this.getActivity(), SenderActivity.class));
    }

}
