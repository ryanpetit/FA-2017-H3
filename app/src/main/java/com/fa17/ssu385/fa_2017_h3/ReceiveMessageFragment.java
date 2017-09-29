package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
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

    public static final String string1Fragment = "string1Fragment";
    public static final String string2Fragment = "string2Fragment";

    private TextView name;
    private TextView message;
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

        name = (TextView)view.findViewById(R.id.recieve_linear1_text2);
        message = (TextView)view.findViewById(R.id.recieve_linear2_text);
        replyButton = (Button)view.findViewById(R.id.recieve_linear2_button);

        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick();
            }
        });

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

    public interface OnReplyButtonClick {
        void onClick();
    }

}
