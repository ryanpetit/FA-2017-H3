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
    public static final String nameString;
    public static final String messageString;
    private TextView nameTextView;
    private TextView messageTextView;


    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        nameTextView = (TextView)view.findViewById(R.id.user_name_submission_box);
        messageTextView = (TextView)view.findViewById(R.id.user_message_submission_box);

        if	(getArguments()	!=	null)	{
            if(getArguments().containsKey(nameString))	{
                nameTextView.setText(getArguments().getString(nameString);
            }
            if(getArguments().containsKey(messageString))	{
                messageTextView.setText(getArguments().getString(messageString));
            }
        }
        return	view;
    }

}
