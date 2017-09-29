

package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
//Joshua hernandez

/**
 * A simple {@link Fragment} subclass.
 */
public class SendMessageFragment extends Fragment {
    private EditText senderNameEditText;
    private EditText senderMessageEditText;
    private Button senderButton;

    private OnSendButtonClick listener;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SenderActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        senderNameEditText = view.findViewById(R.id.sender_name_edit_text);
        senderMessageEditText = view.findViewById(R.id.sender_message_text);
        senderButton = view.findViewById(R.id.sender_button);

        senderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = senderNameEditText.getText().toString();
                String message = senderMessageEditText.getText().toString();
                listener.onClick(name, message);
            }
        });
        return view;
    }

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }
}