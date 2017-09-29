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
    public static final String NAME_KEY = "NAME";
    public static final String MSG_KEY = "MESSAGE";
    private TextView receivedName, receivedMessage;
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
        final View rootView = inflater.inflate(R.layout.fragment_receive_message, container, false);
        receivedName = (TextView)rootView.findViewById(R.id.recfrag_linlay1_textview2);
        receivedMessage = (TextView)rootView.findViewById(R.id.recfrag_linlay2_textview1);
        replyButton = (Button)rootView.findViewById(R.id.recfrag_linlay2_button);

        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick();
            }
        });

        if (getArguments() != null) {
            if (getArguments().containsKey(NAME_KEY)) {
                receivedName.setText(getArguments().getString(NAME_KEY));
            }
            if (getArguments().containsKey(MSG_KEY)) {
                receivedMessage.setText(getArguments().getString(MSG_KEY));
            }
        }
        return rootView;
    }

    public interface OnReplyButtonClick {
        void onClick();
    }
}
