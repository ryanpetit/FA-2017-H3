package com.fa17.ssu385.fa_2017_h3;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */

public class SendMessageFragment extends Fragment {
    private EditText user_name;
    private EditText user_message;
    private Button button;
    private OnSendButtonClick listener;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SenderActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        user_message = view.findViewById(R.id.user_message_fragment);
        user_name = view.findViewById(R.id.user_name_fragment);
        button = view.findViewById(R.id.button_fragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                String name = user_name.getText().toString();
                String message = user_message.getText().toString();
                listener.onClick(name, message);
            }
        });
        return view;
    }

    public interface OnSendButtonClick {
        void onClick(String sender_name, String sender_message);
    }

}
