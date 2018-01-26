package com.example.imtisal.finalprojectv5;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView videoView1;
    TextView adParagraph;
    Uri uri;
    MediaController mediaC;
    String videopath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView1 = (VideoView) findViewById(R.id.videoView1);
        adParagraph = (TextView) findViewById(R.id.adParagraph);
        mediaC = new MediaController(Video.this);
        videoplay();

        String text = "<h1>About Us </h1>" +
                "<p><font size= \"24\" color='black'> Our Bus Services has integrated unique innovations to ensure security and affordability.\n" +
                " Among these are complete online reservation systems, online reservation hold/in \n" +
                "person payment at various locations, and electronic document handling. Our services was\n" +
                "the first service in Pakistan to introduce many modern technologies, including e-ticketing \n" +
                "and self check-in kiosk facilities.</font></p>";
        adParagraph.setText(Html.fromHtml(text));
    }

    public void videoplay() {
        videopath = "android.resource://"+ getPackageName()+ "/"+ R.raw.bus;
        uri = Uri.parse(videopath);
        videoView1.setVideoURI(uri);
        videoView1.setMediaController(mediaC);
        mediaC.setAnchorView(videoView1);
        videoView1.start();

    }
}
