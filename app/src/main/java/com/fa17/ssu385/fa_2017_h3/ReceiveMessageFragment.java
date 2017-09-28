package com.fa17.ssu385.fa_2017_h3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiveMessageFragment extends Fragment {

    public static final String NAME_KEY = "namekey";
    public static final String MESSAGE_KEY = "messagekey";

    private TextView nameReceipt;
    private TextView messageText;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        /* Inflate Fragment view, retrieve Strings passed by ReceiverActivity, and assign their
         * value to the TextViews
         */
        nameReceipt = (TextView) view.findViewById(R.id.nameReceipt);
        messageText = (TextView) view.findViewById(R.id.messageText);

        if(getArguments() != null) {
            if(getArguments().containsKey(NAME_KEY)){
                nameReceipt.setText(getArguments().getString(NAME_KEY));
            }

            if(getArguments().containsKey(MESSAGE_KEY)){
                messageText.setText(getArguments().getString(MESSAGE_KEY));
            }
        }
        return view;
    }

}
