package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
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
    public static final String MESSAGE = "recievedMessage";
    public static final String NAME = "senderName";
    private TextView receivedMessage;
    private TextView senderName;
    private Button replyButton;
    private ReceiveMessageFragment.OnReplyButtonClick listener;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnReplyButtonClick) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);
        receivedMessage = (TextView)view.findViewById(R.id.received_message);
        senderName = (TextView)view.findViewById(R.id.sender_name);
        if(getArguments() != null){
            if(getArguments().containsKey(NAME)){
                senderName.setText(getArguments().getString(NAME));
            }
            if(getArguments().containsKey(MESSAGE)){
                receivedMessage.setText(getArguments().getString(MESSAGE));
            }
        }
        replyButton = view.findViewById(R.id.reply_button);
        replyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onClick();
            }
        });

        return view;
    }

    public interface OnReplyButtonClick {
        void onClick();
    }
}
