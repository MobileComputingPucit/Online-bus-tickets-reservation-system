package com.example.imtisal.finalprojectv5;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment implements View.OnClickListener {
    Button  btnVideo, btnNext;
    View v;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);

        btnVideo = (Button) v.findViewById(R.id.btnVid);
        btnNext = (Button) v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

        btnVideo.setOnClickListener(this);



        return v;
    }

   @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnVid:
             Intent intent= new Intent(getActivity(),Video.class) ;
                startActivity(intent);

                break;
            case R.id.btnNext:
                Intent intent1= new Intent(getActivity(),ImageSlider.class);
                startActivity(intent1);
                break;
        }
    }
}
