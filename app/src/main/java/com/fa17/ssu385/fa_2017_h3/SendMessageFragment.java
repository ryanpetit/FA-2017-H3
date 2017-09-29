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

    private EditText nameInput;
    private EditText messageInput;
    private Button sendButton;

    private OnSendButtonClick listener;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnSendButtonClick)getActivity();  // listener = the SenderActivity parent obj
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);

        // Link elements
        nameInput = view.findViewById(R.id.nameInput);
        messageInput = view.findViewById(R.id.messageInput);
        sendButton = view.findViewById(R.id.sendButton);

        // Create onClick listener for send button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This code is executed in the main thread when the user presses this button
                String name = nameInput.getText().toString();  // fetch contents of nameInput
                String message = messageInput.getText().toString();  // fetch contents of messageInput
                listener.onClick(name, message);  // call the onClick function of SenderActivity
            }
       });

        return view;
    }

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
