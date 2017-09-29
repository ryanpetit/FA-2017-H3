package com.fa17.ssu385.fa_2017_h3;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiveMessageFragment extends Fragment {
    public static final String nameFinal = "nameFinal";
    public static final String messageFinal= "messageFinal";
    private TextView nameString;
    private TextView messageString;
    private Button replyButton;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);
        nameString = (TextView)view.findViewById(R.id.receiver_linear1_textview2);
        messageString = (TextView)view.findViewById(R.id.receiver_linear2_textview);
        replyButton = (Button)view.findViewById(R.id.receiver_button);
        replyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // listener.onClick();
                Intent newIntent = new Intent(ReceiveMessageFragment.this.getActivity(), NewActivity.class);
                startActivity(newIntent);
            }
        });

        if (getArguments() != null) {
            if(getArguments().containsKey(nameFinal)) {
                nameString.setText(getArguments().getString(nameFinal));
            }
            if(getArguments().containsKey(messageFinal)) {
                messageString.setText(getArguments().getString(messageFinal));
            }
        }
        return view;
    }

    public interface OnReplyButtonClick{
        void onClick();
    }
}
