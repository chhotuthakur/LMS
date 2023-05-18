package com.nilesh.lms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    //made three variables

    TextView log,reg;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        log = findViewById(R.id.login_txt);
        reg = findViewById(R.id.reg_txt);

        fragment = new LoginPageFrgmt();

        FragmentManager fragmentManager = getSupportFragmentManager();

//                call fragment transaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.acc_frag_container,fragment);
        transaction.addToBackStack(fragment.toString());
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment selFrag = new LoginPageFrgmt();

//                call fragment manager
                FragmentManager fragmentManager = getSupportFragmentManager();

//                call fragment transaction
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.acc_frag_container,selFrag);
                transaction.addToBackStack(fragment.toString());
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.commit();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment selFrag = new RegFragment();

//                call fragment manager
                FragmentManager fragmentManager = getSupportFragmentManager();

//                call fragment transaction
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.acc_frag_container,selFrag);
                transaction.addToBackStack(fragment.toString());
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.commit();

            }
        });
    }
}