package com.example.imtisal.finalprojectv5;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {
Button btnBookTicket,btnGetDetail,btnCancelTicket;
View v;
    public FirstFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_first, container, false);
        btnBookTicket=(Button) v.findViewById(R.id.btnBookTicket);
        btnGetDetail=(Button)v.findViewById(R.id.btnGetDetails);
        btnCancelTicket=(Button) v.findViewById(R.id.btnCancelTicket);



        btnBookTicket.setOnClickListener(this);
        btnGetDetail.setOnClickListener(this);
        btnCancelTicket.setOnClickListener(this);

        // Inflate the layout for this fragment
        return v;
    }

 @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBookTicket:
                LoginFragment loginFragment= new LoginFragment();
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,loginFragment,"loginFragment2");
                fragmentTransaction.commit();

                break;
            case R.id.btnGetDetails:
                LoginFragment loginFragment2= new LoginFragment();
                FragmentTransaction fragmentTransaction2=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frame,loginFragment2,"loginFragment2");
                fragmentTransaction2.commit();
                break;
            case R.id.btnCancelTicket:
                LoginFragment loginFragment3= new LoginFragment();
                FragmentTransaction fragmentTransaction3=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.frame,loginFragment3,"loginFragment3");
                fragmentTransaction3.commit();
                break;

        }

    }
}
