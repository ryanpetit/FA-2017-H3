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

    private EditText send_edit11;
    private EditText send_edit22;
    private Button   send_button;
    private OnSendButtonClick listener;


    public SendMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
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
        send_edit11 = (EditText)view.findViewById(R.id.send_edit1);
        send_edit22 = (EditText)view.findViewById(R.id.send_edit2);
        send_button = (Button)view.findViewById(R.id.send_button);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
                String name = send_edit11.getText().toString();
                String message = send_edit22.getText().toString();
                listener.onClick(name, message);

        });

        return view;
    }

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);
    }

}
