package com.example.imtisal.finalprojectv5;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements  View.OnClickListener {
    Button signBut,loginBut;
    EditText loginpass,loginmail;
    View v;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_login, container, false);
        loginmail=(EditText) v.findViewById(R.id.edit1);
        loginpass=(EditText) v.findViewById(R.id.edit2);
        signBut=(Button) v.findViewById(R.id.signBut);
        loginBut=(Button) v.findViewById(R.id.loginBut);
        loginBut.setOnClickListener(this);
        signBut.setOnClickListener(this);


        return v;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBut:
                checkMail();

                break;
            case R.id.signBut:
                SignupFragment signup2= new SignupFragment();
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,signup2,"signup2Fragment");
                fragmentTransaction.commit();
        }
    }
    public void checkMail(){
        String checklogmail= loginmail.getText().toString();
        String checklogpass= loginpass.getText().toString();
        if (TextUtils.isEmpty(checklogmail)) {
            loginmail.setError("This field cannot be empty");
            return;
        } else if (TextUtils.isEmpty(checklogpass)) {
            loginpass.setError("This field cannot be empty");
            return;
        }


        SharedPreferences sharedPref =this.getActivity(). getSharedPreferences("User Info", Context.MODE_PRIVATE);
        String logm = sharedPref.getString("signUpMail", "");
        String logpw = sharedPref.getString("password", "");
        String logmail=loginmail.getText().toString();
        String logpass=loginpass.getText().toString();

        if (logm.equals(logmail)&& logpw.equals(logpass))
        {
            Toast.makeText(getActivity(), "You are logged in!!!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity(),Profile.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(getActivity(), "Incorrect Username or Password", Toast.LENGTH_LONG).show();
        }

    }



}




