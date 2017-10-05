package com.fa17.ssu385.fa_2017_h3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiveMessageFragment extends Fragment {
    public static final String NAME_KEY = "name";
    public static final String MESSAGE_KEY = "message";
    private TextView receiverMessage;
    private TextView receiverName;
    private Button fragmentReplyButton;
    private onReplyButtonClick clicked;

    public ReceiveMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clicked = (onReplyButtonClick)getActivity();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_message,container,false);

        receiverName = (TextView)view.findViewById(R.id.receiver_name);
        receiverMessage = (TextView)view.findViewById(R.id.receiver_message);

        fragmentReplyButton = (Button)view.findViewById(R.id.fragment_reply_button);

        fragmentReplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clicked.onClick();
            }
        });


        if(getArguments() != null){
            if(getArguments().containsKey(NAME_KEY)){
                receiverName.setText(getArguments().getString(NAME_KEY));
            }
            if(getArguments().containsKey(MESSAGE_KEY)){
                receiverMessage.setText(getArguments().getString(MESSAGE_KEY));
            }
        }
        return view;
    }

    public interface onReplyButtonClick{
        void onClick();
    }

}
