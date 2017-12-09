package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
import android.net.sip.SipAudioCall;
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
public class SendMessageFragment extends Fragment{


    private EditText textViewSenderL1;
    private EditText textViewSenderL2;
    private Button textSenderButton;
    private OnSendButtonClick listener;


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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        textViewSenderL1 = (EditText)view.findViewById(R.id.edit_text_sender_l1);
        textViewSenderL2 = (EditText)view.findViewById(R.id.edit_text_sender_l2);
        textSenderButton = (Button)view.findViewById(R.id.text_sender_button);
        textSenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                String message;
                name = textViewSenderL1.getText().toString();
                message = textViewSenderL2.getText().toString();
                listener.onClick(name, message);
            }
        });
        return view;
    }



    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
