package com.example.imtisal.finalprojectv5;

import android.content.Context;
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

public class SignupFragment extends Fragment implements View.OnClickListener {

    EditText enterName,enterPass,enterMail,enterPh,enterDob;
    Button signupbut;
    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_signup, container, false);
        enterName= (EditText) v.findViewById(R.id.enterName);
        enterPass= (EditText) v.findViewById(R.id.enterPass);
        enterMail= (EditText) v.findViewById(R.id.enterMail);
        enterPh= (EditText) v.findViewById(R.id.enterPh);
        enterDob= (EditText) v.findViewById(R.id.enterDob);
        signupbut=(Button) v.findViewById(R.id.signupbut);
        signupbut.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {

        String entername = enterName.getText().toString();
        String enterph = enterPh.getText().toString();
        String enterdob = enterDob.getText().toString();
        String entermail = enterMail.getText().toString();
        String enterpass = enterPass.getText().toString();
        if (TextUtils.isEmpty(entername)) {
            enterName.setError("This field cannot be empty");
            return;
        } else if (TextUtils.isEmpty(enterph)) {
            enterPh.setError("This field cannot be empty");
            return;
        } else if (TextUtils.isEmpty(enterdob)) {
            enterDob.setError("This field cannot be empty");
            return;
        }else if (TextUtils.isEmpty(enterpass)) {
            enterPass.setError("This field cannot be empty");
            return;
        }
        else if( TextUtils.isEmpty(entermail) ) {
            enterMail.setError("Invalid Email");
            return;
        }
        else if(enterMail.getText().toString().contains("@")&& enterMail.getText().toString().contains(".com")){
            Toast.makeText(getActivity(), "ID Verified successfully", Toast.LENGTH_LONG).show();


        }else {
            enterMail.setError("Invalid ID");

            return;
        }



        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("User Info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("signUpMail", enterMail.getText().toString());
        editor.putString("password", enterPass.getText().toString());
        editor.putString("signUpName", enterName.getText().toString());
        editor.apply();
        editor.putBoolean("logged_in", true);
        editor.commit();


        LoginFragment loginFragment= new LoginFragment();
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,loginFragment,"loginFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
