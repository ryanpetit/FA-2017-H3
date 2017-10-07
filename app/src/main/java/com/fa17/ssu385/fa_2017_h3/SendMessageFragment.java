package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
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

    private EditText username;
    private EditText userMessage;
    private Button sendButton;
    private onSendButtonClick listener;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SenderActivity) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);

        username = (EditText) view.findViewById(R.id.username);
        userMessage = (EditText) view.findViewById(R.id.user_message);
        sendButton = (Button) view.findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String message = userMessage.getText().toString();
                listener.onClick(name, message);
            }

        });

        return view;
    }

    public interface onSendButtonClick{
        void onClick(String senderName, String senderMessage);
    }

}
