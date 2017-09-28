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

    public static final String NAME_KEY = "name_key";
    public static final String MESSAGE_KEY = "message_key";
    private TextView receiverFragmentLinearLayout1TextView2; //Name
    private TextView getReceiverFragmentLinearLayout2TextView1; //Message

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);
        receiverFragmentLinearLayout1TextView2 = (TextView)view
                .findViewById(R.id.receiver_fragment_linear_layout_1_text_view_2);
        getReceiverFragmentLinearLayout2TextView1 = (TextView)view
                .findViewById(R.id.receiver_fragment_linear_layout_2_text_view_1);

        if(getArguments() != null){
            if(getArguments().containsKey(NAME_KEY)){
                receiverFragmentLinearLayout1TextView2.setText(getArguments().getString(NAME_KEY));
            }
            if(getArguments().containsKey(MESSAGE_KEY)){
                getReceiverFragmentLinearLayout2TextView1.setText(getArguments().getString(MESSAGE_KEY));
            }
        }

        return view;
    }

}
