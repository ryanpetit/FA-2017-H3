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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater;
        supremeNameText = view.findViewById(R.id.supreme_edit_text);
        infidelMessageText = view.findViewById(R.id.infidel_edit_text);
        sendMessageButton = view.findViewById(R.id.send_message_button);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                public String nameString;
                public String messageString;
                nameString = nameInput.getText().toString();
                messageString = messageInput.getText().toString();
            }
        });
        return view;
        //return view.inflate(R.layout.fragment_send_message, container, false);
    }

}
