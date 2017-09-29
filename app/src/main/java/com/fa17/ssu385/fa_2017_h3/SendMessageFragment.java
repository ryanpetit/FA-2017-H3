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
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);
        send_edit11 = view.findViewById(R.id.send_text1);
        send_edit22 = view.findViewById(R.id.send_text2);
        send_button = view.findViewById(R.id.send_button);
        send_button.setOnClickListener(new View.OnClickListener());

                @Override
                public void onClick(View v) {
                    string name_input;
                    string message_input;
                    name_input = send_edit11.getText().toString();
        }
        return view;
    }

}
