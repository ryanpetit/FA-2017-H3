package com.fa17.ssu385.fa_2017_h3;


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
    private EditText enterName;
    private EditText enterMessage;
    private Button sendButton;
    private OnSendButtonClick listener;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnSendButtonClick) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        enterName = (EditText) view.findViewById(R.id.enter_name);
        enterMessage = (EditText) view.findViewById(R.id.enter_message);
        sendButton = (Button)view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                String message;
                name = enterName.getText().toString();
                message = enterMessage.getText().toString();
                listener.onClick(name, message);
            }
        });
        return view;
    }

    public interface OnSendButtonClick{
        //all methods and interfaces must be PUBLIC
        void onClick(String senderName, String senderMessage);
    }

}
