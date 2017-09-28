package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendMessageFragment extends Fragment {

    private TextView textName;
    private TextView textMessage;
    private EditText userName;
    private EditText userMessage;
    private Button button;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);

        textName = view.findViewById(R.id.send_linear_text1);
        textMessage = view.findViewById(R.id.send_linear_text2);
        userName = view.findViewById(R.id.send_linear_edit1);
        userMessage = view.findViewById(R.id.send_linear_edit2);
        button = view.findViewById(R.id.send_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                String message;
                name = userName.getText().toString();
                message = userMessage.getText().toString();
                listener.onClick(name, message);
            }
        });

        return view;
    }

    private OnSendButtonClick listener;

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
