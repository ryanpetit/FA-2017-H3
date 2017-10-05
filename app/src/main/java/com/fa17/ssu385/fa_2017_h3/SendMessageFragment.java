package com.fa17.ssu385.fa_2017_h3;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendMessageFragment extends Fragment {

    private EditText sendLinearName;
    private EditText sendLinearMessage;
    private Button sendButton;
    private OnSendButtonClick sendButtonClick;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sendButtonClick = (SenderActivity)getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);

        sendLinearName = view.findViewById(R.id.sendLinearName);

        sendLinearMessage = view.findViewById(R.id.sendLinearMessage);

        sendButton = view.findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name = sendLinearName.getText().toString();
                String message = sendLinearMessage.getText().toString();
                sendButtonClick.onClick(name, message);
            }

        });

        return view;

    }
    public interface OnSendButtonClick {
        void onClick(String sendLinearName, String sendLinearMessage);

    }
}


