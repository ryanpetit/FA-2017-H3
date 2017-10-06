package com.fa17.ssu385.fa_2017_h3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */

public class ReceiveMessageFragment extends Fragment {
    public static final String NAME_KEY = "name_key";
    public static final String MESSAGE_KEY = "message_key";
    private TextView nameReceipt, messageText;
    private Button button;
    private OnReplyButtonClick listener;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnReplyButtonClick)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        nameReceipt = (TextView)view.findViewById(R.id.receiver_name);
        messageText = (TextView)view.findViewById(R.id.receiver_message);
        button = (Button)view.findViewById(R.id.receiver_button);

        if (getArguments() != null) {
            if (getArguments().containsKey(NAME_KEY)) {
                nameReceipt.setText(getArguments().getString(NAME_KEY));
            }

            if (getArguments().containsKey(MESSAGE_KEY)) {
                messageText.setText(getArguments().getString(MESSAGE_KEY));
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                listener.onClick();
            }
        });

        return view;
    }

    public interface OnReplyButtonClick {
        void onClick();
    }

}
