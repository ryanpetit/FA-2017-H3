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
    private EditText fsmEditText1; //  For taking in a user's name // From fragment_send_message.xml
    private EditText fsmEditText2; // For taking in a user's message // " "
    private Button fsmButton1; // The button itself // " "
    private OnSendButtonClick theButtonClick;

    public SendMessageFragment() {
        // empty public constructor - Required
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        theButtonClick = (SenderActivity)getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_send_message, container, false);

        fsmEditText1 = view.findViewById(R.id.fsmEditText1);
        fsmEditText2 = view.findViewById(R.id.fsmEditText2);
        fsmButton1 = view.findViewById(R.id.fsmButton1);
        fsmButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_input = fsmEditText1.getText().toString();
                String message_input = fsmEditText2.getText().toString();

                theButtonClick.onClick(name_input, message_input);
            }
        });
        return view;
    }
    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
