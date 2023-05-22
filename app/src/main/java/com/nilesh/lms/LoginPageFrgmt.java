package com.nilesh.lms;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nilesh.lms.activity.MainActivity;


public class LoginPageFrgmt extends Fragment {

    Button btn;



    public LoginPageFrgmt() {
        // Required empty public constructor
    }


    public static LoginPageFrgmt newInstance(String param1, String param2) {
        LoginPageFrgmt fragment = new LoginPageFrgmt();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);

        btn = v.findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });


        return v;
    }
}