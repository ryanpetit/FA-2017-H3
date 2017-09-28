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

    private EditText nameText;
    private EditText messageText;
    private Button sendButton;
    private onSendButtonClick clicked;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SenderActivity)getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        nameText = view.findViewById(R.name_text);
        messageText = view.findViewById(R.message_text);
        sendButton = view.findViewById(R.send_button);

        sendButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               String nameInput = nameText.getText().toString();
               String messageInput = messageText.getText().toString();
               listener.onClick(nameInput,messageInput);
           }
        });

        return view;

    }

    public interface onSendButtonClick{
        void onClick(String senderName, String senderMessage);
    }

}
