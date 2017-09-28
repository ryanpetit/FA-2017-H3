package com.fa17.ssu385.fa_2017_h3;


import android.app.job.JobScheduler;
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


    private EditText Edit1;
    private EditText Edit2;
    private Button Button1;
    private OnSendButtonClick sendButtonClick;


    public SendMessageFragment() {
        // empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sendButtonClick = (SenderActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        Edit1 = view.findViewById(R.id.Edit1);
        Edit2 = view.findViewById(R.id.Edit2);
        Button1 = view.findViewById(R.id.Button1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Edit1.getText().toString();;
                String message = Edit2.getText().toString();
                sendButtonClick.onClick(name, message);

            }
        });
        return view;
    }

    public interface OnSendButtonClick{
        void onClick(String senderName, String senderMessage);
    }

}