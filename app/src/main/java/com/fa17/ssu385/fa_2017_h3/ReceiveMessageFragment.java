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

    public static final String NAME_KEY = "name";
    public static final String MESSAGE_KEY = "message";

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
        listener = (OnReplyButtonClick) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);

        name = (TextView)view.findViewById(R.id.receive_users_name);
        message = (TextView)view.findViewById(R.id.receive_users_message);
        replyButton = (Button)view.findViewById(R.id.reply_button);

        if(getArguments() != null) {
            if(getArguments().containsKey(NAME_KEY)) {
                String nameVal = getArguments().getString(NAME_KEY);
                name.setText(nameVal);
            }

            if(getArguments().containsKey(MESSAGE_KEY)) {
                message.setText(getArguments().getString(MESSAGE_KEY));
            }
        }

        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick();
            }
        });

        return view;
    }

    public interface OnReplyButtonClick {
        void onClick();
    }

}
