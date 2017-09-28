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

    private EditText edit1;
    private EditText edit2;
    private Button button1;

    private OnSendButtonClick listener;

    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnSendButtonClick)getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        edit1 = view.findViewById(R.id.edit1);
        edit2 = view.findViewById(R.id.edit2);
        button1 = view.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit1.getText().toString();
                String message = edit2.getText().toString();
                listener.onClick(name, message);
            }
       });
        return view;
    }

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
