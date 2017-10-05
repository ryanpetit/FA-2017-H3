package com.fa17.ssu385.fa_2017_h3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiveMessageFragment extends Fragment {

    public static final String NAME_KEY = "";
    public static final String MESSAGE_KEY = "";
    private TextView namereceipt;
    private TextView messageText;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_receive_message, container, false);
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        namereceipt = (TextView)view.findViewById(R.id.text_view1);
        messageText = (TextView)view.findViewById(R.id.text_view2);

        if (getArguments() != null)
        {
            if (getArguments().containsKey(NAME_KEY))
            {
                namereceipt.setText(getArguments().getString(NAME_KEY));
            }
            if (getArguments().containsKey(MESSAGE_KEY))
            {
                messageText.setText(getArguments().getString(MESSAGE_KEY));
            }
        }
        return view;
    }

}
