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

    public static final String string1Fragment;
    public static final String string2Fragment;

    private TextView name;
    private TextView message;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);
        name = (TextView)view.findViewById(R.id.recieve_linear1_text1);
        message = (TextView)view.findViewById(R.id.recieve_linear1_text2);

        if (getArguments() != null) {
            if (getArguments().containsKey(string1Fragment)) {
                name.setText(getArguments().getString(string1Fragment));
            }
            if (getArguments().containsKey(string2Fragment)) {
                message.setText(getArguments().getString(string2Fragment));
            }
        }
        return view;
    }

}
