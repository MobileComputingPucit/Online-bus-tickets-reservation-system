package com.example.imtisal.finalprojectv5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    Button niaziBut,daewooBut,volvoBut;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home, container, false);
        daewooBut=(Button) v.findViewById(R.id.daewooBut);
        volvoBut=(Button) v.findViewById(R.id.volvoBut);
        niaziBut=(Button) v.findViewById(R.id.niaziBut);
        daewooBut.setOnClickListener(this);
        volvoBut.setOnClickListener(this);
        niaziBut.setOnClickListener( this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.daewooBut:
                LoginFragment loginFragment1= new LoginFragment();
                FragmentTransaction fragmentTransaction1=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame,loginFragment1,"loginFragment1");
                fragmentTransaction1.commit();

                break;
            case R.id.volvoBut:
                LoginFragment loginFragment2= new LoginFragment();
                FragmentTransaction fragmentTransaction2=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frame,loginFragment2,"loginFragment2");
                fragmentTransaction2.commit();
            case R.id.niaziBut:
                LoginFragment loginFragment3= new LoginFragment();
                FragmentTransaction fragmentTransaction3=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.frame,loginFragment3,"loginFragment3");
                fragmentTransaction3.commit();

        }

    }
}
