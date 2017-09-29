package com.fa17.ssu385.fa_2017_h3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiveMessageFragment extends Fragment {
    public static final String NAME_KEY_FRAGMENT = null;
    public static final String MESSAGE_KEY_FRAGMENT = null;

    private TextView receiveName;
    private TextView receiveMessage;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_receive_message, container, false);
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        receiveName = (TextView)view.findViewById(R.id.receive_name);
        receiveMessage = (TextView)view.findViewById(R.id.receive_message);

        if (getArguments() != null){
            if(getArguments().containsKey(NAME_KEY_FRAGMENT)){
                String myString = getArguments().getString(NAME_KEY_FRAGMENT);
                receiveName.setText(getArguments().getString(NAME_KEY_FRAGMENT));
            }

            if(getArguments().containsKey(MESSAGE_KEY_FRAGMENT)){
                receiveMessage.setText(getArguments().getString(MESSAGE_KEY_FRAGMENT));
            }
        }
        return view;
    }

}
