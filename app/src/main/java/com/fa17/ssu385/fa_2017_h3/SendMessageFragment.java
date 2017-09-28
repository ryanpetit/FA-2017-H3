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
    private OnSendButtonClick clicked;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clicked = (SenderActivity)getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        nameText = view.findViewById(R.id.name_text);
        messageText = view.findViewById(R.id.message_text);
        sendButton = view.findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               String nameInput = nameText.getText().toString();
               String messageInput = messageText.getText().toString();
               clicked.onClick(nameInput,messageInput);
           }
        });

        return view;


    }

    public interface OnSendButtonClick{
        void onClick(String senderName, String senderMessage);
    }

}
