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

    public static final string name = "name";
    public static final string message = "message";

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
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        nameReceipt = (TextView)view.findViewById(R.id.receive_text1);
        messageText = (TextView)view.findViewById(R.id.receive_text2);
        reply =;



        if (getArguments() != null) {
            if(getArguments().containsKey(name)) {
                nameReceipt.setText(getArguments().getString(name));
            }
            if(getArguments().containsKey(message)) {
                messageText.setText(getArguments().getString(message));
            }
        }
        return view;
    }

}
