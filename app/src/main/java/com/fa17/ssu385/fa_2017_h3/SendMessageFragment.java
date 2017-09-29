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

    private EditText linearEdit1;
    private EditText linearEdit2;
    private Button sendButton;
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
        linearEdit1 = (EditText)view.findViewById(R.id.linear_edit1);
        linearEdit2 = (EditText)view.findViewById(R.id.linear_edit2);
        sendButton = (Button)view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = linearEdit1.getText().toString();
                String message = linearEdit2.getText().toString();
                listener.onClick(name, message);
            }
        });
        return view;
    }

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
