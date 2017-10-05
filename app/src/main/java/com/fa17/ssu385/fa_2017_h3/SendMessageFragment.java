package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendMessageFragment extends Fragment {

    private EditText edittext1;
    private EditText edittext2;
    private Button fragsendbutton;
    private OnSendButtonClick listener;

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
        View view;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_send_message, container, false);

        edittext1 = (EditText)view.findViewById(R.id.edit_text1);
        edittext2 = (EditText)view.findViewById(R.id.edit_text2);
        fragsendbutton = (Button)view.findViewById(R.id.frag_send_Button);

        fragsendbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name = edittext1.getText().toString();
                String message = edittext2.getText().toString();

                listener.onClick(name, message);

            }
        });

        return view;
    }

    public interface OnSendButtonClick {
        void onClick(String senderName, String senderMessage);

    }

}
