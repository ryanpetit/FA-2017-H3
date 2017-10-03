package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
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

    public static final String STRING_KEY_NAME = "string_key_name";
    public static final String STRING_KEY_MESSAGE = "string_key_message";
    private TextView supremeNameReceipt, infindelMessageReceipt;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        supremeNameReceipt = (TextView)view.findViewById(R.id.supreme_name_text);
        infindelMessageReceipt = (TextView)view.findViewById(R.id.infidel_message_text);

        if(getArguments() != null){
            if(getArguments().containsKey(STRING_KEY_NAME)){
                supremeNameReceipt.setText(getArguments().getString(STRING_KEY_NAME));
            }
            if(getArguments().containsKey(STRING_KEY_MESSAGE)){
                infindelMessageReceipt.setText(getArguments().getString(STRING_KEY_MESSAGE));
            }
        }
        return view;
    }

}
