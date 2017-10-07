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

    public static final String name = "name";
    public static final String message = "message";

    private TextView nameReceive;
    private TextView messageReceive;
    private Button reply;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        nameReceive = (TextView)view.findViewById(R.id.receive_text2);
        messageReceive = (TextView)view.findViewById(R.id.receive_text3);




        if (getArguments() != null) {
            if(getArguments().containsKey(name)) {
                nameReceive.setText(getArguments().getString(name));
            }
            if(getArguments().containsKey(message)) {
                messageReceive.setText(getArguments().getString(message));
            }
        }
        return view;
    }

}
