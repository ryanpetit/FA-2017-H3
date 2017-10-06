package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiveMessageFragment extends Fragment {

    public static final String nameKey = "nameKey";
    public static final String messageKey = "messageKey";
    private TextView nameReceipt;
    private TextView message;
    private Button replyButton;
    private OnReplyButtonClick listener;
    public ReceiveMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnReplyButtonClick)getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message, container, false);
        nameReceipt = (TextView)view.findViewById(R.id.edit_text_one);
        message = (TextView)view.findViewById(R.id.edit_text_two);
        replyButton = (Button)view.findViewById(R.id.reply_button);


        if (getArguments() != null) {
            if(getArguments().containsKey(nameKey)){
                nameReceipt.setText(getArguments().getString(nameKey));
            }
            if(getArguments().containsKey(messageKey)){
                message.setText(getArguments().getString(messageKey));
            }
        }
        return view;
    }

    public interface OnReplyButtonClick {
        void onClick();
    }

}
