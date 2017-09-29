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
    private Button sendButton;
    private EditText senderName, senderMessage;

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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_send_message, container, false);
        sendButton = (Button)rootView.findViewById(R.id.sendfrag_button);
        senderMessage = (EditText)rootView.findViewById(R.id.send_linlay2_edittext);
        senderName = (EditText)rootView.findViewById(R.id.send_linlay1_edittext);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, message;
                name = senderName.getText().toString();
                message = senderMessage.getText().toString();
                listener.onClick(name, message);
            }
        });
        return rootView;
    }

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
