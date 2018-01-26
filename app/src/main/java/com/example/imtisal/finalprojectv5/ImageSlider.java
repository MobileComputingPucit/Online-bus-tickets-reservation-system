package com.example.imtisal.finalprojectv5;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageSlider extends AppCompatActivity {
    ViewPager viewPager;
    ImageView imagerViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);
        imagerViewer =(ImageView) findViewById(R.id.imageViewer);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        Adapter viewPagerAdapter= new Adapter(this);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
