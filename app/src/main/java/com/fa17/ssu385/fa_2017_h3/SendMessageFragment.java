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
    private EditText userNameSubmissionBox;
    private EditText userMessageSubmissionBox;
    private Button sendButton;
    private interface onSendButtonClick{}


    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        SenderActivity listener = (SenderActivity)getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        userNameSubmissionBox = view.findViewById(R.id.user_name_submission_box);
        userMessageSubmissionBox = view.findViewById(R.id.user_message_submission_box);
        sendButton = view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String userNameSubmissionContents = userNameSubmissionBox.getText().toString();
                String userMessageSubmissionContents = userMessageSubmissionBox.getText().toString();
                listener.onClick(userNameSubmissionContents, userMessageSubmissionContents);
            }
        });
        return view;
    }

    public interface OnSendButtonClick{
        void onClick(String senderName, String senderMessage);
    }


}
