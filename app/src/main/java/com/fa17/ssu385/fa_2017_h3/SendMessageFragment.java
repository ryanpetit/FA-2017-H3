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

    public SendMessageFragment() {
        // Required empty public constructor
    }

    private EditText supremeNameText;
    private EditText infidelMessageText;
    private Button sendMessageButton;
    private OnSendButtonClick listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnSendButtonClick )getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        supremeNameText = (EditText)view.findViewById(R.id.supreme_edit_text);
        infidelMessageText = (EditText)view.findViewById(R.id.infidel_edit_text);
        sendMessageButton = (Button)view.findViewById(R.id.send_message_button);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String nameString = supremeNameText.getText().toString();
                String messageString = infidelMessageText.getText().toString();
                listener.onSenderClick(nameString, messageString);
            }
        });
        return view;
    }

    public interface OnSendButtonClick{
        void onSenderClick(String senderName, String senderMessage);
    }

}
