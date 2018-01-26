package com.example.imtisal.finalprojectv5;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {
    Button volvoDir, daewooDir, niaziDir;

    View v;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        volvoDir = (Button) v.findViewById(R.id.volvoDir);
        daewooDir = (Button) v.findViewById(R.id.daewooDir);
        niaziDir = (Button) v.findViewById(R.id.niaziDir);
        volvoDir.setOnClickListener(this);
        niaziDir.setOnClickListener(this);
        daewooDir.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.daewooDir:
                Intent intent = new Intent(getActivity(), daewooMap.class);
                startActivity(intent);

                break;
            case R.id.volvoDir:
                Intent intent2 = new Intent(getActivity(), volvoMap.class);
                startActivity(intent2);

                break;
            case R.id.niaziDir:
                Intent intent3 = new Intent(getActivity(), niaziMap.class);
                startActivity(intent3);

                break;
        }
    }
}
