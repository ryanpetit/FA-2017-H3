package com.fa17.ssu385.fa_2017_h3;


import android.app.Activity;
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
    private EditText senderFragmentLinearLayout1Edit;//Name Text Box
    private EditText senderFragmentLinearLayout2Edit;//Message Text Box
    private Button senderFragmentButton;//Send Button
    private OnSendButtonClick listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SenderActivity)getActivity();
    }

    public SendMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);

        senderFragmentLinearLayout1Edit = view.findViewById(R.id.sender_fragment_linear_layout_1_edit);
        senderFragmentLinearLayout2Edit = view.findViewById(R.id.sender_fragment_linear_layout_2_edit);
        senderFragmentButton = view.findViewById(R.id.sender_fragment_button);
        senderFragmentButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = senderFragmentLinearLayout1Edit.getText().toString();
                String message = senderFragmentLinearLayout2Edit.getText().toString();
                listener.onClick(name, message);
            }
        });

        return view;
    }

    public interface OnSendButtonClick{
        void onClick(String senderName, String senderMessage);
    }
}
