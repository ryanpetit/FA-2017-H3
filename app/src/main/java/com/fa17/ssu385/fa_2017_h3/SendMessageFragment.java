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

    private EditText editName;
    private EditText editMessage;
    private Button senderButton;

    private OnSendButtonCLick listener;



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
        View view  = inflater.inflate(R.layout.fragment_send_message, container, false);

        editName = (EditText) view.findViewById(R.id.layout1_edittext);
        editMessage = (EditText) view.findViewById(R.id.layout2_edittext);
        senderButton = (Button) view.findViewById(R.id.sendButton);

        senderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString();
                String message = editMessage.getText().toString();
                listener.onClick(name,message);

            }
        });

        return view;
    }

    public interface OnSendButtonCLick{
        void onClick(String senderName, String senderMessage);
    }

}
