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
    public static final String NAME_KEY = "gkkdjf";
    public static final String MESSAGE_TEXT = "jfdkjf";
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
        nameReceipt = (TextView)view.findViewById(R.id.Text5);
        messageText = (TextView)view.findViewById(R.id.Text3);
        if(getArguments() != null){
            if(getArguments().containsKey(NAME_KEY)){
                nameReceipt.setText(getArguments().getString(NAME_KEY));
            }
            if(getArguments().containsKey(MESSAGE_TEXT)){
                messageText.setText(getArguments().getString(MESSAGE_TEXT));
            }
        }
        return view;
    }

}
