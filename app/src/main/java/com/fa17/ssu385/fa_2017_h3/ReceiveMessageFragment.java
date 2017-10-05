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

    public static final String STRING_KEY_NAME = "string_key_name";
    public static final String STRING_KEY_MESSAGE = "string_key_message";
    private TextView supremeNameReceipt, infidelMessageReceipt;
    private Button mrButton;
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

        supremeNameReceipt = (TextView)view.findViewById(R.id.first_receiver_text);
        infidelMessageReceipt = (TextView)view.findViewById(R.id.first_bottom_text);

        if(getArguments() != null){
            if(getArguments().containsKey(STRING_KEY_NAME)){
                supremeNameReceipt.setText(getArguments().getString(STRING_KEY_NAME));
            }
            if(getArguments().containsKey(STRING_KEY_MESSAGE)){
                infidelMessageReceipt.setText(getArguments().getString(STRING_KEY_MESSAGE));
            }
        }

        mrButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), SenderActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public interface OnReplyButtonClick{
        void onClick(String names_reply, String message_reply);
    }

}
