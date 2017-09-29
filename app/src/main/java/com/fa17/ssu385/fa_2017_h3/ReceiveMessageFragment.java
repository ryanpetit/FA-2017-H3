package com.fa17.ssu385.fa_2017_h3;


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

    public static final string NAME_KEY = "name_key";
    public static final string MESSAGE_KEY = "message_key";

    private TextView nameReceipt;
    private TextView messageText;
    private Button reply;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive_message, container, false);

        nameReceipt =;
        messageText =;
        reply =;



        if (getArguments() != null) {
            if(getArguments().containskey(NAME_KEY)) {
                nameReceipt.setText(getArguments().getString(NAME_KEY));
            }
            if(getArguments().containsKey())
        }
    }

}
