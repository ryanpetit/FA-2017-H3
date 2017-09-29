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

    private EditText nameTextEdit;
    private EditText messageTextEdit;
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        nameTextEdit = view.findViewById(R.id.name_text_edit);
        messageTextEdit = view.findViewById(R.id.message_text_edit);
        sendButton = view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String inputMessage, inputName;
                inputMessage =messageTextEdit.getText().toString();
                inputName =nameTextEdit.getText().toString();
                listener.onClick(inputMessage, inputName);
            }
        });

        String nameInput, messageInput;
        return view;
    }
    public interface OnSendButtonClick{
        void onClick(String senderMessage, String senderName);
    }
}
